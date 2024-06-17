import json
import time
import urllib
from django.http import HttpResponse
import pymongo
import requests
import re
import random
import SparkApi
import BaiduApi


def getlist(request):
    l = [{'Alex': 3}, {'Belle': 1}, {'Cecilia': 5}]
    scores = {"value": l, "msg": "success", "code": 200}
    try:
        if request.method == 'GET':
            return HttpResponse(json.dumps(scores), content_type='application/json')
    except Exception as e:
        return HttpResponse(json.dumps({'code': '1', 'msg': str(e)}))


# 使用GPT的总API
# 接受前端header格式: {
#               time: formattedTime,//字符串,格式化的时间,有个严格的格式要求,详见前端
#               content: content,//字符串,问题内容
#               GPTType: this.value1,//字符串,GPT类型,目前是SparkV1,SparkV2,WenxinV3,WenxinV4
#             },
# 给后端返回的格式: {
#               'time': request.META['HTTP_TIME'], //字符串,前端发来的时间
#               'user': request.META['HTTP_REFERER'], //字符串,前端host地址
#               'question': question,//字符串,前端发来的问题
#               'answer': answer//字符串,GPT的回答
#               }

def askGPT(request):
    # l = [{'Alex': 3}]
    # scores = {"value": l, "msg": "success", "code": 200}
    # for i, j in request.META.items():
    #     print(i, j)
    # print(request.META['HTTP_ID'])
    # print(request.META['HTTP_TIME'])
    # print(request.META['HTTP_CONTENT'])
    # print(request.META['HTTP_GPTTYPE'])
    # print(urllib.parse.unquote(request.META['HTTP_CONTENT'], 'utf-8'))
    try:
        question = urllib.parse.unquote(request.META['HTTP_CONTENT'], 'utf-8')
        GPTType = request.META['HTTP_GPTTYPE']
        answer = getAnswer(question, GPTType)
        # 'user': request.META['HTTP_REFERER'],
        result = {'time': request.META['HTTP_TIME'], 'question': question,
                  'answer': answer, }
        # 本地测试的时候没有HTTP_REFERER这个参数，不知道为什么
        # 有了域名之后，API改为用域名访问了，之前的参数也没了，现在HTTP_X_REAL_IP是IP地址，真是搞不懂Axios
        if 'REMOTE_ADDR' in request.META:
            result['user'] = request.META['REMOTE_ADDR']
        else:
            result['user'] = 'TestUser'
        result['StatusCode']='1'
    except BaseException as e:
        # 打印异常的详细信息
        print("捕获到异常:", e)
        print("异常的类型是:", type(e))
        print("异常发生的跟踪记录:")
        import traceback
        traceback.print_exc()
        result = {'StatusCode':'0','time': request.META['HTTP_TIME'], 'answer':"Error in API" }
    # for i, j in result.items():
    #     print('{}: {}'.format(i, j))
    if request.method == 'GET':
        return HttpResponse(json.dumps(result), content_type='application/json')


# 存储到数据库
# 接受前端header格式: {
#                   time: formattedTime,//字符串,格式化的时间,有个严格的格式要求,详见前端
#                   GPTType: this.value1,//字符串,GPT类型,目前是SparkV1,SparkV2,WenxinV3,WenxinV4
#                   user: result['user'],//字符串,前端host地址
#                   question: encodeURI(result['question']),//字符串,前端发来的问题
#                   answer: encodeURI(result['answer']),//字符串,GPT的回答
#                 },
# 给后端返回的格式: {
#                   response['status'] = 1//整数,状态,成功为1,失败为0
#                   response['message'] = 'success'//字符串,消息,成功为success失败为fail
#               }

def saveToDB(request):
    # if 'HTTP_TIME' in request.META.keys():
    # print(request.META['HTTP_TIME'])
    # if 'HTTP_USER' in request.META:
    # print(request.META['HTTP_USER'])
    # if 'HTTP_QUESTION' in request.META:
    #     print(request.META['HTTP_QUESTION'])
    # if 'HTTP_ANSWER' in request.META:
    #     print(request.META['HTTP_ANSWER'])
    response = dict()
    try:
        result = {'time': request.META['HTTP_TIME'], 'GPTType': request.META['HTTP_GPTTYPE'],
                  'question': urllib.parse.unquote(request.META['HTTP_QUESTION'], 'utf-8'),
                  'answer': urllib.parse.unquote(request.META['HTTP_ANSWER'], 'utf-8'),
                  }
        if 'REMOTE_ADDR' in request.META:
            result['user'] = request.META['REMOTE_ADDR']
        else:
            result['user'] = 'TestUser'
        toDB(result)
        response['status'] = 1
        response['message'] = 'success'
    except:
        response['status'] = 0
        response['message'] = 'fail'
    finally:
        if request.method == 'GET':
            return HttpResponse(json.dumps(response), content_type='application/json')


def getAnswer(questionContent, option):
    answerContent = ''
    if option == 'SparkV1':
        SparkApi.answer = ''
        SparkApi.getSparkV1Answer([{'role': 'user', 'content': questionContent}])
        answerContent = SparkApi.answer
    elif option == 'SparkV2':
        SparkApi.answer = ''
        SparkApi.getSparkV2Answer([{'role': 'user', 'content': questionContent}])
        answerContent = SparkApi.answer
    elif option == 'SparkV3':
        SparkApi.answer = ''
        SparkApi.getSparkV3Answer([{'role': 'user', 'content': questionContent}])
        answerContent = SparkApi.answer
    elif option == 'WenxinV3':
        answerContent = BaiduApi.getWenxinV3Answer(questionContent)
    elif option == 'WenxinV4':
        answerContent = BaiduApi.getWenxinV4Answer(questionContent)
    # print(answerContent)
    answerContent = answerContent.replace('*', '')
    return answerContent


def toDB(dialog):
    # 连接数据库 URI: mongodb://用户名:密码@host:端口
    instance = pymongo.MongoClient('mongodb://************:******************@************:27017/*********', )
    # instance为实例,示例包含多个数据库,每个数据库可以包括多个集合(类似SQL的表)
    # 集合含有多个文档(类似SQL的行,一个集合,键只能是字符串而值可以是各种类型
    # 选择数据库nlsearch
    database = instance['nlsearch']
    # 选择集合dialogs
    collection = database['dialogs']
    # 插入文档
    collection.insert_one(dialog)
    # 关闭示例
    instance.close()


class DBManager:
    def __init__(self):
        self.DBInstance = pymongo.MongoClient('mongodb://****:******************@**************:27017/****', )
        self.database = self.DBInstance['user']
        self.collection = self.database['UserInformation']

    def queryAll(self):
        allUsers = self.collection.find()
        # for i in allUsers:
            # print(i['username'], i['password'])
        # print(allUsers)
        return allUsers
    
    def queryOneUser(self, username):
        result = [x for x in self.collection.find({'username': username}, {'_id': 0})]
        return result, len(result)
    
    def insertOneUser(self,userInfo):
        self.collection.insert_one(userInfo)
    
    def syncToServer(self,userID,tableName,newDocs):
        currrentCollection=self.database[tableName]
        deletedData=currrentCollection.delete_many({'userId':userID})
        print(deletedData.deleted_count,'已被删除')
        currrentCollection.insert_many(newDocs)
    
    def syncToDevice(self,userID,tableName):
        currrentCollection=self.database[tableName]
        allData=currrentCollection.find({'userId':userID},{'_id':0})
        return allData
    
    def checkUserIDExist(self,userID):
        if(len([x for x in self.collection.find({'userId':str(userID)})])==0):
            return False
        else:
            return True



def getUsername(request):
    # result = {}
    # try:
    #     userDB = DBManager()
    #     s = ""
    #     allUsers=userDB.queryAll()
    #     for i in allUsers:
    #         # result['users']['username'] = i['username']
    #         s += i['username'] + ' '
    #     result['username'] = s
    #     result['message'] = 'success'
    # except:
    #     result['message'] = 'Error'
    if request.method == 'GET':
        # result = {"id": "5", "version": "1.1", "name": "222333"}
        # try:
        #     for i, j in request.META.items():
        #         print(i, j)
        # except Exception:
        #     print(Exception)
        # return HttpResponse(json.dumps(result), content_type='application/json')
        return HttpResponse("Get请求")
    elif request.method == 'POST':
        result = {"id": "2", "version": "1.1", "name": "111111"}
        try:
            print(json.loads(request.body))
            # for i, j in request.POST:
            #     print(i, j)
        except Exception:
            print(Exception)
        finally:
        # return HttpResponse(json.dumps(result, content_type='application/json'))
            return HttpResponse("Post请求")
            
def checkUser(request):
    username = request.META['HTTP_USERNAME']
    db = DBManager()
    result, userNumber = db.queryOneUser(username)
    if userNumber == 0:
        return HttpResponse(json.dumps({'StatusCode': '0', 'Message': 'No such user.'}))
    elif userNumber == 1:
        return HttpResponse(json.dumps({'StatusCode': '1', 'Message': result[0]}))
    else:
        return HttpResponse(json.dumps({'StatusCode': '2', 'Message': 'Error in database'}))

def registerUser(request):
    try:
        db=DBManager()
        print('Request body is ',json.loads(request.body))
        newUserID=random.randint(1,1000000)
        while(db.checkUserIDExist(newUserID)):
            newUserID+=1
        newUserInformation={'userId':str(newUserID)}
        for i,j in json.loads(request.body).items():
            newUserInformation[i]=j
        print('New user information is ',newUserInformation)
        DBManager().insertOneUser(newUserInformation)
        return HttpResponse(json.dumps({'StatusCode': '1', 'Message': 'registerUser success'}))
    except BaseException as e:
        # 打印异常的详细信息
        print("捕获到异常:", e)
        print("异常的类型是:", type(e))
        print("异常发生的跟踪记录:")
        import traceback
        traceback.print_exc()
        return HttpResponse(json.dumps({'StatusCode':'0','Message':e}))

def syncFromDevice(request):
    try:
        print(json.loads(request.body))
        if 'HTTP_USERID' in request.META.keys():
            print('userID',request.META['HTTP_USERID'])
        if 'HTTP_TABLENAME' in request.META.keys():
            print('tableName', request.META['HTTP_TABLENAME'])
        DBManager().syncToServer(request.META['HTTP_USERID'],request.META['HTTP_TABLENAME'],json.loads(request.body))
        return HttpResponse(json.dumps({'StatusCode':'1','Message':'Success syncFromDevice.'}))
    except BaseException as e:
        # 打印异常的详细信息
        print("捕获到异常:", e)
        print("异常的类型是:", type(e))
        print("异常发生的跟踪记录:")
        import traceback
        traceback.print_exc()
        return HttpResponse(json.dumps({'StatusCode':'0','Message':e}))
    
def syncFromServer(request):
    try:
        if 'HTTP_USERID' in request.META.keys():
            print('userID',request.META['HTTP_USERID'])
        if 'HTTP_TABLENAME' in request.META.keys():
            print('tableName', request.META['HTTP_TABLENAME'])
        allDataCursor=DBManager().syncToDevice(request.META['HTTP_USERID'],request.META['HTTP_TABLENAME'])
        allData=[]
        for i in allDataCursor:
            allData.append(i)
        print('All data return',allData)
        return HttpResponse(json.dumps({'StatusCode':'1','Message':'Success SyncFromServer.','Data':allData}))
    except BaseException as e:
        # 打印异常的详细信息
        print("捕获到异常:", e)
        print("异常的类型是:", type(e))
        print("异常发生的跟踪记录:")
        import traceback
        traceback.print_exc()
        return HttpResponse(json.dumps({'StatusCode':'0','Message':e}))

if __name__ == '__main__':
    # result = {'time': '2023/11/15 22:53:00', 'user': 'user: http://localhost:81/', 'question': '你好啊！',
    #           'answer': 'Default Answer'}
    # toDB(result)
    # print(generateURL())
    # getAnswer('你是谁', 'SparkV1')
    db=DBManager()
    for i in db.queryAll():
        print(i)

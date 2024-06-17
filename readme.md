# # 2024-Spring-Computer-1-EasyStoring

# <img src="resources/ic_icon.png" title="" alt="" data-align="center">

# 收纳易

by 2024 春季课程第一组

### readme.md为Markdown格式的系统开发说明文件

### 另有PDF格式在开发文档文件夹中

# 系统开发说明文件

## 一、产品设计方案

### 1.项目实施可行性报告

#### **1.1** **项目介绍**

产品名称：收纳易

产品功能：产品主要用于辅助用户收纳物品

（1）物品记录与位置追踪

收纳易提供了强大的物品记录功能。用户可以通过拍照和文字描述的方式，记录每个物品的外观、特征以及存放位置。同时，应用会自动为用户生成物品的编号，作为物品的“身份证”，与物品的其它信息如图片、名称等关联起来，一同存储在软件中。当用户需要寻找某个物品时，只需打开应用，搜索物品的关键词，或在物品栏里寻找物品，即可迅速找到该物品的位置信息，省去了翻箱倒柜的烦恼。

（2）收纳柜管理

除了物品记录外，收纳易还提供了收纳柜管理功能。用户可以使用收纳易为多个收纳柜创建条形码或二维码编号，并在登记放入的物品时选择放入了哪个收纳柜（例如，在放置物品时可以扫描目标收纳柜的条形码或二维码，自动识别要放进哪个收纳柜中）。当用户点击对应收纳柜记录或扫描收纳柜的条形码或二维码时，应用会展示该收纳柜中所有物品的信息，让用户一目了然，轻松掌握收纳柜的存储情况。

（3）智能识别与自动登记

收纳易还具备智能识别功能。当用户扫描一个物品时，应用会自动识别并生成物品的名称，进而转化为记录还可以补充其它信息如物品的保质期、用途、图片等。这样，太用户无需手动输入物品信息，大大提高了操作效率。

（4）二手交易辅助

除了收纳管理功能外，收纳易还为用户提供了二手交易辅助。用户可以选择某个物品，应用会自动为用户生成闲鱼二手交易模板，包括物品描述、照片等信息，方便用户快速发布二手交易信息，做到收拾东西时及时断舍离。

（5）云端同步

收纳易提供云同步功能，可以将用户的数据同步到云服务器，实现多端数据同步，方便用户在其它设备登录时使用。

#### **1.2** **行业市场及同类产品分析**

目前应用商店上架的同类产品 App 有“收纳先生”“收纳狮”等，以下是分析：

#### **收纳狮**

“收纳狮”App 有记录物品、金额统计、条形码录入等功能。可以自定义物品的属性进行记录物品；还能按照物品的金额和数量统计以了解物品开销；还能通过扫描商品的条形码录入物品。此应用是深圳市励铭软件有限公司开发，在 oppo 应用市场有近 50 次下载，在 vivo 应用市场有约 1000 次下载。

缺点是缺少对物品的位置、类型等的归类功能，用户无法用它来管理各个收纳箱的各种物品；金额统计和条形码录入功能限制较多，必须填写金额才能纳入统计以及必须有条形码的商品才能够录入；还缺少二手交易辅助功能，这是我们的优势。

#### **收纳先生**

“收纳先生”App 有物品识别、物品查找、物品统计、物品定位、物品提醒、物品搭配等功能，可以对物品进行按类型、按空间分类和查找，还能通过扫描商品条形码导入物品、以及按照需求将几个物品搭配成一个组合，此外还有提醒物品的保质期/有效期/保修期等的功能。此应用是广州市四象限软件科技有限公司开发，在 oppo 应用市场有约 3.2 万次下载，在 vivo 应用市场有约 3.7 万次下载。

缺点是用户逻辑不是很符合通常的使用习惯，各个功能放在一起，主界面较为复杂，操作较为不便；部分功能描述不清或者没有合适的教程引导用户使用，难以上手。

但该软件功能已经较为完善，值得我们学习，并在此基础上新增一些我们独有的功能，例如利用 ai 智能识别物品和二手交易辅助等功能。

#### 总结

“收纳狮”的界面较为简洁、操作也较为简单。但功能较少，限制较多，因此用户下载量相对较少。而“收纳先生”功能较为完善，收纳能够满足不同用户的收纳需求，但界面不够简洁，导致上手较慢，虽然下载量相对“收纳狮”较高，但还有优化的空间。

因此智能收纳存在较多的用户需求，但需要考虑应用的功能、界面的美观、操作难易等方面对用户体验的影响。竞品还有很大的改进空间，市场份额还未饱和。

### 2.产品定位及目标

### **2.1** **产品定位**

智能、便捷、高效的家居管理工具，旨在帮助用户整理、分类、管理各类物品，让家居生活更加整洁、有序。

### **2.2** **目标用户**

1. 家庭主妇：整理家务、管理家庭物品的需求较高；

2. 学生：整理学习资料、生活用品的需求；

3. 上班族：整理办公用品、文件资料的需求；

4. 收藏爱好者：管理收藏品的需求。

### 产品内容总策划

#### 第一阶段（4 月 1 日，第六周）

完成产品方案设计。

#### 第二阶段（4 月 29 日，第十周）

完成 UI 部分的开发，制作文档和视频，重点展示 UI 和界面动效。

#### 第三阶段（6 月 3 日，第十五周）

完成 App 主要功能并进行多种测试，准备汇报材料。

#### 结题（6 月 11 日前）

以项目组为单位提交项目文档，完成个人课程设计报告上传。

### 技术解决方案

1. 物品记录与位置追踪以及收纳柜管理等功能：实现较为简单，可以使用 Kotlin 语言，使用 Android Studio 直接开发。

2. 用户指导：使用动图或视频等方式引导用户学习使用软件。

3. 二手交易辅助功能：根据物品生成对应的描述，可以使用内容生成式人工智能，例如 ChatGPT、文心一言等接口。

4. 云端同步功能：使用云服务器功能，已有搭建好的腾讯云服务器。

5. 初步 UI 逻辑设计
   
   ![](/resources/UI%20Design.jpg)

### 推广方案

#### 推广渠道

1. 社交媒体：在微博、抖音、微信公众号等平台发布产品介绍、使用教程、收纳技巧等内容，增加产品曝光度；
2. 论坛、社区：在豆瓣、知乎等论坛、社区发布产品广告，吸引用户关注；
3. 合作推广：与家居、生活类 APP 或平台合作，进行互推。

#### 推广内容

1. 产品功能介绍：详细阐述软件的各项功能，如分类管理、提醒功能、云同步等；
2. 使用教程：发布图文或视频教程，教用户如何使用软件进行物品收纳；
3. 收纳技巧：分享实用的收纳技巧，吸引用户关注，提高产品口碑；
4. 用户案例：展示成功案例，让用户看到使用产品后的实际效果；

#### 推广效果评估

1. 关注度：关注产品官方微博、微信公众号等社交媒体的用户数量；
2. 下载量：统计各大应用商店的下载量，了解产品市场占有率；
3. 活跃用户：统计活跃用户数量，了解产品粘性；
4. 用户反馈：收集用户反馈，了解产品优缺点，不断优化产品。

### 运营规划书

#### **产品优化**

1. 根据用户反馈和市场需求，不断优化产品功能和界面设计；

2. 定期更新收纳技巧、资讯等内容，满足用户需求；

3. 加强与其他家居、生活类 APP 或平台的合作，更新更多实用功能。

#### 用户运营

1. 建立用户社群，如微信群、QQ 群等，方便用户交流收纳心得，增强产品粘性；

2. 举办线上活动，如收纳大赛、晒家活动等，激发用户参与度；

3. 鼓励用户生成内容，如分享收纳技巧、晒家图片等，提高产品口碑。

#### **市场推广**

持续进行线上推广，如社交媒体、论坛、社区等，增加产品曝光度。

#### 数据分析

1. 定期分析用户数据，了解用户需求和喜好，优化产品和运营策略；

2. 监测市场动态，及时调整推广策略，提高市场占有率；

3. 分析竞争对手，学习借鉴其优点，不断提升自身竞争力。

## 二、产品实现方案

### 1.系统的主要功能

#### 用户注册和登录

后端建有用户信息数据库存储用户用户名、ID 和密码等信息，进入应用时通过用户名和密码核实用户信息登录或注册，并使用应用类中的静态变量记录当前登录用户信息。

```kotlin
class EasyStoringApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        // 当前登录用户ID
        lateinit var userID: String
        lateinit var username: String
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}
```

实现效果（App开屏界面、注册、登录）

<img title="" src="resources/Screenshot_20240617_181733.png" alt="" width="209"><img title="" src="resources/Screenshot_20240617_181908.png" alt="" width="209"><img title="" src="resources/Screenshot_20240617_181946.png" alt="" width="209">

#### 云同步用户数据

为了实现用户数据换多设备同步而实现的功能，分为前端实现和后端实现两部分，使用 OkHTTP3 网络功能和网络数据库交互，并写有完善的异常处理机制和大量调试输出，最终实现的效果很完美，可以很好实现跨设备同步用户数据。前端数据库共有两张表存储当前登录用户的物品和收纳柜信息，后端数据库共有两个集合存储所有用户的物品和收纳柜信息。

![](/resources/2024-06-16-22-42-09-image.png)

![](/resources/2024-06-16-22-42-23-image.png)

#### 本地信息存放在SQLite数据库

从云端同步当前用户的物品和收纳柜信息，将其存放到本地的SQLite数据库中，方便不同Activity和Fragment之间读取、更新、删除、添加用户的物品和收纳柜信息。使用AppDBHelper类辅助访问SQLite数据库中的数据。AppDBHelper类中有获取指定表中总行数函数、获取指定表中所有行、在指定表中插入行、由id删除物品表中指定行、由id删除收纳柜表中指定行、更新指定表、将本地数据同步到云端、将云端数据同步到本地等函数

```kotlin
class AppDBHelper (val context: Context, name: String, version: Int):
    SQLiteOpenHelper(context,name, null, version){

    private val createCupboard = "create table Cupboard(" +
            " id integer primary key autoincrement," +
            " userId integer, " +
            " name text, " +
            " description text)"
    private val createItem = "create table Item(" +
            " id integer primary key autoincrement," +
            " userId integer, " +
            " imageId text, " +
            " name text, " +
            " description text, " +
            " number integer, " +
            " productionDate text, " +
            " overdueDate text, " +
            " cupboardId integer)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createCupboard)
        db.execSQL(createItem)
        }

    // .......其他函数.....
}
```

物品表

![屏幕截图 2024-06-17 234548.png](D:\2024-Spring-Computer-1-EasyStoring\resources\屏幕截图%202024-06-17%20234548.png)

收纳柜表

![屏幕截图 2024-06-17 234617.png](D:\2024-Spring-Computer-1-EasyStoring\resources\屏幕截图%202024-06-17%20234617.png)

#### 物品的查看、新增、修改、删除

在物品列表界面，点击recycleView的任意项，可查看物品详情，详情界面可以上下滑动查看信息，以下是长截屏

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/ItemInfomation.jpg" title="" alt="" width="121">

在物品列表界面或顶栏点击“+”可以跳转到添加物品界面新增物品；新增的物品会添加到本地数据库，并同步到云端。物品列表界面会从本地数据库中将新增的物品添加到物品列表的recycleView中。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718641125684.jpg" title="" alt="" width="187">        <img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/ItemList.jpg" alt="" width="177">

在物品详情界面修改后点击“确定”按钮可以更新物品信息；用户点击确定后会检查物品详情界面的EditTextView是否改变，若改变则会更新本地数据库和ItemList，并提醒recycleView更新数据。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/c9a1b97b019aec66a70b336f04d6069.jpg" title="" alt="" width="158">        <img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/39daee81570c1a48e0a5d1fef460b21.jpg" alt="" width="199">

点击物品列表中的“删除”按钮可以删除物品；物品的被ItemAdater从列表中移除并从本地数据库中删除，同时同步到云端数据库。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718640821337.jpg" title="" alt="" width="340">

#### 收纳柜的查看，新增，删除

在收纳柜列表界面，点击recycleView的任意项，可查看收纳柜中的物品，同样可以点击物品项查看物品详情，点击“删除”删除物品

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/SelectCupboard.jpg" title="" alt="" width="182">

在收纳柜列表界面点击“+”按钮，跳转到添加空间界面，输入名称和描述后点击确定可以新增收纳柜。    

<img src="resources/1718641713453.jpg" title="" alt="" width="194">        <img src="resources/cc4fe2b7e857018437b9cfc415b06f4.jpg" title="" alt="" width="186">        <img title="" src="resources/9e4e90127053cd2dbbce7d91d5061dd.jpg" alt="" width="185">

同样点击“删除”按钮可以删除收纳柜

![](D:\2024-Spring-Computer-1-EasyStoring\resources\1718642254357.jpg)

#### AI 二手交易辅助

调用后端服务器的 API 实现，服务器调用文心一言 API 来获得二手物品描述，并可以一键复制描述到剪贴板，方便去其它二手交易平台进行交易。

<img title="" src="resources/Screenshot_20240617_121306.png" alt="" width="271">            <img title="" src="resources/Screenshot_20240617_121241.png" alt="" width="271">

### 2.UI 界面设计

#### 主要界面设计

登录界面                                                           AI 交易助手界面

<img title="" src="resources/2024-06-16-19-00-19-image.png" alt="" width="289">        <img title="" src="resources/2024-06-16-19-01-40-image.png" alt="" width="288">

物品记录界面                                物品记录详情                    添加物品    

（使用recycleView实现）                             

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/ItemList.jpg" title="" alt="" width="175">           <img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/ItemInfomation.jpg" alt="" width="131">        <img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/AddItem.jpg" alt="" width="133">

收纳柜管理界面                         收纳柜详情                              收纳柜添加

使用recycleView实现                使用recycleView实现

<img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/cupboardList.jpg" alt="cupboardList.jpg" width="178">       <img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/SelectCupboard.jpg" alt="" width="178">        <img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/addCupboard.jpg" alt="" width="169">

#### 顶栏设计

![](resources/2024-06-16-19-03-58-image.png)

使用 Toolbar 实现，设置图标标识出侧拉菜单功能和添加功能

#### 侧拉菜单设计

<img title="" src="resources/2024-06-16-19-05-23-image.png" alt="" width="313">

使用 DrawerLayout 实现，包含和账户相关的一些操作和用户名、用户头像和邮箱的显示

#### 底部导航栏设计

![](resources/2024-06-16-19-07-28-image.png)

使用 BottomNavigationView+ViewPager2 实现，可以切换嵌套在 MainActivity 中的三个 Fragment，并自定义了图标和文字选中时的效果。

#### 应用图标设计

直接采用现有的成套图标，保证全应用美术风格的一致性

[iconfont-阿里巴巴矢量图标库](https://www.iconfont.cn/collections/detail?cid=13720)

![](resources/2024-06-16-19-15-05-image.png)

#### 应用配色设计

认真学了学配色，感觉故宫的配色比较顶级，所以借了故宫配色的书籍，直接选了四组有浅有深的蓝绿配色，可以在按钮或其它很多地方成套使用，非常方便。

colors.xml 文件中定义的颜色：

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="Yumen">#A2D2E2</color>
    <color name="Xizi">#87C0CA</color>
    <color name="Tianshuibi">#5AA4AE</color>
    <color name="Facui">#108B96</color>
    <color name="Tianpiao">#D5EBE1</color>
    <color name="Canglang">#B1D5C8</color>
    <color name="Cangliang">#99BCAC</color>
    <color name="Piaobi">#80A492</color>
</resources>
```

选用配色：

![](resources/2024-06-16-19-23-29-ebe0c21655f5b14338de9b45c6b459f.jpg)

#### 应用图标设计

![](resources/ic_icon.png)

选用现有插画，能用明亮的配色表现出我们 App 的主要功能和使用范围。

### 3.关键技术和技术难点

#### 数据库功能实现

##### 前端数据库 SQLite

数据库辅助类实现：AppDBHelper类中有获取指定表中总行数函数、获取指定表中所有行、在指定表中插入行、由id删除物品表中指定行、由id删除收纳柜表中指定行、更新指定表、将本地数据同步到云端、将云端数据同步到本地等函数

```kotlin
class AppDBHelper (val context: Context, name: String, version: Int):
    SQLiteOpenHelper(context,name, null, version){

    private val createCupboard = "create table Cupboard(" +
            " id integer primary key autoincrement," +
            " userId integer, " +
            " name text, " +
            " description text)"
    private val createItem = "create table Item(" +
            " id integer primary key autoincrement," +
            " userId integer, " +
            " imageId text, " +
            " name text, " +
            " description text, " +
            " number integer, " +
            " productionDate text, " +
            " overdueDate text, " +
            " cupboardId integer)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createCupboard)
        db.execSQL(createItem)
        }

    // 重建指定表    
    fun rebuildTable( db: SQLiteDatabase,tableName:String){
        when(tableName){
            "Cupboard"->{
                db.execSQL("DROP TABLE IF EXISTS Cupboard")
                db.execSQL(createCupboard)
            }
            "Item"->{
                db.execSQL("DROP TABLE IF EXISTS Item")
                db.execSQL(createItem)
            }
        }
    }

    // 获取指定表的行数
    fun getRowCount(db: SQLiteDatabase,tableName: String): Int {
        val cursor: Cursor
        try {
            cursor = db.rawQuery("SELECT COUNT(*) FROM $tableName", null)
            if (cursor.moveToFirst()) {
                return cursor.getInt(0)
            }
            cursor.close()
        } catch (e:Exception) {
            Log.d("error",e.message!!)
        }
        // 如果没有行，返回0
        return 0
    }
    fun insertItem(db: SQLiteDatabase, Item1: Item){
        val values = ContentValues().apply {
            // 组装数据
            put("id",Item1.id)
            put("userId", Item1.userId)
            put("imageId",Item1.imageId)
            put("name",Item1.name)
            put("description",Item1.description)
            put("number", Item1.number)
            put("productionDate",Item1.productionDate)
            put("overdueDate", Item1.overdueDate)
            put("cupboardId", Item1.cupboardId)
        }
        db.insert("Item", null, values)
    }

    fun insertCupboard(db: SQLiteDatabase, cupboard: Cupboard) {
        val values = ContentValues().apply {
            // 组装数据
            put("id",cupboard.id)
            put("userId", cupboard.userId)
            put("name",cupboard.name)
            put("description",cupboard.description)
        }
        db.insert("Cupboard", null, values)
    }

    fun delItemById(db: SQLiteDatabase,id: Int){
        db.delete("Item", "id = ?", arrayOf(id.toString()))
    }
    fun delCupboardById(db: SQLiteDatabase,id: Int){
        db.delete("Cupboard", "id = ?", arrayOf(id.toString()))
    }
    fun updateItem(db: SQLiteDatabase, Item1: Item){
        val values = ContentValues().apply {
            // 组装数据
            put("id",Item1.id)
            put("userId", Item1.userId)
            put("imageId",Item1.imageId)
            put("name",Item1.name)
            put("description",Item1.description)
            put("number", Item1.number)
            put("productionDate",Item1.productionDate)
            put("overdueDate", Item1.overdueDate)
            put("cupboardId", Item1.cupboardId)
        }
        // 执行更新操作
        val updatedRows = db.update("Item", values, "id=?",
            arrayOf(Item1.id.toString()))
    }

    // 本地同步到云端
    fun DeviceToSever(db: SQLiteDatabase){
        // 代码过长，详情见AppDBHelper文件
    }

    // 云端同步到本地
    fun SeverToDevice(db: SQLiteDatabase){
        // 代码过长，详情见AppDBHelper文件
    }
}
```

##### 后端数据库 MongoDB

数据库类实现：

```python
class DBManager:
    def __init__(self):
        self.DBInstance = pymongo.MongoClient('mongodb://User:k3PnJ3FBxFseb5tH@1.15.173.30:27017/user', )
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
```

#### RecycleView及相应Adapter实现

**初始化物品列表ItemList：**

清空ItemList，从本地数据库中读取所有物品信息，存入IemList中

```kt
private fun initItem() {
        ItemList.clear()
        val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM Item WHERE userId = ?", arrayOf(EasyStoringApplication.userID))

        var ItemNum = 0
        // 遍历查询结果
        if (cursor.moveToFirst()) {
            do {
                ItemNum++
                val item1: Item = Item(EasyStoringApplication.userID.toInt())
                try {
                    item1.id = cursor.getInt(cursor.getColumnIndex("id"))
                    item1.userId = cursor.getInt(cursor.getColumnIndex("userId"))
                    item1.name = cursor.getString(cursor.getColumnIndex("name"))
                    item1.imageId = cursor.getString(cursor.getColumnIndex("imageId"))
                    item1.cupboardId = cursor.getString(cursor.getColumnIndex("cupboardId")).toInt()
                    item1.productionDate = cursor.getString(cursor.getColumnIndex("productionDate"))
                    item1.overdueDate = cursor.getString(cursor.getColumnIndex("overdueDate"))
                    item1.description = cursor.getString(cursor.getColumnIndex("description"))
                    item1.number = cursor.getString(cursor.getColumnIndex("number")).toInt()
                    ItemList.add(item1)
                } catch (e: Exception) {
                    Log.d("error1", "An error occurred: " + e.message) // 最好包括异常的消息
                }
            } while (cursor.moveToNext())
        }

        // 关闭游标和数据库
        cursor.close()
        db.close()
    }
```

**物品列表的RecycleView：**

将ItemList中的数据通过ItemAdapter导入到RecycleView中。

```kotlin
        initItem()
        recyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        adapter = ItemAdapter(requireContext(), ItemList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter
```

**物品的Adapter：**

实现在recycleView列表中显示相应信息；实现点击项目跳转到物品详情界面，并将点击的物品的id传过去；实现点击删除按钮后，从列表、本地数据库中删除对应的物品，并同步到云端数据库中。

```kt
class ItemAdapter(private val context: Context, val itemList:MutableList<Item>) :
    // 这个函数修改显示的内容
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val ItemImage: ImageView = view.findViewById(R.id.itemImage)
        val ItemName: TextView = view.findViewById(R.id.itemName)
        val belongTo: TextView = view.findViewById(R.id.item_belongTo)
        val productionDate: TextView = view.findViewById(R.id.item_productionDate)
        val ItemNum: TextView = view.findViewById(R.id.item_num)
        val del:Button = view.findViewById(R.id.button7)
    }
    // 收纳柜字典
    var cupboardNameMap  = mutableMapOf<Int, String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_item, parent, false)
        val viewHolder = ViewHolder(view)

        val dbHelper = AppDBHelper(viewHolder.itemView.context, "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase
        val cupboards = dbHelper.getAllRowsFromMyTable(db,"Cupboard")
        try {
            if (cupboards.isNotEmpty()) {
                for (i in 0..<cupboards.count()) {
                    cupboardNameMap[cupboards[i]["id"].toString().toInt()] =
                        cupboards[i]["name"].toString()
                }
            }
        }catch (e:Exception){
            Log.d("error2",e.message!!)
        }

        // 点击整个事件
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            val item = itemList[position]
            // 点击事件后，跳转界面，传信息
            try {
                val intent = Intent(viewHolder.itemView.context, ItemActivity::class.java).apply {
                    putExtra("position", position.toString())
                    putExtra("itemId",item.id.toString())
                }
                viewHolder.itemView.context.startActivity(intent)
            }
            catch (e:Exception){
                Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
            }
        }
        // 点击图片
        viewHolder.ItemImage.setOnClickListener {

        }

        viewHolder.del.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                // 通知Adapter删除该项
                this.removeItem(position)
            }
        }
        return viewHolder
    }

    // 填入信息
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.ItemName.text = item.name
        holder.ItemName.typeface = Typeface.DEFAULT_BOLD
        holder.productionDate.text = item.productionDate
        if (cupboardNameMap.containsKey(item.cupboardId))
            holder.belongTo.text = cupboardNameMap[item.cupboardId]
        else{
            holder.belongTo.text ="默认收纳柜"
            itemList[position].cupboardId = -1
        }
        holder.ItemNum.text = "×${item.number}"
    }

    override fun getItemCount()=itemList.size
    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(position: Int) {
        // 检查位置是否有效
        if (position in 0 until itemCount) {
            // 从列表中移除项并从数据库中删除
            val delItem = itemList.removeAt(position)
            val ItemId = delItem.id
            val dbHelper = AppDBHelper(context, "EasyStoring.db", 1)
            val db = dbHelper.writableDatabase
            dbHelper.delItemById(db, ItemId)
            dbHelper.DeviceToSever(db)
            // 通知RecyclerView项已被移除
            notifyItemRemoved(position)

            // 如果列表为空，可能还需要通知数据集变化
            if (itemList.isEmpty()) {
                notifyDataSetChanged()
            }
        }
    }
}
```

**收纳柜的RecycleView和Adapter:**

实现过程与物品的类似，不在此赘述

#### 侧滑菜单和底部导航栏实现

**底部导航栏：**

使用 BottomNavigationView+ViewPager2 方案实现 Fragment 切换进而达到切换页面的效果。

实现代码

```kotlin
val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //去除自带的选中颜色,去除后文字和图片选择效果就是跟我们自定义的效果一样
        binding.navView.itemIconTintList = null

        //将所有的Fragment添加到ViewPager2中
        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(HomeFragment())
        fragmentList.add(UserInformation())
        fragmentList.add(AssistantFragment())
        binding.navViewpage2.adapter = ViewPager2Adapter(this, fragmentList)

        //当viewpage2页面切换时，nav导航图标也跟着切换
        binding.navViewpage2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.navView.menu.getItem(position).isChecked = true
            }
        })

        // 禁用手动左右滑动切换界面
        binding.navViewpage2.isUserInputEnabled = false

        // 当nav导航点击切换时，viewpager2也跟着切换页面
        // 原来是设置currentItem来切换，这里改成函数，并且禁用切换动画
        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navRecords -> {
//                    binding.navViewpage2.currentItem = 0
                    binding.navViewpage2.setCurrentItem(0, false)
                    return@setOnItemSelectedListener true
                }

                R.id.navManage -> {
//                    binding.navViewpage2.currentItem = 1
                    binding.navViewpage2.setCurrentItem(1, false)
                    return@setOnItemSelectedListener true
                }

                R.id.navAssistant -> {
//                    binding.navViewpage2.currentItem = 2
                    binding.navViewpage2.setCurrentItem(2, false)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
```

```html
<androidx.constraintlayout.widget.ConstraintLayout
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:layout_below="@id/toolbar"
  tools:context=".MainActivity"
>
  <com.google.android.material.bottomnavigation.BottomNavigationView
    android:id="@+id/nav_view"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_marginStart="0dp"
    android:layout_marginEnd="0dp"
    android:background="#ffffff"
    app:itemTextColor="@color/nav_bottom_txt_select"
    app:labelVisibilityMode="labeled"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:menu="@menu/bottom_nav_menu"
  />

  <androidx.viewpager2.widget.ViewPager2
    android:id="@+id/nav_viewpage2"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_constraintBottom_toTopOf="@id/nav_view"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent"
  />
</androidx.constraintlayout.widget.ConstraintLayout>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/navRecords"
        android:icon="@drawable/ic_records"
        android:title="物品记录" />

    <item
        android:id="@+id/navManage"
        android:icon="@drawable/ic_manage"
        android:title="收纳柜管理" />

    <item
        android:id="@+id/navAssistant"
        android:icon="@drawable/ic_assistant"
        android:title="交易助手" />

</menu>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:color="@color/Tianshuibi" android:state_selected="true" />
    <item android:color="@color/Cangliang" android:state_selected="false" />
</selector>
```

**侧滑菜单：**

使用 DrawerLayout 实现侧栏，并自定义 NavigationView 实现用户操作菜单，自定义 nav_header 实现用户信息展示布局。

```xml
    <com.google.android.material.navigation.NavigationView
        android:id="@+id/sideNavView"
        android:layout_width="250dp"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        app:headerLayout="@layout/nav_header"
        app:menu="@menu/nav_menu" />
```

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="180dp"
    android:background="@color/Xizi"
    android:padding="10dp">

    <de.hdodenhof.circleimageview.CircleImageView
        android:id="@+id/avatarImage"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:layout_centerInParent="true"
        android:src="@drawable/avatar" />

    <TextView
        android:id="@+id/mailText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:text="anon1soyo0@gmail.com"
        android:textColor="#FFF"
        android:textSize="14sp" />

    <TextView
        android:id="@+id/userText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_above="@id/mailText"
        android:text="Chihaya Anon"
        android:textColor="#FFF"
        android:textSize="20sp" />
</RelativeLayout>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:showIn="navigation_view">
    <group android:checkableBehavior="single">
        <item
            android:id="@+id/navFav"
            android:icon="@drawable/ic_favorite"
            android:title="收藏" />
        <item
            android:id="@+id/navHis"
            android:icon="@drawable/ic_history"
            android:title="浏览历史" />
        <item
            android:id="@+id/navFam"
            android:icon="@drawable/ic_family"
            android:title="家庭" />
        <item
            android:id="@+id/settings"
            android:icon="@drawable/settings"
            android:title="设置" />
        <item
            android:id="@+id/logout"
            android:icon="@drawable/logout"
            android:title="退出账号" />
    </group>
</menu>
```

#### AI 二手交易辅助实现

**前端实现**

根据商品名称生成一段提示词并提供给 GPT 的 API 接口，由 GPT（此处选用讯飞星火 V3.5 大模型）生成描述（暂未实现选择商品）

```kotlin
        binding.generateButton.setOnClickListener {
            try {
                runBlocking {
                    var answer: Map<String, Any>? = null
                    var statusCode: String? = null
                    var response = async {
                        var temp: Response? = null
                        runBlocking {
                            // 需要EncodeURI为UTF-8格式
                            // 现在我想卖出一个二手${binding.textView10.text}，请写一个二手商品描述，要能吸引人购买
                            // 现在我想卖出一个二手${binding.textView10.text}，请写一个二手商品描述，要能吸引人购买，100字以内即可
                            val URLString = URLEncoder.encode(
                                "现在我想卖出一个二手${binding.textView10.text}，请写一个二手商品描述，要能吸引人购买，100字以内即可",
                                "utf-8"
                            )
                            Log.d("2333", "$URLString, ${URLDecoder.decode(URLString, "utf-8")}")
                            val getRequest =
                                Request.Builder().url("${NetworkService.baseURL}/askGPT")
                                    .header("content", URLString).header("GPTType", "SparkV3")
                                    .header("time", "2333").get()
                                    .build()
                            val call = NetworkService.httpClient.newCall(getRequest)
                            temp = withContext(Dispatchers.IO) {
                                call.execute()
                            }
                            Log.d("2333", temp.toString())
                        }
                        temp
                    }.await()
                    response?.body?.string()?.let {
                        Log.d("2333", it)
                        answer = Gson().fromJson(
                            it,
                            Map::class.java
                        ) as Map<String, Any>?
                        Log.d("2333", "AI generating answer: $answer")
                        binding.editTextTextMultiLine.setText(answer?.get("answer").toString())
                        statusCode = answer?.get("StatusCode").toString()
                    }
                    Log.d("2333", "status code $statusCode")
                    when (statusCode) {
                        "0" -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "生成失败",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                        "1" -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "生成成功",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                        else -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "服务器错误",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "生成失败 请重试", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
                Log.d("2333", "AI generating ${e.stackTrace}")
            }
        }
```

复制到剪贴板

```kotlin
binding.copyButton.setOnClickListener {
            val clipboard =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData =
                ClipData.newPlainText("Description", binding.editTextTextMultiLine.text)
            Log.d("2333", "copy content: ${binding.editTextTextMultiLine.text}")
            clipboard.setPrimaryClip(clip)
            Toast.makeText(requireContext(), "已复制到剪贴板", Toast.LENGTH_SHORT).show()
        }
```

**后端实现**

```python
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
    try:
        question = urllib.parse.unquote(request.META['HTTP_CONTENT'], 'utf-8')
        GPTType = request.META['HTTP_GPTTYPE']
        answer = getWenxinV4Answer(question)
        result = {'time': request.META['HTTP_TIME'], 'question': question,
                  'answer': answer, }
        # 本地测试的时候没有HTTP_REFERER这个参数，不知道为什么
        # 有了域名之后，API改为用域名访问了，之前的参数也没了，现在HTTP_X_REAL_IP是IP地址，真是搞不懂Axios
        if 'REMOTE_ADDR' in request.META:
            result['user'] = request.META['REMOTE_ADDR']
        else:
            result['user'] = 'TestUser'
    except:
        result = {'time': request.META['HTTP_TIME'], 'answer': 'Error at API'}
    if request.method == 'GET':
        return HttpResponse(json.dumps(result), content_type='application/json')

def getSparkV3Answer(question):
    wsParam = Ws_Param(appid, api_key, api_secret, Spark_urlV3)
    websocket.enableTrace(False)
    wsUrl = wsParam.create_url()
    ws = websocket.WebSocketApp(wsUrl, on_message=on_message, on_error=on_error, on_close=on_close, on_open=on_open)
    ws.appid = appid
    ws.question = question
    ws.domain = domainV3
    ws.run_forever(sslopt={"cert_reqs": ssl.CERT_NONE})
```

#### 云同步功能实现

**前端实现**

推送函数，将目前设备上的用户数据推送到服务器上。用于本地用户数据有变化时使用，可以保持云端数据和本地数据一致。

```kotlin
            val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
            val db = dbHelper.writableDatabase
            val allCupboards = dbHelper.getAllRowsFromMyTable(db, "Cupboard")
            val allItems = dbHelper.getAllRowsFromMyTable(db, "Item")
            for (i in allItems)
                Log.d("2333", i.toString())
            for (i in allCupboards)
                Log.d("2333", i.toString())
            // 同步Items
            try {
                runBlocking {
                    var statusCode = async {
                        var temp = ""
                        runBlocking {
                            val jsonString = Gson().toJson(allItems)
                            val jsonBody =
                                jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
                            val postRequest =
                                Request.Builder().url("${NetworkService.baseURL}/syncFromDevice")
                                    .header("userID", EasyStoringApplication.userID).header("tableName", "Items")
                                    .post(jsonBody)
                                    .build()
                            val call = NetworkService.httpClient.newCall(postRequest)
                            val response = withContext(Dispatchers.IO) {
                                call.execute()
                            }
                            Log.d("2333", response.toString())
                            response.body?.string()?.let {
                                Log.d("2333", it)
                                val response: MutableMap<*, *> = Gson().fromJson(
                                    it,
                                    MutableMap::class.java
                                )
                                temp = response.get("StatusCode").toString()
                                Log.d("2333", "SyncFromDevice status $temp")
                                response.get("Message")?.toString().let {
                                    Log.d("2333", "SyncFromDevice message $it")
                                }
                            }
                        }
                        temp
                    }.await()
                    when (statusCode) {
                        "0" -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "云同步到服务器失败",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                        "1" -> {
                            // 同步Cupboards
                            delay(100)
                            runBlocking {
                                var statusCode = async {
                                    var temp = ""
                                    runBlocking {
                                        val jsonString = Gson().toJson(allCupboards)
                                        val jsonBody =
                                            jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
                                        val postRequest =
                                            Request.Builder()
                                                .url("${NetworkService.baseURL}/syncFromDevice")
                                                .header("userID", EasyStoringApplication.userID)
                                                .header("tableName", "Cupboards")
                                                .post(jsonBody)
                                                .build()
                                        val call = NetworkService.httpClient.newCall(postRequest)
                                        val response = withContext(Dispatchers.IO) {
                                            call.execute()
                                        }
                                        Log.d("2333", response.toString())
                                        response.body?.string()?.let {
                                            Log.d("2333", it)
                                            val response: MutableMap<*, *> = Gson().fromJson(
                                                it,
                                                MutableMap::class.java
                                            )
                                            temp = response.get("StatusCode").toString()
                                            Log.d("2333", "SyncFromDevice status $temp")
                                            response.get("Message")?.toString().let {
                                                Log.d("2333", "SyncFromDevice message $it")
                                            }
                                        }
                                    }
                                    temp
                                }.await()
                                when (statusCode) {
                                    "0" -> {
                                        Toast.makeText(
                                            EasyStoringApplication.context,
                                            "云同步到服务器失败",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
                                    }

                                    "1" -> {
                                        Toast.makeText(
                                            EasyStoringApplication.context,
                                            "云同步到服务器成功",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }

                                    else -> {
                                        Toast.makeText(
                                            EasyStoringApplication.context,
                                            "数据库错误",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
                                    }
                                }
                            }
                        }

                        else -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "数据库错误",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }
            } catch (e: Exception) {
                Log.d("2333", "Exception: ${e.message}")
            }
```

拉取函数，用于将服务器用户数据同步到本地。一般在首次进入应用时使用，确保用户更换设备登录后可以数据同步。

```kotlin
        try {
                runBlocking {
                    var itemsResponse = async {
                        var res: MutableMap<*, *>? = null
                        runBlocking {
                            val getRequest =
                                Request.Builder().header("userID", EasyStoringApplication.userID)
                                    .header("tableName", "Items")
                                    .url("${NetworkService.baseURL}/syncFromServer")
                                    .get()
                                    .build()
                            val call = NetworkService.httpClient.newCall(getRequest)
                            val response = withContext(Dispatchers.IO) {
                                call.execute()
                            }
                            Log.d("2333", response.toString())
                            response.body?.string()?.let {
                                Log.d("2333", it)
                                res = Gson().fromJson(
                                    it,
                                    MutableMap::class.java
                                )
                            }
                        }
                        res
                    }.await()
                    if (itemsResponse == null) {
                        Log.d("2333", "Null response in syncFromServer")
                        Toast.makeText(
                            EasyStoringApplication.context,
                            "云同步到设备失败",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        val statusCode = itemsResponse["StatusCode"]
                        val message = itemsResponse["Message"]
                        Log.d("2333", "syncFromServer status code: $statusCode, message: $message")
                        when (statusCode) {
                            "0" -> {
                                Toast.makeText(
                                    EasyStoringApplication.context,
                                    "云同步到设备失败",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }

                            "1" -> {
                                // 服务器拉取的当前用户ID的所有Items
                                items = itemsResponse["Data"]?.let {
                                    it as List<Map<String, Any>>
                                }
                                delay(100)
                                // 拉取当前用户ID的所有Cupboards
                                runBlocking {
                                    var cupboardsResponse = async {
                                        var res: MutableMap<*, *>? = null
                                        runBlocking {
                                            val getRequest =
                                                Request.Builder().header("userID", EasyStoringApplication.userID)
                                                    .header("tableName", "Cupboards")
                                                    .url("${NetworkService.baseURL}/syncFromServer")
                                                    .get()
                                                    .build()
                                            val call = NetworkService.httpClient.newCall(getRequest)
                                            val response = withContext(Dispatchers.IO) {
                                                call.execute()
                                            }
                                            Log.d("2333", response.toString())
                                            response.body?.string()?.let {
                                                Log.d("2333", it)
                                                res = Gson().fromJson(
                                                    it,
                                                    MutableMap::class.java
                                                )
                                            }
                                        }
                                        res
                                    }.await()
                                    if (cupboardsResponse == null) {
                                        Log.d("2333", "Null response in syncFromServer")
                                        Toast.makeText(
                                            EasyStoringApplication.context,
                                            "云同步到设备失败",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
                                    } else {
                                        val statusCode = cupboardsResponse["StatusCode"]
                                        val message = cupboardsResponse["Message"]
                                        Log.d(
                                            "2333",
                                            "syncFromServer status code: $statusCode, message: $message"
                                        )
                                        when (statusCode) {
                                            "0" -> {
                                                Toast.makeText(
                                                    EasyStoringApplication.context,
                                                    "云同步到设备失败",
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()
                                            }

                                            "1" -> {
                                                cupboards = cupboardsResponse["Data"]?.let {
                                                    it as List<Map<String, Any>>
                                                }
                                                if (cupboards != null) {
                                                    Toast.makeText(
                                                        EasyStoringApplication.context,
                                                        "云同步到设备成功",
                                                        Toast.LENGTH_SHORT
                                                    )
                                                        .show()
                                                } else
                                                    Toast.makeText(
                                                        EasyStoringApplication.context,
                                                        "云同步到设备失败",
                                                        Toast.LENGTH_SHORT
                                                    )
                                                        .show()
                                            }

                                            else -> {
                                                Toast.makeText(
                                                    EasyStoringApplication.context,
                                                    "数据库错误",
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()
                                            }
                                        }
                                    }
                                }
                            }

                            else -> {
                                Toast.makeText(
                                    EasyStoringApplication.context,
                                    "数据库错误",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.d("2333", "Exception: ${e.message}")
            }
            val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
            val db = dbHelper.writableDatabase
            if (items != null && cupboards != null) {
                for (map in items!!) {
                    val item = Item(map["userId"].toString().toInt())
                    item.id = map["id"].toString().toInt()
                    item.imageId = map["imageId"].toString()
                    item.name = map["name"].toString()
                    item.number = map["number"].toString().toInt()
                    item.description = map["description"].toString()
                    item.cupboardId = map["cupboardId"].toString().toInt()
                    item.productionDate = map["productionDate"].toString()
                    item.overdueDate = map["overdueDate"].toString()
                    dbHelper.insertItem(db, item)
                }

                for (map in cupboards!!) {
                    val cupboard = Cupboard(map["userId"].toString().toInt())
                    cupboard.id = map["id"].toString().toInt()
                    cupboard.name = map["name"].toString()
                    cupboard.description = map["description"].toString()
                    dbHelper.insertCupboard(db, cupboard)
                }
                initItem()
                adapter.notifyDataSetChanged() // 刷新RecyclerView的UI
                for (i in items!!)
                    Log.d("2333", "$i")
                for (i in cupboards!!)
                    Log.d("2333", "$i")
            }
```

**后端实现**

后端服务器主要是用 Python 的网络项目 Django 做的，数据库选用的是 MongoDB，简洁好用，可以自动生成主键。

接收从设备同步来的数据：

```python
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
```

向设备发送云端数据：

```python
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
```

### 4.用户体验记录和分析

用户A：界面整体看起来很清爽。在不同设备上登录同一个账号也能够同步账号的信息，很方便。但好像搜索功能不能用，希望能够实现以下，方便到时候东西多了后快速查找。物品的日期那里，可不可以改成选择日期，不想手动输入。像下面这样：

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/5baaf2aee120d0d3da725ce089641688_.jpg" title="" alt="" width="198">

        分析：搜索功能由于时间和技术问题，没有实现，今后会多多研究，争取将搜索功能实现，才能更方便用户在收纳更多的东西时快速查找。日期输入确实是没有考虑到用户的体验优化，之后会研究添加一个日期选择器。

用户B：

        删除默认收纳柜，但物品位置还是在默认收纳柜中

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20012958.png" title="" alt="屏幕截图 2024-06-18 012958.png" width="400">

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20013743.png" title="" alt="屏幕截图 2024-06-18 013743.png" width="190"><img src="file:///C:/Users/阿卡特兰/AppData/Roaming/marktext/images/2024-06-18-01-38-21-image.png" title="" alt="" width="224">

        收纳柜重名问题

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20013241.png" title="" alt="屏幕截图 2024-06-18 013241.png" width="406">

        数量合法性问题

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20013502.png" title="" alt="屏幕截图 2024-06-18 013502.png" width="231">

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20013637.png" title="" alt="屏幕截图 2024-06-18 013637.png" width="182">

        分析：由于物品的实现逻辑需要每个物品都有对应的收纳柜，因此将默认收纳柜设置为不可删除，避免用户将默认收纳柜删除后，无法在收纳柜列表中找到存放于默认收纳柜中的物品。

        收纳柜同名确实会造成冲突，经过测试，同名时，只有最早创建的收纳柜中会有物品，后创建的同名收纳柜为空。在收纳柜新建时检查重名，如重名则提示“新建失败，已有此数据库”，应该就可以解决问题。而数据确实缺少合法性检查，应用的健壮性不足，应多考虑用户非法输入的情况。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20013407.png" title="" alt="屏幕截图 2024-06-18 013407.png" width="441">

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20013149.png" title="" alt="屏幕截图 2024-06-18 013149.png" width="446">

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20013542.png" title="" alt="屏幕截图 2024-06-18 013542.png" width="422">

        用户C：好像注册时有点问题，我点注册就闪退了，再注册时提示“用户已存在”，结果发现可以直接登录了。用户界面的默认头像很可爱，还有交易辅助界面的fufu玩偶也可爱，只可惜不能选自己添加的物品，不过可以自动生成物品的描述，期待选择物品生成描述的功能真正实现的时候。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/cb3aa9b9f0eafdd20c763c58d972ab2.jpg" title="" alt="" width="157">    <img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20015252.png" title="" alt="" width="189">

        分析：注册时有概率闪退，目前还不清楚原因，但第一次注册成功并登录后，再进行注册就不会闪退了，这种概率性遇到的bug很难找到原因，由于时间关系，且问题不影响使用，会在之后尽力排查原因。AI交易辅助界面的物品选择暂时还没有完成，会在后续的开发和学习中实现。

        用户D：应用很不错，挺实用的，给年龄大的人用，给东西多的上班族用都可以。不过添加物品时遇到问题了，数量不填或填非数字时会添加失败。希望加多点说明

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/屏幕截图%202024-06-18%20020051.png" title="" alt="屏幕截图 2024-06-18 020051.png" width="312">

<img src="file:///C:/Users/阿卡特兰/AppData/Roaming/marktext/images/2024-06-18-02-03-47-image.png" title="" alt="" width="313">

        分析：应用的目标人群确实包含了记忆力不佳的老年人、物品较多较杂的上班族和学生党。不过提到了老年人，应该设计更清晰的使用说明和引导，将界面设计应设计得清晰，降低学习成本。添加物品的“数量”一栏只能够输入数字，没有考虑到用户可能不熟悉应用而造成困扰。应该添加一些提示性语句在输入框前，并检查用户的输入，避免因用户输入不当造成程序崩溃，应在输入不当数据时进行提示。

### 5.已完成的改进

1. 用户登录和注册问题已实现，可以完美做到基本使用和云端信息同步，可以通过网络连接云端，在不同设备上登录同一个账号。

2. 服务器同步到设备和设备同步到服务器这两部分都顺利实现。

3. AI二手交易辅助功能部分实现。

4. 整体的UI设计进行了改进，使得界面简洁清新。由原本的深蓝色背景改为了白色背景+明亮图案和按钮的组合，整体更加协调明亮。界面还统一设计了toolbar，在toolbar上实现返回功能而不是在按钮上，更加美观和谐。

### 6.仍然存在的问题

1. 顶栏原本准备设计查找功能，但发现在Toolbar里嵌套一个View来实现搜索框效果无法达到预期，没有实现。在做这方面时深感现有的各种UI布局并不符合国内App开发的UI风格和习惯，如果要深入改进则需要自己根据现有布局自定义新的布局类型，这需要进一步研读现有UI元素的源代码并改进，应该作为未来学习的方向。

2. AI交易辅助仅实现AI接口的网络连接，未实现选择一个商品进行生成描述的功能。这个是因为现有开发内容量非常大，一路上出了无数没想过的问题，所以没能完善这一功能，只实现了固定一个示例物品的描述生成。

3. 云同步和用户功能还比较简陋，仅能支持基本的用户注册和登录，以及用户物品和收纳柜信息的云同步。严格来说，云同步功能应该具有相当复杂的同步逻辑才能实现多用户和家庭等功能的运行，但是我的能力还不足以实现；还有用户登录的过期等综合性的问题没有解决，这个可以通过为用户生成Token等方法改进，但是太过于复杂现阶段还无法完成。

4. 用户设置和浏览记录未实现。这两个功能均需要做App内的前端界面和后端数据库对应的API来实现，但是出于和3一样的原因放弃了。

5. 缺少对用户的非法输入的应对，应用健壮性不足，虽然通过try catch语句尽量避免了应用崩溃，但用户非法输入时，不能正常实现功能，需要后续多多进行测试并修改。

6. 用户修改物品的收纳柜后，物品记录列表recycleView无法及时刷新。其他栏修改后，列表及时刷新成新的信息。只有物品的收纳柜一栏被修改后，对应物品在recycleView中仍然是修改前的收纳柜，而数据库以及物品详情界面都成功修改，表明应该只是列表刷新的问题，退出应用重新打开后，列表中的物品的收纳柜会刷新为修改后的收纳柜，暂时没有找到解决方法。

## 三、测试大纲和测试报告

#### 标准兼容测试

采用腾讯云测服务，共测试了38款机型，其中只有2款失败，原因是安装失败，设备名称为“小米 MIX4”和“realme V11”，通过率为94.74%

![屏幕截图 2024-06-18 055833.png](D:\2024-Spring-Computer-1-EasyStoring\resources\屏幕截图%202024-06-18%20055833.png)

![屏幕截图 2024-06-18 060349.png](D:\2024-Spring-Computer-1-EasyStoring\resources\屏幕截图%202024-06-18%20060349.png)

![屏幕截图 2024-06-18 060604.png](D:\2024-Spring-Computer-1-EasyStoring\resources\屏幕截图%202024-06-18%20060604.png)



## 四、产品安装和使用说明

### 产品安装

1.获取apk文件后（项目根目录下的app-release.apk），使用浏览器打开，点击安装。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/89fa77750683dc0c1155c632b996c39.jpg" title="" alt="89fa77750683dc0c1155c632b996c39.jpg" width="191">

2.由于本应用暂时没有上架任何应用商店，也未进行备案，在安装时会提示风险，但本应用一定没有任何窃取隐私、投放病毒等威胁用户信息安全的行为，无视风险安装即可。安装完成即可打开应用。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/6017e4260a432d6e08155d89622bd52.jpg" title="" alt="6017e4260a432d6e08155d89622bd52.jpg" width="191">

### 使用说明

##### 注册与登录

打开应用后，若已有账号，输入账号密码登录即可；若第一次使用本应用，输入新的账号和密码，点击注册按钮，等待注册成功后再登录即可，无需绑定手机号等个人信息。

<img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/2024-06-16-19-00-19-image.png" alt="2024-06-16-19-00-19-image.png" width="168">            <img title="" src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/Screenshot_20240617_181946.png" alt="" width="168">

##### 下方导航栏与左侧侧栏

登录成功后，点击下方导航栏可以切换“物品记录”、“收纳柜管理”、“交易助手”等界面。点击屏幕左上图标可以弹出侧栏，点击侧栏的“退出账号”可以退出当前用户，其余功能暂未实现。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/2024-06-16-19-07-28-image.png" title="" alt="2024-06-16-19-07-28-image.png" width="358">

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/2024-06-16-19-05-23-image.png" title="" alt="2024-06-16-19-05-23-image.png" width="166">

##### 物品记录界面

在物品记录界面可查看所有物品列表。点击任意一项可以查看物品详细信息；点击任意一项的删除按钮可以删除该项；点击右上角或右下角“+”按钮可以添加物品。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718652158211.jpg" title="" alt="1718652158211.jpg" width="163">

        查看物品详情时，可以修改物品的信息，点击确定后会返回物品记录界面，并更新物品的信息。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718652518264.jpg" title="" alt="1718652518264.jpg" width="166">

        添加物品时，可以输入物品信息，信息无误后点击确定，可成功添加物品。注意：数量一栏必须填写，且必须填写整数，否则会添加失败；位置一栏应填写已有的收纳柜名字，若填写其它，也可以成功添加物品，但位置一栏会自动变为“默认收纳柜”。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718652798961.jpg" title="" alt="1718652798961.jpg" width="166">

##### 收纳柜界面

在收纳柜界面可以查看所有收纳柜列表。点击任意一项收纳柜可以查看收纳柜中的物品列表；点击任意一项收纳柜的删除按钮可以删除该项收纳柜；点击右下角“+”按钮可以添加收纳柜。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718652975883.jpg" title="" alt="1718652975883.jpg" width="194">

        查看收纳柜中的物品列表时，与物品记录界面类似，点击任意一项可以查看物品详细信息、点击任意一项的删除按钮可以删除该物品。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718653064137.jpg" title="" alt="1718653064137.jpg" width="198">

        添加收纳柜时，可以输入收纳柜信息，信息无误后点击确定可成功添加收纳柜。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718653173523.jpg" title="" alt="1718653173523.jpg" width="194">

##### 交易助手界面

在交易助手界面，点击“生成描述”按钮，AI会生成对物品的描述，以便进行二手交易；点击“复制描述”可以将生成的描述复制到剪贴板，以便粘贴到二手交易平台。选择物品进行描述的功能暂未实现。

<img src="file:///D:/2024-Spring-Computer-1-EasyStoring/resources/1718653343901.jpg" title="" alt="1718653343901.jpg" width="194">

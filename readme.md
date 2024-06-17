# # 2024-Spring-Computer-1-EasyStoring

# <img src="resources/ic_icon.png" title="" alt="" data-align="center">

# 收纳易

by 2024 春季课程第一组

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

   ![](.\resources\UI%20Design.jpg)

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

#### 云同步用户数据

为了实现用户数据换多设备同步而实现的功能，分为前端实现和后端实现两部分，使用 OkHTTP3 网络功能和网络数据库交互，并写有完善的异常处理机制和大量调试输出，最终实现的效果很完美，可以很好实现跨设备同步用户数据。前端数据库共有两张表存储当前登录用户的物品和收纳柜信息，后端数据库共有两个集合存储所有用户的物品和收纳柜信息。

![](.\resources\2024-06-16-22-42-09-image.png)

![](.\resources\2024-06-16-22-42-23-image.png)

#### AI 二手交易辅助

调用后端服务器的 API 实现，服务器调用文心一言 API 来获得二手物品描述，并可以一键复制描述到剪贴板，方便去其它二手交易平台进行交易。

<img src="resources/Screenshot_20240617_121306.png" title="" alt="" width="307"><img title="" src="resources/Screenshot_20240617_121241.png" alt="" width="307">

### 2.UI 界面设计

#### 主要界面设计

登录界面                                                           AI 交易助手界面

<img title="" src="C:/Users/Administrator/AppData/Roaming/marktext/images/2024-06-16-19-00-19-image.png" alt="" width="319"><img title="" src="C:/Users/Administrator/AppData/Roaming/marktext/images/2024-06-16-19-01-40-image.png" alt="" width="320">

物品记录界面                                                              物品记录详情

收纳柜管理界面                                                          收纳柜详情

#### 顶栏设计

![](.\resources\2024-06-16-19-03-58-image.png)

使用 Toolbar 实现，设置图标标识出侧拉菜单功能和添加功能

#### 侧拉菜单设计

<img title="" src="./resources/2024-06-16-19-05-23-image.png" alt="" width="313">

使用 DrawerLayout 实现，包含和账户相关的一些操作和用户名、用户头像和邮箱的显示

#### 底部导航栏设计

![](.\resources\2024-06-16-19-07-28-image.png)

使用 BottomNavigationView+ViewPager2 实现，可以切换嵌套在 MainActivity 中的三个 Fragment，并自定义了图标和文字选中时的效果。

#### 应用图标设计

直接采用现有的成套图标，保证全应用美术风格的一致性

[iconfont-阿里巴巴矢量图标库](https://www.iconfont.cn/collections/detail?cid=13720)

![](.\resources\2024-06-16-19-15-05-image.png)

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

![](.\resources\2024-06-16-19-23-29-ebe0c21655f5b14338de9b45c6b459f.jpg)

#### 应用图标设计

![](D:\2024-Spring-Computer-1-EasyStoring\resources\ic_icon.png)

选用现有插画，能用明亮的配色表现出我们 App 的主要功能和使用范围。

### 3.关键技术和技术难点

#### 数据库功能实现

##### 前端数据库 SQLite

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

### 5.已完成的改进和存在的问题

## 三、测试大纲和测试报告

## 四、产品安装和使用说明
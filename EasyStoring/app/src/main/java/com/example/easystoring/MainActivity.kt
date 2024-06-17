package com.example.easystoring

import ViewPager2Adapter
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.easystoring.databinding.ActivityMainBinding
import com.example.easystoring.logic.model.AppDBHelper
import com.example.easystoring.ui.AdditemActivity.AddActivity
import com.example.easystoring.ui.AdditemActivity.AddCupboardActivity
import com.example.easystoring.ui.UserInformation.UserInformation
import com.example.easystoring.ui.assistant.AssistantFragment
import com.example.easystoring.ui.home.HomeFragment
import com.squareup.picasso.Picasso
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("RestrictedApi", "Recycle", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建SQLite数据库
        val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase

        dbHelper.rebuildTable(db, "Cupboard")
        dbHelper.rebuildTable(db, "Item")
        //同步到本地
        dbHelper.SeverToDevice(db)

        var CupboardNum = 0
        var ItemNum = 0
        var cursor: Cursor?

        try {
            cursor = db.rawQuery("SELECT COUNT(*) FROM CupBoard", null)
            cursor.moveToFirst()
            CupboardNum = cursor.getInt(0)
            cursor = db.rawQuery("SELECT COUNT(*) FROM Item", null)
            cursor.moveToFirst()
            ItemNum = cursor.getInt(0)
            cursor.close()
        } catch (e: Exception) {
            Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
        }
//
//        // 测试添加柜子
//        val values2 = ContentValues().apply {
//            // 组装数据
//            CupboardNum++
//            put("id", CupboardNum)
//            put("userId", 1)
//            put("name", "书架")
//            put("description", "1234567")
//        }
//        db.insert("Cupboard", null, values2)
//
////         测试添加物品
//        val ItemColumns = arrayOf(
//            "id", "userId", "imageId", "name", "description",
//            "number", "productionDate", "overdueDate", "cupboardId"
//        )
//        val values3 = ContentValues().apply {
//            // 组装数据
//            ItemNum++
//            put("id", ItemNum)
//            put("userId", 1)
//            put("imageId", "")
//            put("name", "book1")
//            put("description", "第一行代码")
//            put("number", 1)
//            put("productionDate", "2023-3-29")
//            put("cupboardId", 1)
//        }
//        db.insert("Item", null, values3)
//        val values4 = ContentValues().apply {
//            // 组装数据
//            ItemNum++
//            put("id", ItemNum)
//            put("userId", 1)
//            put("imageId", "")
//            put("name", "book3")
//            put("description", "第二行代码")
//            put("number", 2)
//            put("productionDate", "2023-3-29")
//            put("cupboardId", 1)
//        }
//        db.insert("Item", null, values4)
//        val values5 = ContentValues().apply {
//            // 组装数据
//            ItemNum++
//            put("id", ItemNum)
//            put("userId", 2)
//            put("imageId", "")
//            put("name", "book1")
//            put("description", "第三行代码")
//            put("number", 3)
//            put("productionDate", "2023-3-29")
//            put("cupboardId", 1)
//        }
//        db.insert("Item", null, values5)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //去除自带的选中颜色,去除后文字和图片选择效果就是跟我们自定义的效果一样
        binding.navView.itemIconTintList = null

        //将所有的Fragment添加到ViewPager2中
        val fragmentList: MutableList<Fragment> = ArrayList()
//        fragmentList.add(TestFragment())
        fragmentList.add(HomeFragment())
        fragmentList.add(UserInformation())
        fragmentList.add(AssistantFragment())
//        fragmentList.add(AssistantFragment())
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

        // 顶部导航栏相关设置
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayShowTitleEnabled(false)
        }
        toolbar.setNavigationIcon(R.mipmap.ic_sidebar)
        toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
//        binding.text.visibility= View.VISIBLE
//        https://blog.51cto.com/u_16175472/7870679

        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.scan -> {
//                    toolbar.showOverflowMenu()
//                    Toast.makeText(this, "Scan", Toast.LENGTH_SHORT).show()
                    when (binding.navViewpage2.currentItem) {
                        0 -> startActivity(Intent(this, AddActivity::class.java))
                        1 -> startActivity(Intent(this, AddCupboardActivity::class.java))
                        2 -> startActivity(Intent(this, AddActivity::class.java))
                    }
                }

//                R.id.item2 -> {
//                    Toast.makeText(this, "Item2", Toast.LENGTH_SHORT).show()
//                }
            }
            true
        }
        // 侧栏
        val sideNavView = binding.sideNavView
        sideNavView.itemIconTintList = null
        sideNavView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navFav -> {
                    Toast.makeText(
                        EasyStoringApplication.context,
                        "Favorite",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                R.id.navHis -> {
                    Toast.makeText(
                        EasyStoringApplication.context,
                        "History",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                R.id.navFam -> {
                    Toast.makeText(
                        EasyStoringApplication.context,
                        "Family",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                R.id.settings -> {
                    Toast.makeText(
                        EasyStoringApplication.context,
                        "Settings",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            true
        }
        // 设置头像、用户名
        val userText = sideNavView.getHeaderView(0).findViewById<TextView>(R.id.userText)
        userText.text = EasyStoringApplication.username
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        val userMail = List(Random.nextInt(6, 11)) { allowedChars.random() }.joinToString("")
        val userMailText = sideNavView.getHeaderView(0).findViewById<TextView>(R.id.mailText)
        userMailText.text = "$userMail@gmail.com"
        try {
            val avatarImage = sideNavView.getHeaderView(0).findViewById<ImageView>(R.id.avatarImage)
            val list = listOf(
                "http://1.15.173.30:923/i/2024/06/16/k758zv.jpg",
                "http://1.15.173.30:923/i/2024/06/16/k759aq.png",
                "http://1.15.173.30:923/i/2024/06/16/k75b27.jpg",
                "http://1.15.173.30:923/i/2024/06/16/k756o6.jpg",
                "http://1.15.173.30:923/i/2024/06/16/k756az.png",
                "http://1.15.173.30:923/i/2024/06/16/k75isa.png",
                "http://1.15.173.30:923/i/2024/06/16/k75dzv.png",
                "http://1.15.173.30:923/i/2024/06/16/k75imk.png",
                "http://1.15.173.30:923/i/2024/06/16/k75q3b.png",
                "http://1.15.173.30:923/i/2024/06/16/k75qcw.jpg",
                "http://1.15.173.30:923/i/2024/06/16/k75l1j.png",
                "http://1.15.173.30:923/i/2024/06/16/k75ozi.jpg",
                "http://1.15.173.30:923/i/2024/06/16/k75l3x.png",
                "http://1.15.173.30:923/i/2024/06/16/k75qu8.png",
                "http://1.15.173.30:923/i/2024/06/16/k75qn1.png",
                "http://1.15.173.30:923/i/2024/06/16/k75l3f.jpg",
                "http://1.15.173.30:923/i/2024/06/16/k75y5x.png",
                "http://1.15.173.30:923/i/2024/06/16/k75um3.jpg",
                "http://1.15.173.30:923/i/2024/06/16/k75u2k.png",
                "http://1.15.173.30:923/i/2024/06/16/k75v5n.jpg",
                "http://1.15.173.30:923/i/2024/06/16/k75tjo.png",
                "http://1.15.173.30:923/i/2024/06/08/vfuns0.png"
            )
            val randomImageURL = list[Random.nextInt(list.size)]
            Picasso.get().load(randomImageURL).into(avatarImage)
        } catch (e: Exception) {
            Log.d("2333", "Avatar error: ${e.message}")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    //    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        when (item.itemId) {
////            android.R.id.home->binding.drawerLayout.openDrawer(GravityCompat.START)
//        }
//        return true
//    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("需要授权访问储存")
                val items = arrayOf("前往授权", "暂不授权")
                builder.setItems(items) { dialog, which ->
                    when (items[which]) {
                        "前往授权" -> {
                            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            val uri = Uri.fromParts("package", packageName, null)
                            intent.data = uri
                            startActivity(intent)
                        }

                        "暂不授权" -> {
                            Toast.makeText(this, "无访问通讯录权限", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                builder.create().show()
            }
        }

    }
}
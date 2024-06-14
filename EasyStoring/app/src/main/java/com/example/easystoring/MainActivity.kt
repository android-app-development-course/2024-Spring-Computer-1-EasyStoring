package com.example.easystoring

import ViewPager2Adapter
import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
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
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi", "Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建SQLite数据库
        val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase
//        dbHelper.rebuildTable(db,"User")
        dbHelper.rebuildTable(db,"Cupboard")
        dbHelper.rebuildTable(db,"Item")

        var UserNum = 0
        var CupboardNum = 0
        var ItemNum = 0
        var cursor: Cursor?


        try {
            cursor = db.rawQuery("SELECT COUNT(*) FROM User", null)
            cursor.moveToFirst()
            UserNum =  cursor.getInt(0)
            cursor = db.rawQuery("SELECT COUNT(*) FROM CupBoard", null)
            cursor.moveToFirst()
            CupboardNum =  cursor.getInt(0)
            cursor = db.rawQuery("SELECT COUNT(*) FROM Item", null)
            cursor.moveToFirst()
            ItemNum =  cursor.getInt(0)
            cursor.close()
        } catch (e:Exception) {
            Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
        }
        val values1 = ContentValues().apply {
            // 组装数据
            UserNum ++
            put("id",UserNum)
            put("username", "John Doe")
            put("password","123456")
            put("firstName","John")
            put("lastName","Doe")
//            put("age", 30)
        }
//        db.insert("User", null, values1)
        val values2 = ContentValues().apply {
            // 组装数据
            CupboardNum ++
            put("id", CupboardNum)
            put("userId", 1)
            put("name","书架")
            put("description","1234567")
        }
        db.insert("Cupboard", null, values2)

        val ItemColumns = arrayOf("id", "userId","imageId","name", "description",
            "number", "productionDate", "overdueDate", "cupboardId")
        val values3 = ContentValues().apply {
            // 组装数据
            ItemNum ++
            put("id",ItemNum)
            put("userId", 1)
            put("imageId",1)
            put("name","book1")
            put("description","第一行代码")
            put("number", 1)
            put("productionDate","2023-3-29")
            put("cupboardId", 1)
//            put("age", 30)
        }
        db.insert("Item", null, values3)
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
                    if (binding.navViewpage2.currentItem == 0)
                        startActivity(Intent(this, AddActivity::class.java))
                    else if (binding.navViewpage2.currentItem == 1)
                        startActivity(Intent(this, AddCupboardActivity::class.java))
                    else if (binding.navViewpage2.currentItem == 2)
                        startActivity(Intent(this, AddActivity::class.java))
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
}
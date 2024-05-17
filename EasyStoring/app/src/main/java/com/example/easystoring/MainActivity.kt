package com.example.easystoring

import ViewPager2Adapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.easystoring.databinding.ActivityMainBinding
import com.example.easystoring.ui.assistant.AssistantFragment
import com.example.easystoring.ui.dashboard.DashboardFragment
import com.example.easystoring.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //去除自带的选中颜色,去除后文字和图片选择效果就是跟我们自定义的效果一样
        binding.navView.itemIconTintList = null

        //将所有的Fragment添加到ViewPager2中
        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(HomeFragment())
        fragmentList.add(DashboardFragment())
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

        // 顶部导航栏、侧栏相关设置
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.mipmap.ic_sidebar)
        toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
//        toolbar.set
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
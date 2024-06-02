package com.example.easystoring

import ViewPager2Adapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.easystoring.databinding.ActivityMainBinding
import com.example.easystoring.ui.assistant.AssistantFragment
import com.example.easystoring.ui.dashboard.DashboardFragment
import com.example.easystoring.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //去除自带的选中颜色,去除后文字和图片选择效果就是跟我们自定义的效果一样
        binding.navView.itemIconTintList = null

        //将所有的Fragment添加到ViewPager2中
        val fragmentList: MutableList<Fragment> = ArrayList()
//        fragmentList.add(UserInformation())
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

        // 顶部导航栏相关设置
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.let{
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
                    toolbar.showOverflowMenu()
                    Toast.makeText(this, "Scan", Toast.LENGTH_SHORT).show()
                }

                R.id.item2 -> {
                    Toast.makeText(this, "Item2", Toast.LENGTH_SHORT).show()
                }
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
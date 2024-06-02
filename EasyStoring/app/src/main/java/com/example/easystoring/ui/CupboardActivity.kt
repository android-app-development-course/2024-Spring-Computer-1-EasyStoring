package com.example.easystoring.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.Item
import com.example.easystoring.ItemAdapter
import com.example.easystoring.R
import com.example.easystoring.databinding.FragmentHomeBinding
import com.example.easystoring.ui.home.HomeViewModel
import kotlin.random.Random

class CupboardActivity : AppCompatActivity() {


    private val ItemList = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cupboard)

        initItem()
        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = ItemAdapter(ItemList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initItem(){
        for(i in 1..10) {
            val item1: Item = Item(1)
            item1.id = i.toLong()
            item1.name = "Item$i"
            item1.imageId = R.drawable.item_pic
            item1.cupboardId = Random.nextInt(2)
            item1.productionDate = "2024-2-25"
            item1.number = Random.nextInt(10)
            ItemList.add(item1)
        }
    }
}
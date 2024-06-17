package com.example.easystoring.ui
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.Item
import com.example.easystoring.ItemAdapter
import com.example.easystoring.R
import com.example.easystoring.logic.model.AppDBHelper

class CupboardActivity : AppCompatActivity() {
    private val ItemList = ArrayList<Item>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    var cupboardId:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cupboard)
        cupboardId = intent.getStringExtra("cupboardId").toString().toInt()
        val cupboardName = intent.getStringExtra("cupboardName").toString()
        val toolbar1:androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        toolbar1.setTitleTextColor(Color.BLACK)
        toolbar1.setTitle("收纳柜")
        toolbar1.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        setSupportActionBar(toolbar1)
        toolbar1.setNavigationOnClickListener {
            finish()
        }

        val cupboardNameText = findViewById<TextView>(R.id.cupboardName)
        cupboardNameText.setText(cupboardName)

        initItem(cupboardId)
        recyclerView = findViewById(R.id.recyclerView2)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = ItemAdapter(this, ItemList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter

    }
    @SuppressLint("Range")
    private fun initItem(cupboardId: Int) {
        ItemList.clear()
        val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM Item WHERE userId = ? and cupboardId = ?",
            arrayOf(EasyStoringApplication.userID,
                cupboardId.toString()))

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
                    Log.d("error_cup_act", "An error occurred: " + e.message) // 最好包括异常的消息
                }
            } while (cursor.moveToNext())
        }

        // 关闭游标和数据库
        cursor.close()
        db.close()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        initItem(cupboardId)
        adapter.notifyDataSetChanged()
    }
}





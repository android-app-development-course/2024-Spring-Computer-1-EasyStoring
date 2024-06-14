package com.example.easystoring.logic.model

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.easystoring.Cupboard
import com.example.easystoring.R

class DBShow : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbshow)


        val dbShowText = findViewById<TextView>(R.id.dbshowText)
        // 创建SQLite数据库
        val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase
        val userColumns = arrayOf("id", "username","firstName","lastName","age")
        val cupboardColumns = arrayOf("id", "userId","name","description")
        val ItemColumns = arrayOf("id", "userId","imageId","name", "description",
            "number", "productionDate", "overdueDate", "cupboardId")
        try {
            val userData = dbHelper.getAllFromMyTable(db,"User",userColumns)
            val cupboardData = dbHelper.getAllFromMyTable(db,"Cupboard",cupboardColumns)
            val ItemData = dbHelper.getAllFromMyTable(db,"Item",ItemColumns)
            dbShowText.text ="User:\n" + userData.toString() +
                    "\nCupboard:\n" + cupboardData +
                    "\nItem:\n" + ItemData
        }catch (e: Exception) { // 指定捕获 Exception 类型
            Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
        }
        db.close()

        var back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            finish()
        }
    }

}
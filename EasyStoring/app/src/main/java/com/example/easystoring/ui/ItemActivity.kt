package com.example.easystoring.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.easystoring.R
import com.example.easystoring.logic.model.AppDBHelper
import java.lang.Exception

class ItemActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Range", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val toolbar1:androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        toolbar1.setTitleTextColor(Color.BLACK)
        toolbar1.setTitle("物品详情")
        toolbar1.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        setSupportActionBar(toolbar1)
        toolbar1.setNavigationOnClickListener {
            finish()
        }

        val name = findViewById<TextView>(R.id.editText1)
        val num = findViewById<TextView>(R.id.editText2)
        val description = findViewById<TextView>(R.id.editText7)
        val pdate = findViewById<TextView>(R.id.editText4)
        val vdate = findViewById<TextView>(R.id.editText5)
        val location = findViewById<TextView>(R.id.editText8)

        val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase
        val itemId = intent.getStringExtra("itemId")
        var cursor = db.rawQuery("SELECT * FROM Item WHERE id = ?", arrayOf(itemId))
        cursor.moveToFirst()
        val nameText = cursor.getString(cursor.getColumnIndex("name"))
        val imageIDText = cursor.getString(cursor.getColumnIndex("imageId"))
        val number = cursor.getString(cursor.getColumnIndex("number"))
        val descriptionText = cursor.getString(cursor.getColumnIndex("description"))
        val pdateText = cursor.getString(cursor.getColumnIndex("productionDate"))
        val vdateText = cursor.getString(cursor.getColumnIndex("overdueDate"))
        val cupboardId = cursor.getString(cursor.getColumnIndex("cupboardId"))

        try {
            name.setText(nameText)
            num.setText(number)
            description.setText(descriptionText)
            pdate.setText(pdateText)
            vdate.setText(vdateText)
            cursor = db.rawQuery("SELECT * FROM Cupboard WHERE id = ?", arrayOf(cupboardId))
            cursor.moveToFirst()
            location.setText(cursor.getString(cursor.getColumnIndex("name")))
        }catch (e: Exception)
        {
            Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
        }

        // 确认按钮
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            finish()
        }

    }


}
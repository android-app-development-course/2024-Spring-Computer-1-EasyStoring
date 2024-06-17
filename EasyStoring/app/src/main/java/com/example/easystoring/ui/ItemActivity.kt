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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.Item
import com.example.easystoring.R
import com.example.easystoring.logic.model.AppDBHelper
import kotlin.Exception

class ItemActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Range", "CutPasteId", "Recycle")
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

        val name = findViewById<EditText>(R.id.editText1)
        val num = findViewById<EditText>(R.id.editText2)
        val description = findViewById<EditText>(R.id.editText7)
        val pdate = findViewById<EditText>(R.id.editText4)
        val vdate = findViewById<EditText>(R.id.editText5)
        val location = findViewById<EditText>(R.id.editText8)

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
        var cupboardName:String=""
        cursor = db.rawQuery("SELECT * FROM Cupboard WHERE id = ?", arrayOf(cupboardId))
        cursor.moveToFirst()
        cupboardName=cursor.getString(cursor.getColumnIndex("name"))
        try {
            name.setText(nameText)
            num.setText(number)
            description.setText(descriptionText)
            pdate.setText(pdateText)
            vdate.setText(vdateText)
            location.setText(cupboardName)
        }catch (e: Exception)
        {
            Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
        }

        // 确认按钮
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {

                val originalText: List<String> = listOf(
                    nameText.toString(),
                    number.toString(),
                    descriptionText.toString(),
                    pdateText.toString(),
                    vdateText.toString(),
                    cupboardName
                )
                val currentText: List<String> = listOf(
                    name.text.toString(),
                    num.text.toString(),
                    description.text.toString(),
                    pdate.text.toString(),
                    vdate.text.toString(),
                    location.text.toString()
                )

                if (changed(originalText, currentText)) {
                    // 文本已更改
                    Toast.makeText(this, "Text has been changed", Toast.LENGTH_SHORT).show()
                    val item = Item(EasyStoringApplication.userID.toInt())
                    if (itemId != null) {
                        item.id = itemId.toInt()
                        item.name = name.text.toString()
                        item.number = num.text.toString().toInt()
                        item.description = description.text.toString()
                        cursor = db.rawQuery("SELECT * FROM Cupboard WHERE name = ?",
                            arrayOf(location.text.toString()))
                        cursor.moveToFirst()
                        item.cupboardId =cursor.getString(cursor.getColumnIndex("id")).toInt()
                        item.productionDate = pdate.text.toString()
                        item.overdueDate = vdate.text.toString()
                        dbHelper.updateItem(db,item)
                        dbHelper.DeviceToSever(db)

                        val intent = Intent()
                        intent.putExtra("updateItemId", item.id.toString())
                        setResult(RESULT_OK, intent)
                    }
                } else {
                    // 文本未更改
                    Toast.makeText(this, "Text is unchanged", Toast.LENGTH_SHORT).show()
                }
//            }catch (e:Exception){
//                Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
//            }

            finish()
        }

    }

    fun changed(list1:List<String>,list2:List<String>):Boolean
    {
        if (list1.size!=list2.size)
            return true
        for (i in 0..list1.size-1)
        {
            if (list1[i]!=list2[i])
                return true
        }
        return false
    }

}
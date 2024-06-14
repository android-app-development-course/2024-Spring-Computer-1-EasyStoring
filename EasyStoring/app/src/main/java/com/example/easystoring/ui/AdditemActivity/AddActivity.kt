package com.example.easystoring.ui.AdditemActivity

//import androidx.activity.enableEdgeToEdge
import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easystoring.Item
import com.example.easystoring.R
import com.example.easystoring.logic.model.AppDBHelper
import java.lang.Exception

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button1: Button = findViewById(R.id.button1)
        val button2:Button=findViewById(R.id.button2)
        button2.setOnClickListener {
            finish()
        }

        val edit_1: EditText = findViewById(R.id.editText1)
        val edit_2: EditText = findViewById(R.id.editText2)
        val edit_4: EditText = findViewById(R.id.editText4)
        val edit_5: EditText = findViewById(R.id.editText5)
        val edit_7: EditText = findViewById(R.id.editText7)
        val edit_8: EditText = findViewById(R.id.editText8)

//        val ImageBtn_1: ImageButton = findViewById(R.id.imageButton1)
//        val ImageBtn_2: ImageButton = findViewById(R.id.imageButton2)
//        val ImageBtn_3: ImageButton = findViewById(R.id.imageButton3)
//        val ImageBtn_4: ImageButton = findViewById(R.id.imageButton4)

//        var use_item :Item = Item()
//        button1.setOnClickListener {
//            use_item.name = edit_1.getText().toString()
//            use_item.number = Integer.parseInt(edit_2.getText().toString())
//            use_item.decription = edit_7.getText().toString()
//            use_item.belongTo = Integer.parseInt(edit_8.getText().toString())
//            use_item.productionDate = edit_4.getText().toString()
//            use_item.overdueDate = edit_5.getText().toString()
//        }

        //读入图片
//        ImageBtn_1.setOnClickListener{
//
//        }

    }

    fun additem(Item1 :Item){

        val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase
        var ItemNum = 0
        var cursor: Cursor?
        try {
            cursor = db.rawQuery("SELECT COUNT(*) FROM Item", null)
            cursor.moveToFirst()
            ItemNum =  cursor.getInt(0)
            cursor.close()
        } catch (e: Exception) {
            Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
        }
        val values3 = ContentValues().apply {
            // 组装数据
            ItemNum ++
            put("id",ItemNum)
            put("userId", 1)
            put("imageId","")
            put("name",Item1.name)
            put("description",Item1.description)
            put("number", Item1.number)
            put("productionDate",Item1.productionDate)
            put("cupboardId", Item1.cupboardId)
        }
        db.insert("Item", null, values3)

    }

}
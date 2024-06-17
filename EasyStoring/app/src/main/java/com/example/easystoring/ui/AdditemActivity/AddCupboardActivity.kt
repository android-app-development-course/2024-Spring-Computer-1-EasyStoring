package com.example.easystoring.ui.AdditemActivity

//import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easystoring.Cupboard
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.R
import com.example.easystoring.logic.model.AppDBHelper

class AddCupboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_add_cupboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar1:androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        toolbar1.setTitleTextColor(Color.BLACK)
        toolbar1.setTitle("添加空间")
        toolbar1.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        setSupportActionBar(toolbar1)
        toolbar1.setNavigationOnClickListener {
            finish()
        }

        // 确定
        val button1: Button = findViewById(R.id.button1)
        val edit_1: EditText = findViewById(R.id.cupboardName)
        val edit_2: EditText = findViewById(R.id.cupboardDes)

        val newCupboard = Cupboard(EasyStoringApplication.userID.toInt())
        button1.setOnClickListener {
            try {
                val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
                val db = dbHelper.writableDatabase
                newCupboard.id = dbHelper.getRowCount(db,"Cupboard") + 1
                newCupboard.name = edit_1.text.toString()
                newCupboard.description = edit_2.text.toString()
                dbHelper.insertCupboard(db, newCupboard)
                dbHelper.DeviceToSever(db)

                val intent = Intent()
                intent.putExtra("NewCupboardId", newCupboard.id.toString())
                setResult(RESULT_OK, intent)
            }catch (e:Exception){
                Log.d("error_add_cupboard",e.message!!)
            }
            finish()
        }
    }
}
package com.example.easystoring.ui.AdditemActivity

//import androidx.activity.enableEdgeToEdge
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.Item
import com.example.easystoring.R
import com.example.easystoring.logic.model.AppDBHelper
import kotlin.Exception

class AddActivity : AppCompatActivity() {

    private var ImageUri:String = ""
    @SuppressLint("Range", "Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar1:androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        toolbar1.setTitleTextColor(Color.BLACK)
        toolbar1.setTitle("添加物品")
        toolbar1.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        setSupportActionBar(toolbar1)
        toolbar1.setNavigationOnClickListener {
            finish()
        }

        val button1: Button = findViewById(R.id.button1)


        val edit_1: EditText = findViewById(R.id.editText1)
        val edit_2: EditText = findViewById(R.id.editText2)
        val edit_4: EditText = findViewById(R.id.editText4)
        val edit_5: EditText = findViewById(R.id.editText5)
        val edit_7: EditText = findViewById(R.id.editText7)
        val edit_8: EditText = findViewById(R.id.editText8)

        // 点击图片
        val ImageBtn_1: ImageView = findViewById(R.id.imageView)
        val overlay = findViewById<FrameLayout>(R.id.overlay)
        val fra_con = findViewById<FrameLayout>(R.id.fragment_container)
        ImageBtn_1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AddPicFragment()) // Assuming you have a container for Fragments
                .commit()
            overlay.visibility = View.VISIBLE
        }
        overlay.setOnClickListener {
            // 隐藏Fragment和overlay
            supportFragmentManager.findFragmentById(R.id.fragment_container)?.let { it1 ->
                supportFragmentManager.beginTransaction()
                    .remove(it1)
                    .commit()
            }
            overlay.visibility = View.GONE
        }
        val use_item :Item = Item(EasyStoringApplication.userID.toInt())
        // 确定按钮，将输入的值放到item中并存入数据库
        button1.setOnClickListener {
            try {
                val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
                val db = dbHelper.writableDatabase
                val cursor = db.rawQuery("SELECT * FROM Cupboard WHERE name = ?",
                    arrayOf(edit_8.text.toString()))
                var cupboardId = -1
                if (cursor.moveToFirst()) {
                    cupboardId = cursor.getString(cursor.getColumnIndex("id")).toInt()
                }
                use_item.id = dbHelper.getMaxId(db,"Item") + 1
                use_item.name = edit_1.text.toString()
                use_item.number = Integer.parseInt(edit_2.text.toString())
                use_item.description = edit_7.text.toString()
                use_item.cupboardId = cupboardId
                use_item.productionDate = edit_4.text.toString()
                use_item.overdueDate = edit_5.text.toString()
                use_item.imageId = getImageUri()

                dbHelper.insertItem(db, use_item)
                dbHelper.DeviceToSever(db)

                val intent = Intent()
                intent.putExtra("NewItemId", use_item.id.toString())
                setResult(RESULT_OK, intent)
            }catch (e:Exception){
                Log.d("error",e.message!!)
            }
            finish()

        }

        //读入图片
//        ImageBtn_1.setOnClickListener{
//
//        }

    }

    @SuppressLint("Range")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2&& resultCode == RESULT_OK) {
            data?.dataString.let {
                val imageView = findViewById<ImageView>(R.id.imageView)
                val imageUri = data?.data
                imageView.setImageURI(Uri.parse(it))
                if (it != null) {
                    ImageUri = it
                }
            }
        }
    }
    private fun getImageUri():String{
        return ImageUri
    }

}
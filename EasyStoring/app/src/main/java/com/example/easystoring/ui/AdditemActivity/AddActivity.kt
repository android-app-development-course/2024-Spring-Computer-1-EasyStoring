package com.example.easystoring.ui.AdditemActivity

//import androidx.activity.enableEdgeToEdge
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easystoring.Item
import com.example.easystoring.R
import com.example.easystoring.logic.model.AppDBHelper
import java.lang.Exception

class AddActivity : AppCompatActivity() {

    private var ImageUri:String = ""
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

        val ImageBtn_1: ImageView = findViewById(R.id.imageView)
        ImageBtn_1.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 2)
        }

        var use_item :Item = Item(1)
        // 确定按钮，将输入的值放到item中并存入数据库
        button1.setOnClickListener {
            val dbHelper = AppDBHelper(this, "EasyStoring.db", 1)
            val db = dbHelper.writableDatabase
            use_item.id  = dbHelper.getRowCount("Item")+1
            use_item.name = edit_1.getText().toString()
            use_item.number = Integer.parseInt(edit_2.getText().toString())
            use_item.description = edit_7.getText().toString()
            use_item.cupboardId = Integer.parseInt(edit_8.getText().toString())
            use_item.productionDate = edit_4.getText().toString()
            use_item.overdueDate = edit_5.getText().toString()
            use_item.imageId = getImageUri()

            dbHelper.insertItem(db,use_item)

            val intent = Intent()
            intent.putExtra("NewItemId", use_item.id)
            setResult(RESULT_OK, intent)
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
        if (requestCode == 2) {
            data?.dataString.let {
                val imageView = findViewById<ImageView>(R.id.imageView)
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
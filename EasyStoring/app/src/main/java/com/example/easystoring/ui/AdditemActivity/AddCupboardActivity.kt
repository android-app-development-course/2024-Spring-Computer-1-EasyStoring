package com.example.easystoring.ui.AdditemActivity

//import androidx.activity.enableEdgeToEdge
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easystoring.R

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

        val button1: Button = findViewById(R.id.button1)
        val edit_1: EditText = findViewById(R.id.editText1)
        val edit_2: EditText = findViewById(R.id.editText2)
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            finish()
        }

//        var use_Cupboard : Cupboard = Cupboard()
//        button1.setOnClickListener {
//            use_Cupboard.name = edit_1.getText().toString()
//            use_Cupboard.description = edit_1.getText().toString()
//        }
    }
}
package com.example.easystoring.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.easystoring.R

class ItemActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            finish()
        }
        val button2:Button=findViewById(R.id.button2)
        button2.setOnClickListener {
            finish()
        }

//        val edit_1: EditText = findViewById(R.id.editText1)
//        val edit_2: EditText = findViewById(R.id.editText2)
//        val edit_4: EditText = findViewById(R.id.editText4)
//        val edit_5: EditText = findViewById(R.id.editText5)
//        val edit_7: EditText = findViewById(R.id.editText7)
//        val edit_8: EditText = findViewById(R.id.editText8)

        val ImageBtn_1: ImageButton = findViewById(R.id.imageButton1)
        val ImageBtn_2: ImageButton = findViewById(R.id.imageButton2)
        val ImageBtn_3: ImageButton = findViewById(R.id.imageButton3)
        val ImageBtn_4: ImageButton = findViewById(R.id.imageButton4)
    }
}
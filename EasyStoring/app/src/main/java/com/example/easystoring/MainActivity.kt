package com.example.easystoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.text.set

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b2: Button = findViewById(R.id.button2)
        val i1: EditText = findViewById(R.id.editText)
        b2.setOnClickListener {
            var t = i1.text.toString()
            t = t + t
            i1.text.clear()
            i1.text.append(t)
        }
    }
}
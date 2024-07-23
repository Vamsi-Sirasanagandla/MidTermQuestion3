package com.example.midtermquestion3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etUserMessage: EditText = findViewById(R.id.etUserMessage)
        val button1: Button = findViewById(R.id.question1)
        button1.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, App1::class.java)
            intent.putExtra("key", message)
            startActivity(intent)
        }
        val button2: Button = findViewById(R.id.question2)
        button2.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, App2::class.java)
            intent.putExtra("key", message)
            startActivity(intent)
        }
    }
}
package com.example.assessment2app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "Menu"
        val page1 = findViewById<Button>(R.id.button1)
        val page2 = findViewById<Button>(R.id.button2)
        val page3 = findViewById<Button>(R.id.button3)
        page1.setOnClickListener {
            startActivity(Intent(this, Schedulerpage::class.java))
        }
        page2.setOnClickListener {
            startActivity(Intent(this, Converter::class.java))
        }
        page3.setOnClickListener {
            startActivity(Intent(this, Helppage::class.java))
        }
    }
}
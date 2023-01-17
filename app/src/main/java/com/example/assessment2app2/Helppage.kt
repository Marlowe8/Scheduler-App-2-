package com.example.assessment2app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Helppage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_helppage)

        val actionbar = supportActionBar
        actionbar!!.title = "Help"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
}
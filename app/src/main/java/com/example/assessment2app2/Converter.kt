package com.example.assessment2app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Converter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converterpage)

        val actionbar = supportActionBar
        actionbar!!.title = "Converter"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val centi = findViewById<EditText>(R.id.centimeter_et)
        val inch = findViewById<EditText>(R.id.inches_et)
        val foot = findViewById<EditText>(R.id.foot_et)
        val meter = findViewById<EditText>(R.id.meters_et)
        val convert = findViewById<Button>(R.id.convert_btn)
        inch.isEnabled = false
        foot.isEnabled = false
        meter.isEnabled = false
        convert.setOnClickListener {
            val _centi = centi.text.toString().toFloat()
           /* val _inch = inch.text.toString().toFloat()
            val _foot = foot.text.toString().toFloat()
            val _meter = meter.text.toString().toFloat()
            */
            val centiResult = _centi/2.54 //inches
            val centiResult1 = _centi/12 //foot
            val centiResult2 = _centi/100 //meter
            inch.setText(""+centiResult)
            foot.setText(""+centiResult1)
            meter.setText(""+centiResult2)
        }
    }
}
package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculateActivity : AppCompatActivity() {
    var bmiIndex:Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        val personName = intent.getStringExtra("name")
        val tv = findViewById<TextView>(R.id.userName)
        tv.setText(personName)

        if (savedInstanceState != null) {
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            if(bmiIndex != 0.0) {
                val status = findViewById<TextView>(R.id.currentStatus)
                status.setText(getStatus())
            }
        }

        val btn = findViewById<Button>(R.id.calculateButton)

        btn.setOnClickListener {
            val weight = findViewById<TextView>(R.id.weightInput).text.toString().toDouble()
            val height = findViewById<TextView>(R.id.heightInput).text.toString().toDouble()
            val status = findViewById<TextView>(R.id.currentStatus)

            bmiIndex = weight / (height * height)

            status.setText(getStatus())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex", bmiIndex)
    }

    fun getStatus():String{
        if(bmiIndex < 18.5)
            return "Underweight"
        else if(bmiIndex <=24.9)
            return "Normal Weight"
        else if(bmiIndex <=29.9)
            return "Overweight"
        else if(bmiIndex <=34.9)
            return "Obesity Class I"
        else if(bmiIndex <=39.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"
    }
}
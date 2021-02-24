package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.enterButton)

        btn.setOnClickListener {
            val intent = Intent(this, CalculateActivity::class.java)
            intent.putExtra("name", findViewById<TextView>(R.id.nameInput).text.toString())
            startActivity(intent)
        }
    }
}
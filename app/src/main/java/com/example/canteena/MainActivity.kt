package com.example.canteena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.cusLogin)
        val button1 = findViewById<Button>(R.id.empLogin)
        button.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
        button1.setOnClickListener{
            startActivity(Intent(this,EmpLogin::class.java))
        }

    }
}

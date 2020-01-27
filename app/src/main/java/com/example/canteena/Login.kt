package com.example.canteena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val name = findViewById<EditText>(R.id.etName)
        val password = findViewById<EditText>(R.id.etPassword)
        val button = findViewById<Button>(R.id.btnLoogin)
        val register = findViewById<TextView>(R.id.register)

        register.setOnClickListener{
            startActivity(Intent(this,Register::class.java))
        }
        button.setOnClickListener{
            validate(name.text.toString(),password.text.toString())
        }
    }

    fun validate(name : String,password : String)
    {
        if (name == "Admin"&&password == "1234") {
            intent = Intent(this, Customer::class.java)
            startActivity(intent)
        }
    }
}

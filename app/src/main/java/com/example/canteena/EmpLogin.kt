package com.example.canteena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class EmpLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emp_login)
        val name = findViewById<EditText>(R.id.etName)
        val password = findViewById<EditText>(R.id.etPassword)
        val button = findViewById<Button>(R.id.btnLoogin)
        val register = findViewById<TextView>(R.id.register)
        var auth: FirebaseAuth

        register.setOnClickListener{
            startActivity(Intent(this,Register::class.java))
        }
        button.setOnClickListener {
            auth = FirebaseAuth.getInstance()
            auth.signInWithEmailAndPassword(name.text.toString(), password.text.toString())
                .addOnCompleteListener { Task ->
                    if (Task.isSuccessful) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, Customer::class.java))
                    } else {
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            startActivity(Intent(this,Customer::class.java))
        }
    }
}

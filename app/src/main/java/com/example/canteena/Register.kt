package com.example.canteena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val name = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.userPassword)
        val emailId = findViewById<EditText>(R.id.userMail)
        val register = findViewById<Button>(R.id.userRegister)
        val login = findViewById<TextView>(R.id.userLogin)
        var auth : FirebaseAuth
        login.setOnClickListener{
            startActivity(Intent(this,login::class.java))
        }
        register.setOnClickListener{
            if(validate(name.text.toString(),password.text.toString(),emailId.text.toString()))
            {
                val userEmail = emailId.text.toString()
                val userPassword = password.text.toString()
                auth = FirebaseAuth.getInstance()
                auth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener{task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show()
                        finish()
                        startActivity(Intent(this, login::class.java))
                    }
                    else
                        Toast.makeText(this,"Registration Failed",Toast.LENGTH_LONG).show()

                }


            }
            else
            {
                Toast.makeText(this,"please enter all the details",Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun validate(name : String, password : String, mail : String): Boolean {
        return (!name.isEmpty()&&!password.isEmpty()&&!mail.isEmpty())
    }
}

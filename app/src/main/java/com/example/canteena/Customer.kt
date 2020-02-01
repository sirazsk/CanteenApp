package com.example.canteena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.view.View

import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class Customer : AppCompatActivity() {

   var ammount : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        val order = resources.getStringArray(R.array.order_arrays)
        val orders = findViewById<TextView>(R.id.orderList)
        val pay = findViewById<Button>(R.id.pay)
        val amnt = findViewById<TextView>(R.id.amount)
        val submit = findViewById<Button>(R.id.btnSubmit)

        var list:String
        var auth: FirebaseAuth
        auth = FirebaseAuth.getInstance()

        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, order)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@Customer,
                        order[position] + " " +
                                "" + getString(R.string.selected_item), Toast.LENGTH_SHORT).show()
                    orders.append(order[position] + " \n")
                    if(order[position].length!=0){
                        ammount = ammount + (order[position].toCharArray()[order[position].toString().length-2].toInt())*10 + (order[position].toCharArray()[order[position].toString().length-1].toInt())-528
                        amnt.setText(ammount.toString())
                    }


                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        pay.setOnClickListener{
            list = (orders.text.toString())
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference(auth.uid.toString())
            val data = arrayListOf<String>(list)
            myRef.setValue(data)
            Toast.makeText(this,list,Toast.LENGTH_SHORT).show()
        }
        submit.setOnClickListener{
            startActivity(Intent(this,QRcode::class.java))
        }

    }


}

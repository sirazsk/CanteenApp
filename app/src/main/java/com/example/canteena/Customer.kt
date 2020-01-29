package com.example.canteena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.view.View

import android.widget.*
import org.w3c.dom.Text

abstract class Customer : AppCompatActivity() {

//    var ammount : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        val order = resources.getStringArray(R.array.order_arrays)
        val orders = findViewById<TextView>(R.id.orderList)
        val pay = findViewById<Button>(R.id.pay)
//        val amnt = findViewById<TextView>(R.id.amount)
//        var list:String

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
//                    ammount = ammount + (order[position].toCharArray()[order[position].length-1].toInt())*10 + order[position].toCharArray()[order[position].length].toInt()
//                    amnt.setText(ammount)
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        pay.setOnClickListener{
//            list = (orders.text as String)
//            println(list)
        }

    }


}

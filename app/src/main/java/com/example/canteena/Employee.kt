package com.example.canteena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_employee.*

class Employee : AppCompatActivity() {

    lateinit var uid : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        initfunc()



    }
    private fun initfunc(){
        btn_scan_me.setOnClickListener{
            initscan()
        }
    }
    private fun initscan(){
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result!=null){
            if(result.contents == null){

            }else{
                uid = result.contents.toString()
                postd()
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
    private fun postd(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(uid)
        var order : String

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI


                if(dataSnapshot.exists()){
                    for(h in dataSnapshot.children){
                        val post = h.getValue(String::class.java)
                        order = post!!.toString()
                        etView.setText(order)
                    }

                }


                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("loadPost:onCancelled", databaseError.toException())
                // ...
            }
        }
        myRef.addValueEventListener(postListener)
    }
}

package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Activity_Home : AppCompatActivity(), View.OnClickListener {

    lateinit var t1: TextView
    lateinit var b1: Button
    lateinit var ib1: ImageButton
//    lateinit var ib2: ImageButton
    lateinit var nm: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setTitle("Category")

        t1 = findViewById(R.id.textView1)
        b1 = findViewById(R.id.btnlogout)
        ib1 = findViewById(R.id.imageButton1)
       // ib2 = findViewById(R.id.imageButton2)

        val i = intent
        nm = i.getStringExtra("username")!!
        t1.text = "Welcome " + nm

        b1.setOnClickListener(this)
        ib1.setOnClickListener(this)
//        ib2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id==R.id.btnlogout) {
            val i = Intent(applicationContext, MainActivity::class.java)
            i.putExtra("username", nm)
            startActivity(i)
        }
        else if(v?.id==R.id.imageButton1) {
            val i = Intent(applicationContext, Activity_Female::class.java)
            i.putExtra("username", nm)
            i.putExtra("cid", 1)
            startActivity(i)
        }
    }
}


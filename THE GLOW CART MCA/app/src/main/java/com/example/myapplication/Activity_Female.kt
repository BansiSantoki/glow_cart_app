package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Activity_Female : AppCompatActivity(), View.OnClickListener {

    lateinit var t1: TextView
    lateinit var b1: Button
    lateinit var nm: String

    lateinit var ib1: ImageButton
    lateinit var ib2: ImageButton
    lateinit var ib3: ImageButton
    lateinit var ib4: ImageButton
    lateinit var ib5: ImageButton
    lateinit var ib6: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_female)

        setTitle("FEMALE")

        t1 = findViewById(R.id.textView1)
        b1 = findViewById(R.id.btnlogout)
        ib1 = findViewById(R.id.imageButton1)
        ib2 = findViewById(R.id.imageButton2)
        ib3 = findViewById(R.id.imageButton3)
        ib4 = findViewById(R.id.imageButton4)
        ib5 = findViewById(R.id.imageButton5)
        ib6 = findViewById(R.id.imageButton6)


        val i = intent
        nm = i.getStringExtra("username")!!
        t1.text = "Welcome " + nm

        b1.setOnClickListener(this)
        ib1.setOnClickListener(this)
        ib2.setOnClickListener(this)
        ib3.setOnClickListener(this)
        ib4.setOnClickListener(this)
        ib5.setOnClickListener(this)
        ib6.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnlogout) {
            val i = Intent(applicationContext, MainActivity::class.java)
            i.putExtra("username", nm)
            startActivity(i)
        } else if (v?.id == R.id.imageButton1) {
            val i = Intent(applicationContext, Activity_Makeup::class.java)
            i.putExtra("username", nm)
            i.putExtra("sid", 1)
            startActivity(i)
        } else if (v?.id == R.id.imageButton2) {
            val i = Intent(applicationContext, Activity_Skincare::class.java)
            i.putExtra("username", nm)
            i.putExtra("sid", 2)
            startActivity(i)
        } else if (v?.id == R.id.imageButton3) {
            val i = Intent(applicationContext, Activity_Haircare::class.java)
            i.putExtra("username", nm)
            i.putExtra("sid", 1)
            startActivity(i)
        } else if (v?.id == R.id.imageButton3) {
            val i = Intent(applicationContext, Activity_Suncare::class.java)
            i.putExtra("username", nm)
            i.putExtra("sid", 1)
            startActivity(i)
        } else {
            val i = Intent(applicationContext, Activity_Nails::class.java)
            i.putExtra("username", nm)
            i.putExtra("sid", 3)
            startActivity(i)
        }
            if  (v?.id == R.id.imageButton6) {
            val i = Intent(applicationContext, Activity_Allcombo::class.java)
            i.putExtra("username", nm)
            i.putExtra("sid", 1)
            startActivity(i)

        }
    }
}

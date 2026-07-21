package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Activity_order : AppCompatActivity(), View.OnClickListener {

    lateinit var t33: TextView
    lateinit var t44: TextView
    lateinit var t55: TextView
    lateinit var t66: TextView

    lateinit var t1: TextView
    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button

    var tip: Int = 0
    var total: Int = 0
    var gst: Double = 0.0
    var grand_total: Int = 0
    lateinit var nm: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        setTitle("Order")

        t33 = findViewById(R.id.textView33)
        t44 = findViewById(R.id.textView44)
        t55 = findViewById(R.id.textView55)
        t66 = findViewById(R.id.textView66)

        t1 = findViewById(R.id.textView1)
        b1 = findViewById(R.id.btnlogout)
        b2 = findViewById(R.id.button10)
        b3 = findViewById(R.id.button20)
        b4 = findViewById(R.id.button30)
        b5 = findViewById(R.id.button5)

        val i = intent
        nm = i.getStringExtra("username")!!
        t1.text = "Welcome " + nm

        val i1 = intent
        total = Integer.parseInt(i1.getStringExtra("total"))
        gst = total*0.1
        //Toast.makeText(this,total.toString(),Toast.LENGTH_SHORT).show()
        grand_total=total+gst.toInt()+tip

        t33.setText(total.toString())
        t44.setText(tip.toString())
        t55.setText(gst.toString())
        t66.setText(grand_total.toString())

        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnlogout) {
            val i = Intent(applicationContext, MainActivity::class.java)
            i.putExtra("username", nm)
            startActivity(i)
        }
        if (v?.id == R.id.button10) {
            tip=10
        }
        if (v?.id == R.id.button20) {
            tip = 20
        }
        if (v?.id == R.id.button30) {
            tip=30
        }
        if (v?.id == R.id.button5) {
            val i = Intent(applicationContext, Activity_cart::class.java)
            i.putExtra("username", nm)
            i.putExtra("grandtotal", grand_total.toString())
            startActivity(i)
        }
        grand_total=total+gst.toInt()+tip
        t44.setText(tip.toString())
        t66.setText(grand_total.toString())
    }
}

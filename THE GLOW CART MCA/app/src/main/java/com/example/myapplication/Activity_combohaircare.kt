package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Activity_combohaircare : AppCompatActivity() {

    lateinit var hcqty1: EditText
    lateinit var hcqty2: EditText
    lateinit var hcadd1: Button
    lateinit var hcadd2: Button
    lateinit var hccart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combohaircare)

        hcqty1 = findViewById(R.id.hcqty1)
        hcqty2 = findViewById(R.id.hcqty2)
        hcadd1 = findViewById(R.id.hcadd1)
        hcadd2 = findViewById(R.id.hcadd2)
        hccart = findViewById(R.id.hccart)

        hcadd1.setOnClickListener {
            Toast.makeText(this,"Added Combo 1 x ${hcqty1.text}",Toast.LENGTH_SHORT).show()
        }

        hcadd2.setOnClickListener {
            Toast.makeText(this,"Added Combo 2 x ${hcqty2.text}",Toast.LENGTH_SHORT).show()
        }

        hccart.setOnClickListener {
            Toast.makeText(this,"Going to Cart...",Toast.LENGTH_LONG).show()
            // startActivity(Intent(this,CartActivity::class.java))
        }
    }
}

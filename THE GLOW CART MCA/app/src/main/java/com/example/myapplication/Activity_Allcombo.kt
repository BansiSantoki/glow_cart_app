package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity_Allcombo : AppCompatActivity() {

    lateinit var sunCare: LinearLayout
    lateinit var makeup: LinearLayout
    lateinit var hairCare: LinearLayout
    lateinit var skinCare: LinearLayout
    lateinit var nailCare: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allcombo)

        // IDs of each card from XML
        sunCare = findViewById(R.id.card_suncare)
        makeup = findViewById(R.id.card_makeup)
        hairCare = findViewById(R.id.card_haircare)
        skinCare = findViewById(R.id.card_skincare)
        nailCare = findViewById(R.id.card_nails)

        sunCare.setOnClickListener {
            Toast.makeText(this,"Suncare Combo Selected",Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, Activity_SuncareCombo::class.java))
        }

        makeup.setOnClickListener {
            Toast.makeText(this,"Makeup Combo Selected",Toast.LENGTH_SHORT).show()
        }

        hairCare.setOnClickListener {
            Toast.makeText(this,"Haircare Combo Selected",Toast.LENGTH_SHORT).show()
        }

        skinCare.setOnClickListener {
            Toast.makeText(this,"Skincare Combo Selected",Toast.LENGTH_SHORT).show()
        }

        nailCare.setOnClickListener {
            Toast.makeText(this,"Nails Combo Selected",Toast.LENGTH_SHORT).show()
        }
    }
}

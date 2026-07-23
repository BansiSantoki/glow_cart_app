package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity_suncareCombo : AppCompatActivity() {

    lateinit var qty1: EditText
    lateinit var qty2: EditText
    lateinit var btnAdd1: Button
    lateinit var btnAdd2: Button
    lateinit var btnCart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suncare_combo)

        qty1 = findViewById(R.id.qty1)
        qty2 = findViewById(R.id.qty2)
        btnAdd1 = findViewById(R.id.btnAdd1)
        btnAdd2 = findViewById(R.id.btnAdd2)
        btnCart = findViewById(R.id.btnCart)

        btnAdd1.setOnClickListener {
            Toast.makeText(this,"Added SPF 50+ Gel x ${qty1.text}",Toast.LENGTH_SHORT).show()
        }

        btnAdd2.setOnClickListener {
            Toast.makeText(this,"Added Matte UV Lotion x ${qty2.text}",Toast.LENGTH_SHORT).show()
        }

        btnCart.setOnClickListener {
            Toast.makeText(this,"Opening Cart...",Toast.LENGTH_LONG).show()
            // startActivity(Intent(this,Activity_cart::class.java)) <-- enable when made
        }
    }
}

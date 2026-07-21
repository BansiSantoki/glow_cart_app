package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Activity_nailscombo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nailscombo)

        val qty1 = findViewById<EditText>(R.id.qty1)
        val qty2 = findViewById<EditText>(R.id.qty2)

        findViewById<Button>(R.id.btnAdd1).setOnClickListener {
            Toast.makeText(this, "Item 1 Added Qty: ${qty1.text}", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnAdd2).setOnClickListener {
            Toast.makeText(this, "Item 2 Added Qty: ${qty2.text}", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnCart).setOnClickListener {
            Toast.makeText(this, "Cart Opening Soon...", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show()
        }
    }
}

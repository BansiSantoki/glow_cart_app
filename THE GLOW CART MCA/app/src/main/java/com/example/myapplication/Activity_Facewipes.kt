package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity_Facewipes: AppCompatActivity(), View.OnClickListener {

    lateinit var t1: TextView
    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var nm: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facewipes)

        setTitle("Face wipes")

        // Initialize views
        t1 = findViewById(R.id.textView1)
        b1 = findViewById(R.id.btnlogout)
        b2 = findViewById(R.id.button2)


        // Retrieve the username passed from the previous activity
        val i = intent
        nm = i.getStringExtra("username") ?: "" // Safe call to avoid null pointer
        t1.text = "Welcome $nm"

        // Set click listeners for the buttons
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnlogout -> {
                // If logout button is clicked, navigate back to MainActivity
                val i = Intent(applicationContext, MainActivity::class.java)
                i.putExtra("username", nm)
                startActivity(i)
            }

            R.id.button2 -> {
                // Redirect to Activity_Face
                val i = Intent(applicationContext, Activity_Facewipes::class.java)
                i.putExtra("username", nm) // Pass username to Activity_Eye
                startActivity(i)
            }
        }
    }
}

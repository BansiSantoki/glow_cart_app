package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity_Makeup : AppCompatActivity(), View.OnClickListener {

    lateinit var t1: TextView
    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var nm: String
    lateinit var ib1: ImageButton
    lateinit var ib2: ImageButton
    lateinit var ib3: ImageButton
    lateinit var ib4: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mackup)

        setTitle("Makeup")

        // Initialize views
        t1 = findViewById(R.id.textView1)
        b1 = findViewById(R.id.btnlogout)
        b2 = findViewById(R.id.button2)
        ib1 = findViewById(R.id.imageButton1)
        ib2 = findViewById(R.id.imageButton2)
        ib3 = findViewById(R.id.imageButton3)
        ib4= findViewById(R.id.imageButton4)


        // Retrieve the username passed from the previous activity
        val i = intent
        nm = i.getStringExtra("username") ?: "" // Safe call to avoid null pointer
        t1.text = "Welcome $nm"

        // Set click listeners for the buttons
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        ib1.setOnClickListener(this)
        ib2.setOnClickListener(this)
        ib3.setOnClickListener(this)
        ib4.setOnClickListener(this)
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
               // Redirect to Activity_Mackup
                val i = Intent(applicationContext, Activity_Makeup::class.java)
                i.putExtra("username", nm) // Pass username to Activity_Face
                startActivity(i)
            }
            R.id.imageButton1 -> {
                val i=Intent(applicationContext, Activity_Face ::class.java)
                i.putExtra( "username",nm)//Pass username to Activity_Face
                startActivity(i)
            }
            R.id.imageButton2 -> {
                val i = Intent(applicationContext, Activity_Eye::class.java)
                i.putExtra("username", nm)//Pass username to Activity_Face
                startActivity(i)
            }
            R.id.imageButton3 -> {
                val i = Intent(applicationContext, Activity_Lips::class.java)
                i.putExtra("username", nm)//Pass username to Activity_Face
                startActivity(i)
            }
            R.id.imageButton4-> {
                val i = Intent(applicationContext, Activity_Mtools::class.java)
                i.putExtra("username", nm)//Pass username to Activity_Face
                startActivity(i)
            }
        }
    }
}

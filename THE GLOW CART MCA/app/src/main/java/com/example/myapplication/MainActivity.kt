package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var e1 : EditText
    lateinit var e2 : EditText
    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var b3:Button
    lateinit var a:ActionBar
    var db = DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Login")

        e1 = findViewById(R.id.edtunm1)
        e2 = findViewById(R.id.edtpwd1)

        b1=findViewById(R.id.btnlogin)
        b2=findViewById(R.id.btnregister)
        b3=findViewById(R.id.btnforgot)

        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id==R.id.btnlogin)
        {
            var u1: String = e1.text.toString()
            var p1: String = e2.text.toString()
            var Storepassword: String? = db.getSingleEntry(u1)

            if (p1 == Storepassword) {
                Toast.makeText(this, "Login Successful!!!", Toast.LENGTH_SHORT).show();

                val i = Intent(applicationContext, Activity_Home::class.java)
                i.putExtra("username", u1)
                startActivity(i)
            } else {
                Toast.makeText(this, "User name or password does not match!!!", Toast.LENGTH_SHORT).show();
            }
        }
        else if(v?.id==R.id.btnregister) {
            val i = Intent(applicationContext, Activity_Register::class.java)
            startActivity(i)
        }
        else {
            val i = Intent(applicationContext, Activity_forgot::class.java)
            startActivity(i)
        }

        }
    }


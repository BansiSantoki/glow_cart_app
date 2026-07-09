package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class Activity_forgot : AppCompatActivity(), View.OnClickListener {

    lateinit var b1: Button
    lateinit var edtUsername: EditText
    lateinit var spnsque: Spinner
    lateinit var edtsans: EditText
    var db = DatabaseHandler(this)

    lateinit var nm: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        setTitle("Forgot Password")

        edtUsername = findViewById(R.id.edtUsername)
        spnsque = findViewById(R.id.spnsque)
        edtsans = findViewById(R.id.edtsans)
        b1 = findViewById(R.id.btnok)
        b1.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnok) {
            val username = edtUsername.text.toString()
            val answer = edtsans.text.toString()
            val selectedQuestion = spnsque.selectedItem.toString()

            // Validate user input
            if (username.isEmpty() || answer.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
                return
            }

            // Check if the security question and answer match
            val storedAnswer = db.getSecurityAnswer(username, selectedQuestion)

            if (storedAnswer == "Not Exist") {
                Toast.makeText(this, "Username not found", Toast.LENGTH_SHORT).show()
            } else if (storedAnswer == answer) {
                val intent = Intent(applicationContext, Activity_changepwd::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Incorrect security answer", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


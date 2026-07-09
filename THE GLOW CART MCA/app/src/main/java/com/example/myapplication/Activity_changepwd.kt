package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Activity_changepwd : AppCompatActivity(), View.OnClickListener {

    lateinit var edtNewPassword: EditText
    lateinit var edtConfirmPassword: EditText
    lateinit var btnChangePassword: Button
    lateinit var databaseHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepwd)

        setTitle("Change Password")

        edtNewPassword = findViewById(R.id.edtNewPassword)
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword)
        btnChangePassword = findViewById(R.id.btnChangePassword)

        databaseHandler = DatabaseHandler(this)

        btnChangePassword.setOnClickListener(this)

        // Check if the username is passed correctly to this activity
        val username = intent.getStringExtra("username")
        if (username == null || username.isEmpty()) {
            Toast.makeText(this, "Username not found!", Toast.LENGTH_SHORT).show()
            Log.e("Activity_ChangePwd", "Username not passed in Intent")
        } else {
            Log.d("Activity_ChangePwd", "Username: $username")
        }
    }

    override fun onClick(v: View?) {
        val newPassword = edtNewPassword.text.toString()
        val confirmPassword = edtConfirmPassword.text.toString()

        // Get the username from the intent
        val username = intent.getStringExtra("username") ?: return

        // Log the input for debugging
        Log.d("Activity_ChangePwd", "New Password: $newPassword, Confirm Password: $confirmPassword")

        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            return
        }

        if (newPassword != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        // Update password in the database
        val result = databaseHandler.updatePassword(username, newPassword)

        if (result) {
            Toast.makeText(this, "Password updated successfully", Toast.LENGTH_SHORT).show()
            Log.d("Activity_ChangePwd", "Password updated successfully for user: $username")
            startActivity(Intent(this, MainActivity::class.java)) // Go back to login screen
        } else {
            Toast.makeText(this, "Error updating password or username does not exist", Toast.LENGTH_SHORT).show()
            Log.e("Activity_ChangePwd", "Failed to update password for user: $username")
        }
    }
}


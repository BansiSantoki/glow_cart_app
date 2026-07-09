package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class Activity_cart : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var mobileEditText: EditText
    private lateinit var amountTextView: TextView
    private lateinit var placeOrderButton: Button
    private lateinit var logoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        nameEditText = findViewById(R.id.editText1)
        addressEditText = findViewById(R.id.editText2)
        mobileEditText = findViewById(R.id.editText3)
        amountTextView = findViewById(R.id.textView6)
        placeOrderButton = findViewById(R.id.button2)
        logoutButton = findViewById(R.id.btnlogout)

        amountTextView.text = "₹1200"

        placeOrderButton.setOnClickListener { placeOrder() }
        logoutButton.setOnClickListener { logoutUser() }
    }

    private fun placeOrder() {
        val name = nameEditText.text.toString().trim()
        val address = addressEditText.text.toString().trim()
        val mobile = mobileEditText.text.toString().trim()
        val amount = amountTextView.text.toString()

        if (name.isEmpty()) {
            nameEditText.error = "Name required"
            return
        }
        if (address.isEmpty()) {
            addressEditText.error = "Address required"
            return
        }
        if (mobile.length != 10) {
            mobileEditText.error = "Enter valid 10-digit mobile number"
            return
        }

        val orderData = mapOf(
            "Name" to name,
            "Address" to address,
            "Mobile" to mobile,
            "Amount" to amount,
            "PaymentMode" to "Cash On Delivery"
        )

        val ordersRef = FirebaseDatabase.getInstance().reference.child("Orders")
        ordersRef.push().setValue(orderData)
            .addOnSuccessListener {
                Toast.makeText(this, "Order placed successfully 🎉", Toast.LENGTH_LONG).show()
                clearFields()
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_LONG).show()
            }
    }

    private fun clearFields() {
        nameEditText.text.clear()
        addressEditText.text.clear()
        mobileEditText.text.clear()
    }

    private fun logoutUser() {
        Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
    }
}

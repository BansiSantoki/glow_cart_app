package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Activity_Register : AppCompatActivity(), View.OnClickListener,
    AdapterView.OnItemSelectedListener {
    var db = DatabaseHandler(this)
    lateinit var e1:EditText
    lateinit var e2:EditText
    lateinit var e3:EditText
    lateinit var e4:EditText
    lateinit var e5:EditText
    lateinit var e6:EditText
    lateinit var e7:EditText
    lateinit var s1:Spinner
    lateinit var b1:Button
    var seqlist= arrayOfNulls<String>(20)
    lateinit var seq: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setTitle("Register")
        e1=findViewById(R.id.edtunm)
        e2=findViewById(R.id.edtpwd)
        e3=findViewById(R.id.edtcpwd)
        e4=findViewById(R.id.edtemail)
        e5=findViewById(R.id.edtphone)
        e6=findViewById(R.id.edtdt)
        e7=findViewById(R.id.edtsans)
        s1=findViewById(R.id.spnsque)

        seqlist= getResources().getStringArray(R.array.sque)

        b1=findViewById(R.id.btnregister)

        b1.setOnClickListener(this)
        s1.setOnItemSelectedListener(this)
    }

    override fun onClick(p0: View?) {
        // INSERT INTO REGISTER
        val unm: String = e1.text.toString()
        val pwd: String = e2.text.toString()
        val cpwd: String = e3.text.toString()
        val email: String = e4.text.toString()
        val phno: String = e5.text.toString()
        val dt: String = e6.text.toString()

        val sea: String = e7.text.toString()

        if (pwd == cpwd) {
            db.addRegister(Register(unm, pwd, email, phno, dt, seq, sea))
            Toast.makeText(this, "Registered Successfully!!!", Toast.LENGTH_SHORT).show()

            e1.setText("")
            e2.setText("")
            e3.setText("")
            e4.setText("")
            e5.setText("")
            e6.setText("")
            e7.setText("")
            s1.setSelection(0)

            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }
        else
            Toast.makeText(this, "Password and Confirm Password does Not Matched!!!", Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        seq=seqlist[p2].toString()
        //Toast.makeText(this, seqlist[p2].toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}


package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper

class splash_screen : AppCompatActivity() {

    // 3 સેકન્ડનો વિલંબ (મિલિસેકન્ડમાં)
    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ખાતરી કરો કે તમે અહીં યોગ્ય લેઆઉટ ફાઇલનો ઉપયોગ કરો છો
        setContentView(R.layout.activity_splash_screen)

        // 3 સેકન્ડ પછી કોડ ચલાવવા માટે Handler નો ઉપયોગ
        Handler(Looper.getMainLooper()).postDelayed({

            // TODO: અહીં તમારી મુખ્ય એપ્લિકેશન એક્ટિવિટીનું નામ બદલો
            // ધારો કે તમારી મુખ્ય એક્ટિવિટી 'Activity_Female' છે
            val intent = Intent(this, Activity_Female::class.java)
            startActivity(intent)

            // સ્પ્લેશ સ્ક્રીનને સ્ટેકમાંથી દૂર કરો જેથી બેક બટન દબાવવાથી તે ફરીથી ન દેખાય
            finish()

        }, SPLASH_TIME_OUT)
    }
}
package com.munik4124.sadhanacard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class AdminLogin : AppCompatActivity() {

    private lateinit var goToSignUp : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        goToSignUp = findViewById(R.id.go_to_signUp)

        goToSignUp.setOnClickListener {
            startActivity(Intent(applicationContext,AdminSignUp::class.java))
        }
    }
}
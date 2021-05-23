package com.munik4124.sadhanacard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView

class ChoiceAdminVsDevotees : AppCompatActivity() {
    private lateinit var devotees_logo : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_admin_vs_devotees)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        devotees_logo = findViewById(R.id.devotees_icon)
        devotees_logo.setOnClickListener{
           startActivity(Intent(applicationContext,DevoteesLogin::class.java))
        }
    }
}
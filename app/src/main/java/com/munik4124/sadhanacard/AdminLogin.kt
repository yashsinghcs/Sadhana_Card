package com.munik4124.sadhanacard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.munik4124.sadhanacard.userExtraDetails_Admin.AdditionalDetails
import com.munik4124.sadhanacard.userExtraDetails_Admin.Personaldetails
import com.munik4124.sadhanacard.userExtraDetails_Admin.SpiritualDetails

class AdminLogin : AppCompatActivity() {

    private lateinit var goToSignUp : Button
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var login : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        goToSignUp = findViewById(R.id.go_to_signUp)
        username = findViewById(R.id.username_login)
        password = findViewById(R.id.Password_login)
        login = findViewById(R.id.login)


        goToSignUp.setOnClickListener {
            startActivity(Intent(applicationContext,AdminSignUp::class.java))
        }

        login.setOnClickListener {
          if(checkForValidation()) {
              val admin_user : AdminUser = AdminUser("",username.text.toString(),password.text.toString(),"")
              val firebaseClass : FirebaseClass = FirebaseClass(admin_user,this, Personaldetails("a","a","a",1,"A","b"), SpiritualDetails("a","a","a",1,"a","A"), AdditionalDetails("a","A","A","A","A"))
              firebaseClass.loginUser()
          }
        }
    }

    private fun checkForValidation() : Boolean {
        if(username.text.toString().isEmpty()) {
            username.error = "please enter your username"
            username.requestFocus()
            return false
        }
        if(password.text.toString().isEmpty()) {
            password.error = "please enter the password"
            password.requestFocus()
            return false
        }
        return true
    }
}
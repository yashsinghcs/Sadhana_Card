package com.munik4124.sadhanacard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

class AdminSignUp : AppCompatActivity() {

    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var reEnter_password : EditText
    private lateinit var _email : EditText
    private lateinit var _signUp : Button
    private lateinit var progressBar : ProgressBar
    private lateinit var backToLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_sign_up)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        username = findViewById(R.id.usernamae)
        password = findViewById(R.id.password)
        reEnter_password = findViewById(R.id.re_enter_password)
        _email = findViewById(R.id.email)
        _signUp = findViewById(R.id.sign_Up)
        backToLogin = findViewById(R.id.back_to_login)
         progressBar = findViewById(R.id.progressBar_signUp)

        _signUp.setOnClickListener {
            if(checkForValidation()) {
                progressBar.visibility = View.VISIBLE
                val admin_user : AdminUser = AdminUser("181500188",username.text.toString(),password.text.toString(),_email.text.toString())
                val firebaseClass : FirebaseClass = FirebaseClass(admin_user,this)
                firebaseClass.registerUser()
                progressBar.visibility = View.GONE
            }
            else{
                Toast.makeText(this,"account cannot be created",Toast.LENGTH_SHORT).show()
            }
        }

        backToLogin.setOnClickListener {
            startActivity(Intent(applicationContext,AdminLogin::class.java))
            finish()
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
        if(reEnter_password.text.toString().isEmpty()) {
            reEnter_password.error = "please reEmter the password"
            reEnter_password.requestFocus()
            return false
        }
        if(_email.text.toString().isEmpty()) {
            _email.error = "please enter the email address"
            _email.requestFocus()
            return false
        }
        if(!password.text.toString().equals(reEnter_password.text.toString())) {
            password.error = "mismatched"
            reEnter_password.error = "mismatched"
            password.requestFocus()
            reEnter_password.requestFocus()
            return false
        }
        return true
    }
}
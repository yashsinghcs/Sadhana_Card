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
import com.munik4124.sadhanacard.userExtraDetails_Admin.Personaldetails
import com.munik4124.sadhanacard.userExtraDetails_Admin.SpiritualDetails

class AdminSignUp : AppCompatActivity() {

    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var reEnter_password : EditText
    private lateinit var full_Name : EditText
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
        full_Name = findViewById(R.id.full_name)
        _signUp = findViewById(R.id.sign_Up)
        backToLogin = findViewById(R.id.back_to_login)
         progressBar = findViewById(R.id.progressBar_signUp)

        _signUp.setOnClickListener {
            if(checkForValidation()) {
                progressBar.visibility = View.VISIBLE

                //processing for unique id
                val a_first = full_Name.text.toString().substring(0,2)
                val a_end = full_Name.text.toString().substring(full_Name.text.toString().length - 3)
                val b_first : Int = password.text.toString()[0].toInt() +  password.text.toString()[1].toInt()
                val b_end : Int = password.text.toString()[password.text.toString().length - 2].toInt() + password.text.toString()[password.text.toString().length - 1].toInt()

                val unique_id : String = "" + a_first + "" + b_first + "" + a_end + "" + b_end

                val admin_user : AdminUser = AdminUser(unique_id,username.text.toString(),password.text.toString(),full_Name.text.toString())
                val firebaseClass : FirebaseClass = FirebaseClass(admin_user,this, Personaldetails("a","a","a",1,"A","b"),SpiritualDetails("a","a","a",1,"a","A"))
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
        if(full_Name.text.toString().isEmpty()) {
            full_Name.error = "please enter the email address"
            full_Name.requestFocus()
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
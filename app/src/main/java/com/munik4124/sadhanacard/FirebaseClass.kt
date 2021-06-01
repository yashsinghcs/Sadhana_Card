package com.munik4124.sadhanacard

import android.app.Activity
import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.coroutines.coroutineContext

public class FirebaseClass(val user: AdminUser, val activity: Activity) {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var unique_id: String
    private lateinit var username: String
    private lateinit var password: String
    private lateinit var _fullName: String

    init {
        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("AdminUser")
        unique_id = user.unique_Id
        username = user.user_name
        password = user._password
        _fullName = user.fullName
    }

    public fun registerUser() {

        auth.createUserWithEmailAndPassword(user.userName, user.password)
            .addOnSuccessListener {

                val userdetails: MutableMap<String, Any> = HashMap()
                userdetails["username"] = username
                userdetails["Full Name"] = _fullName
                userdetails["password"] = password
                databaseReference.child(unique_id).setValue(userdetails).addOnFailureListener {
                    Toast.makeText(activity,"account cannot be created",Toast.LENGTH_SHORT).show()
                }.addOnSuccessListener {
                    Toast.makeText(activity,"account created successfully",Toast.LENGTH_SHORT).show()
                    val b : Context = activity
                    b.startActivity(Intent(activity,AdminLogin::class.java))
                    activity.finish()
                    Toast.makeText(activity,"please login to continue",Toast.LENGTH_SHORT).show()
                }

            }
            .addOnFailureListener {
                Toast.makeText(activity,"account cannot be created",Toast.LENGTH_SHORT).show()
            }

    }

    public fun loginUser()  {
      auth.signInWithEmailAndPassword(user.userName,user.password).addOnSuccessListener {
          Toast.makeText(activity,"Login Successfull",Toast.LENGTH_SHORT).show()
           val a : AdminLogin = AdminLogin()
           val b : Context = activity
           b.startActivity(Intent(activity,AdminUserDetails::class.java))
          activity.finish()
      }.addOnFailureListener {
          Toast.makeText(activity,"Login Failed",Toast.LENGTH_SHORT).show()
      }
    }

}
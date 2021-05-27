package com.munik4124.sadhanacard

import android.app.Activity
import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
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
    private lateinit var _emailId: String
    init {
        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("AdminUser")
        unique_id = user.unique_Id
        username = user.user_name
        password = user._password
        _emailId = user.email_Id
    }

    public fun registerUser() {

        auth.createUserWithEmailAndPassword(user.emailId, user.password)
            .addOnSuccessListener {

                val userdetails: MutableMap<String, Any> = HashMap()
                userdetails["username"] = username
                userdetails["email"] = _emailId
                userdetails["password"] = password
                databaseReference.child(unique_id).setValue(userdetails).addOnFailureListener {
                    Toast.makeText(activity,"account cannot be created",Toast.LENGTH_SHORT).show()
                }.addOnSuccessListener {
                    Toast.makeText(activity,"account created successfully",Toast.LENGTH_SHORT).show()
                }

            }
            .addOnFailureListener {
                Toast.makeText(activity,"account cannot be created",Toast.LENGTH_SHORT).show()
            }

    }

}
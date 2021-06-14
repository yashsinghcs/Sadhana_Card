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
import com.google.firebase.database.*
import com.munik4124.sadhanacard.userExtraDetails_Admin.AdditionalDetails
import com.munik4124.sadhanacard.userExtraDetails_Admin.Personaldetails
import com.munik4124.sadhanacard.userExtraDetails_Admin.SpiritualDetails
import kotlin.coroutines.coroutineContext

public class FirebaseClass(User: AdminUser, val activity: Activity, user1 : Personaldetails,user2 : SpiritualDetails,user3 : AdditionalDetails) {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var unique_id: String
    private lateinit var username: String
    private lateinit var password: String
    private lateinit var _fullName: String
    private lateinit var user : AdminUser
    private lateinit var user_details : Personaldetails
    private lateinit var user_details1 : SpiritualDetails
    private lateinit var user_details2 : AdditionalDetails
    init {
        user = User
        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("AdminUser")
        unique_id = user.unique_Id
        username = user.user_name
        password = user._password
        _fullName = user.fullName
    }

    init{
        user_details = user1
    }
    init{
        user_details1 = user2
    }
    init{
        user_details2 = user3
    }
    public fun registerUser() {

        auth.createUserWithEmailAndPassword(user.userName, user.password)
            .addOnSuccessListener {

                val userdetails: MutableMap<String, Any> = HashMap()
                userdetails["username"] = username
                userdetails["Full Name"] = _fullName
                userdetails["password"] = password
                userdetails["uid"] = unique_id
                databaseReference.child(auth.currentUser!!.uid).setValue(userdetails).addOnFailureListener {
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

    public fun registerUserDetails() {
        val databaseReference1 = FirebaseDatabase.getInstance().getReference("AdminUser_Details").child("personal details")
        val userdetails: MutableMap<String, Any> = HashMap()
        userdetails["firstName"] = user_details.first_name
        userdetails["lastName"] = user_details.last_name
        userdetails["bloodGroup"] = user_details.blood_group
        userdetails["age"] = user_details.age
        userdetails["address"] = user_details._address
        userdetails["phoneNo"] = user_details.phone_NO
        databaseReference1.child(auth.currentUser!!.uid).setValue(userdetails).addOnFailureListener {
            Toast.makeText(activity,"cannot be added",Toast.LENGTH_SHORT).show()
        }.addOnSuccessListener {
            Toast.makeText(activity,"added successfully",Toast.LENGTH_SHORT).show()
        }
    }
    public fun registerUserDetailsSpiritual() {
        val databaseReference1 = FirebaseDatabase.getInstance().getReference("AdminUser_Details").child("spiritual details")
        val userdetails: MutableMap<String, Any> = HashMap()
        userdetails["devoteeOrNot"] = user_details1.devoteeOrnot
        userdetails["forHowManyYears"] = user_details1.forHowManyYears
        userdetails["doYouChant"] = user_details1.doYouChant
        userdetails["rounds"] = user_details1.rounds
        userdetails["initiatedOrNot"] = user_details1.initiation
        userdetails["fromWhichMaharaj"] = user_details1.maharaj
        databaseReference1.child(auth.currentUser!!.uid).setValue(userdetails).addOnFailureListener {
            Toast.makeText(activity,"cannot be added",Toast.LENGTH_SHORT).show()
        }.addOnSuccessListener {
            Toast.makeText(activity,"added successfully",Toast.LENGTH_SHORT).show()
        }
    }

    public fun registerUserDetailsAdditionalDetails() {
        val databaseReference1 = FirebaseDatabase.getInstance().getReference("AdminUser_Details").child("additional details")
        val userdetails: MutableMap<String, Any> = HashMap()
        userdetails["interested"] = user_details2.areYouinterested
        userdetails["awareofSadhnaCard"] = user_details2.awareofSadhnaCard
        userdetails["badhabits"] = user_details2.badhabits
        userdetails["mention"] = user_details2.mention
        userdetails["visitedIsckon"] = user_details2.visitedIsckon

        databaseReference1.child(auth.currentUser!!.uid).setValue(userdetails).addOnFailureListener {
            Toast.makeText(activity,"cannot be added",Toast.LENGTH_SHORT).show()
        }.addOnSuccessListener {
            Toast.makeText(activity,"added successfully",Toast.LENGTH_SHORT).show()
        }
    }
}
package com.munik4124.sadhanacard

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import java.util.*

//lets start the app 23
class MostFrontPage : AppCompatActivity() {
    private lateinit var topAnimation : Animation
    private lateinit var botAnimation : Animation
    private lateinit var logo : ImageView
    private lateinit var headertext : TextView
    private lateinit var subHeaderText : TextView
    private lateinit var  options : ActivityOptions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.most_front_page)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Animation
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        botAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        // initializatioions
        logo = findViewById(R.id.nityananda_prabhu)
        headertext = findViewById(R.id.logo)
        subHeaderText = findViewById(R.id.subLogo)

        //setting the animations
        logo.animation = topAnimation
        headertext.animation = botAnimation
        subHeaderText.animation = botAnimation

//for making a animation while moving from one activity to another
        val pairs = android.util.Pair<View,String>(logo,"logo_image")
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            options  = ActivityOptions.makeSceneTransitionAnimation(
                    this,pairs)
        }
        //for making a delay between two activities
        val timer: Timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                goTologinPage()
            }
        }, 3500)
    }

    private fun goTologinPage() {

        val goTologinPage = Intent(this, ChoiceAdminvsDevotees::class.java)
        startActivity(goTologinPage,options.toBundle())
        finish()

    }
}
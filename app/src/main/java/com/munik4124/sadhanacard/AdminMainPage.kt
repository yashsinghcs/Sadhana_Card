package com.munik4124.sadhanacard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class AdminMainPage : AppCompatActivity() {
    private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var drawer : DrawerLayout
    private lateinit var text : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main_page)

      text = findViewById(R.id.text)
        drawer = findViewById(R.id.drawerLayout)
        text.setOnClickListener {
            drawer.openDrawer(Gravity.LEFT)
        }
    }
}
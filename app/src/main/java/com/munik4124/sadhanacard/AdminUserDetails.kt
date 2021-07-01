package com.munik4124.sadhanacard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import com.munik4124.sadhanacard.fragments_admin_userdetails.AdditionalDetailsFragment
import com.munik4124.sadhanacard.fragments_admin_userdetails.PersonalDetailsFragment
import com.munik4124.sadhanacard.fragments_admin_userdetails.SpiritualDetailsFragment

class AdminUserDetails : AppCompatActivity() {
    private lateinit var viewPager : ViewPager
    private lateinit var tabs : com.google.android.material.tabs.TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_user_details)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

       viewPager = findViewById(R.id.viewPager)
        tabs = findViewById(R.id.tabs)

        setUpTabs()

    }

    public fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PersonalDetailsFragment(),"")
        adapter.addFragment(SpiritualDetailsFragment(),"")
        adapter.addFragment(AdditionalDetailsFragment(),"")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_personal_details)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_spiritual_details)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_other_details)
    }


}
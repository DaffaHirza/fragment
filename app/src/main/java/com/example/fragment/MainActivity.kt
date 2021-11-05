package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment.fragment.HomeFragment
import com.example.fragment.fragment.NotificationsFragment
import com.example.fragment.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationsFragment = NotificationsFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_notification -> makeCurrentFragment(notificationsFragment)
                R.id.menu_settings -> makeCurrentFragment(settingsFragment)
            }
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
}
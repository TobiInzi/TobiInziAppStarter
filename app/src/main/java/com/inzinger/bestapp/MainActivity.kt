package com.inzinger.bestapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inzinger.bestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment_content_main)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }

        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        //setup navigation
        val bottomNavigationMenu = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_bottom_bar_1 -> {
                    navController.navigate(R.id.navigation_first)
                    true
                }
                R.id.item_bottom_bar_2 -> {
                    navController.navigate(R.id.navigation_profile)
                    true
                }
                R.id.item_bottom_bar_3 -> {
                    navController.navigate(R.id.navigation_first)
                    true
                }
                R.id.item_bottom_bar_profile -> {
                    navController.navigate(R.id.navigation_profile)
                    true
                }
                else -> false
            } }
        //items not reselectable
        bottomNavigationMenu.setOnItemReselectedListener { }

        //appbar same background color as bottom navigation bar
        val appBar = findViewById<ConstraintLayout>(R.id.top_app_bar)
        appBar.background = bottomNavigationMenu.background
    }

}
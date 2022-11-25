package com.inzinger.bestapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
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

        setupBottomBar()
    }

    private fun setupBottomBar() {
        val bottomNavigationMenu = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationMenu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_my_cards -> {
                    // Respond to navigation item 1 click
                    //test test test
                    navController.navigate(R.id.FirstFragment)
                    true
                }
                R.id.item_profile -> {
                    // Respond to navigation item 2 click
                    navController.navigate(R.id.SecondFragment)

                    true
                }
                else -> false
            } }
        val badge = bottomNavigationMenu.getOrCreateBadge(R.id.item_my_cards)
        badge.isVisible = true
        badge.backgroundColor = ContextCompat.getColor(this, R.color.main_destroy_color)
        val appBar = findViewById<ConstraintLayout>(R.id.top_app_bar)
        appBar.background = bottomNavigationMenu.background
    }

}
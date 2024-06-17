package com.example.noteapp.UI.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.noteapp.R
import com.example.noteapp.UI.utils.PreferenceHelper
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var pref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = PreferenceHelper()
        pref.unit(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.visibility = View.GONE

        if (!pref.isOnBoardShow) {
            binding.bottomNavigation.visibility = View.GONE
            navController.navigate(R.id.onBoardFragment)
        } else {
            navController.navigate(R.id.noteFragment)
            binding.bottomNavigation.visibility = View.VISIBLE

        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.noteFragment) {
                pref.isOnBoardShow = true
            }
        }
    }
}

package com.capstone.explorin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.explorin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpScreen()
    }

    private fun setUpScreen() {
        setUpNavBar()
    }

    private fun setUpNavBar() {
        val bottomNavigationView = binding.bottomNavigationBar

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_fragment -> {
                    menuItem.setIcon(if (menuItem.isChecked) R.drawable.ic_home_filled else R.drawable.ic_home)
                }
                R.id.search_fragment -> {
                    menuItem.setIcon(if (menuItem.isChecked) R.drawable.ic_search_filled else R.drawable.ic_search)
                }
                R.id.fav_list_fragment -> {
                    menuItem.setIcon(if (menuItem.isChecked) R.drawable.ic_fav_filled else R.drawable.ic_fav)
                }
                R.id.account_fragment -> {
                    menuItem.setIcon(if (menuItem.isChecked) R.drawable.ic_nav_user_filled else R.drawable.ic_nav_user)
                }
            }
            true
        }
    }
}
package com.capstone.explorin.presentation.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.capstone.explorin.R
import com.capstone.explorin.data.datastore.UserPreferences
import com.capstone.explorin.databinding.ActivityWelcomeBinding
import com.capstone.explorin.presentation.ui.auth.login.LoginActivity
import com.capstone.explorin.presentation.ui.auth.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
    }

    private fun setUpUI() {
        btnClicked()
    }

    private fun btnClicked() {
        binding.btnStart.setOnClickListener {
            val toLogin = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(toLogin)
        }
    }
}
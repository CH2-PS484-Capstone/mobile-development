package com.capstone.explorin.presentation.ui.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.viewModels
import com.capstone.explorin.R
import com.capstone.explorin.data.datasource.remote.response.LoginRequest
import com.capstone.explorin.databinding.ActivityLoginBinding
import com.capstone.explorin.presentation.customview.CustomEmailEditText
import com.capstone.explorin.presentation.customview.CustomPasswordEditText
import com.google.android.material.button.MaterialButton


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setUpUI()
    }

    private fun setUpUI() {
//        buttonClicked()
//        playAnimation()
//        observeData()
    }

    private fun buttonClicked() {
        val loginButton: MaterialButton = binding.btnLogin
        val emailEditText: CustomEmailEditText = binding.edtEmailInput
        val passwordEditText: CustomPasswordEditText = binding.edtPasswordInput

        loginButton.setOnClickListener {
            emailEditText.clearFocus()
            passwordEditText.clearFocus()

            if (emailEditText.isEmailValid && passwordEditText.isPasswordValid) {
                val requestLogin = LoginRequest(
                    emailEditText.text.toString().trim(),
                    passwordEditText.text.toString().trim()
                )
                loginViewModel.login(requestLogin)
            } else {
                if (!emailEditText.isEmailValid) emailEditText.error =
                    getString(R.string.email_none)
                if (!passwordEditText.isPasswordValid) passwordEditText.error =
                    getString(R.string.password_none)

                Toast.makeText(this, R.string.login_invalid, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
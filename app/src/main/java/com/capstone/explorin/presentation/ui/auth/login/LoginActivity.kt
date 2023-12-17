package com.capstone.explorin.presentation.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.capstone.explorin.MainActivity
import com.capstone.explorin.R
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.databinding.ActivityLoginBinding
import com.capstone.explorin.presentation.customview.CustomEmailEditText
import com.capstone.explorin.presentation.customview.CustomPasswordEditText
import com.capstone.explorin.presentation.ui.auth.AuthViewModel
import com.capstone.explorin.presentation.ui.auth.register.RegisterActivity
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        lifecycleScope.launch {
            loginViewModel.loginstate.collect { uiState ->
                Log.d("cek isLoading", uiState.isLoading.toString())
                loadingStateIsToggled(uiState.isLoading)
                errorStateIsToggled(uiState.isError)
                successStateIsToggled(uiState.LoginResult)
            }
        }
        setUpUI()
    }

    private fun setUpUI() {
        buttonClicked()
    }

    private fun buttonClicked() {
        val toRegister: TextView = binding.goRegister
        val loginButton: MaterialButton = binding.btnLogin
        val emailEditText: CustomEmailEditText = binding.edtEmailInput
        val passwordEditText: CustomPasswordEditText = binding.edtPasswordInput

        loginButton.setOnClickListener {
            emailEditText.clearFocus()
            passwordEditText.clearFocus()

            if (emailEditText.isEmailValid && passwordEditText.isPasswordValid) {
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()
                loginViewModel.login(email, password)
            } else {
                if (!emailEditText.isEmailValid) emailEditText.error =
                    getString(R.string.email_none)
                if (!passwordEditText.isPasswordValid) passwordEditText.error =
                    getString(R.string.password_none)

                Toast.makeText(this, R.string.login_invalid, Toast.LENGTH_SHORT).show()
            }
        }

        toRegister.setOnClickListener {
            val goRegister = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(goRegister)
            finish()
        }


    }


    private fun successStateIsToggled(loginResult: LoginResponse?) {
        if (loginResult?.loginResult != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loadingStateIsToggled(value: Boolean) {
        binding.apply {
            val loadingState = binding.progressBar
            loadingState.visibility = if (value) View.VISIBLE else View.GONE
        }
    }

    private fun errorStateIsToggled(value: Boolean) {
        if (value) {
            Toast.makeText(this, getString(R.string.login_invalid), Toast.LENGTH_LONG).show()
        }
    }
}
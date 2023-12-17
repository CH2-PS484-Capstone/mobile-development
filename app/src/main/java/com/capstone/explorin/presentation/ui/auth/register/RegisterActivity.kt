package com.capstone.explorin.presentation.ui.auth.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.capstone.explorin.MainActivity
import com.capstone.explorin.R
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterRequest
import com.capstone.explorin.data.datasource.remote.response.RegisterResponse
import com.capstone.explorin.databinding.ActivityLoginBinding
import com.capstone.explorin.databinding.ActivityRegisterBinding
import com.capstone.explorin.presentation.customview.CustomEmailEditText
import com.capstone.explorin.presentation.customview.CustomNameEditText
import com.capstone.explorin.presentation.customview.CustomPasswordEditText
import com.capstone.explorin.presentation.ui.auth.AuthViewModel
import com.capstone.explorin.presentation.ui.auth.login.LoginActivity
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setUpUI()
    }

    private fun setUpUI() {
        btnClicked()
    }

    private fun btnClicked() {

        val toLogin: TextView = binding.goLogin
        val registerButton: MaterialButton = binding.btnRegister
        val nameEditText: CustomNameEditText = binding.edtNameInput
        val emailEditText: CustomEmailEditText = binding.edtEmailInput
        val passwordEditText: CustomPasswordEditText = binding.edtPasswordInput

        toLogin.setOnClickListener {
            val goLogin = Intent(this, LoginActivity::class.java)
            startActivity(goLogin)
            finish()
        }

        registerButton.setOnClickListener {
            nameEditText.clearFocus()
            emailEditText.clearFocus()
            passwordEditText.clearFocus()

            if (binding.edtNameInput.isNameValid && binding.edtEmailInput.isEmailValid && binding.edtPasswordInput.isPasswordValid) {
                val name = nameEditText.text.toString().trim()
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()


//                val data = viewModel.state.value
                lifecycleScope.launch {
                    viewModel.registerUsers(name, email, password)
                }
            }


            lifecycleScope.launch {
                viewModel.regisstate.collect { uiState ->
                    Log.d("cek isLoading", uiState.isLoading.toString())
                    loadingStateIsToggled(uiState.isLoading)
                    errorStateIsToggled(uiState.isError)
                    successStateIsToggled(uiState.result)
                }
            }
        }
    }




    private fun successStateIsToggled(result: RegisterResponse?) {
        if (result?.error == false) {
            Toast.makeText(this, "Akun berhasil didaftarkan", Toast.LENGTH_SHORT).show()
            viewModel.getLoginSession().observe(this) { sessionTrue ->
                if (sessionTrue) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
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
            Toast.makeText(this, getString(R.string.register_invalid), Toast.LENGTH_LONG).show()
        }
    }
}
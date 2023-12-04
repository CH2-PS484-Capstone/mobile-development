package com.capstone.explorin.presentation.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.capstone.explorin.MainActivity
import com.capstone.explorin.R
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterResponse
import com.capstone.explorin.databinding.ActivityLoginBinding
import com.capstone.explorin.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel by viewModels<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        lifecycleScope.launch {
            registerViewModel.state.collect { uiState ->
                Log.d("cek isLoading", uiState.isLoading.toString())
                loadingStateIsToggled(uiState.isLoading)
                errorStateIsToggled(uiState.isError)
//                successStateIsToggled(uiState.registerResult)
            }
        }
        setUpUI()
    }

    private fun setUpUI() {
        TODO("Not yet implemented")
    }

//    private fun successStateIsToggled(registerResult: RegisterResponse?) {
//        if (registerResult?.registerResult != null) {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }

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
package com.capstone.explorin.presentation.ui.auth.register

import com.capstone.explorin.data.datasource.remote.response.RegisterRequest
import com.capstone.explorin.data.datasource.remote.response.RegisterResponse


data class RegisterUiState (
    val isLoading : Boolean = false,
    val isError : Boolean = false,
    val name : String = "",
    val email : String = "",
    val password : String = "",
    val request: RegisterRequest? = null,
    val result : RegisterResponse? = null
)
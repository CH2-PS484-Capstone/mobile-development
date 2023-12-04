package com.capstone.explorin.presentation.ui.register

import com.capstone.explorin.data.datasource.remote.response.RegisterResponse


data class RegisterUiState (
    val isLoading : Boolean = false,
    val isError : Boolean = false,
    val registerResult : RegisterResponse? = null
)
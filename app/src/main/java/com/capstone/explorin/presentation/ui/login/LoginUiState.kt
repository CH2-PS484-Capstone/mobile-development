package com.capstone.explorin.presentation.ui.login

import com.capstone.explorin.data.datasource.remote.response.LoginResponse


data class LoginUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val LoginResult: LoginResponse? = null
)
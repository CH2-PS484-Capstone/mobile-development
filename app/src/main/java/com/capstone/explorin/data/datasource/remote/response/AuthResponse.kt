package com.capstone.explorin.data.datasource.remote.response

data class RegisterResponse(
    var error: Boolean,
    var message: String
)

data class RegisterRequest(
    var name: String,
    var email: String,
    var password: String
)

data class LoginRequest(
    var email: String,
    var password: String
)

data class LoginResponse(
    var error: Boolean,
    var message: String,
    var loginResult: LoginResult
)

data class LogoutResponse(
    var error: Boolean,
    var message: String
)

data class LoginResult(
    var userId: String,
    var name: String,
    var token: String
)
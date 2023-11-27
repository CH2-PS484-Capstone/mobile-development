package com.capstone.explorin.data.datasource.remote.response

data class DetailResponse(
    var error: Boolean,
    var message: String
)

data class RegisterAccount(
    var name: String,
    var email: String,
    var password: String
)

data class LoginAccount(
    var email: String,
    var password: String
)

data class LoginResponse(
    var error: Boolean,
    var message: String,
    var loginResult: LoginResult
)

data class LoginResult(
    var userId: String,
    var name: String,
    var token: String
)
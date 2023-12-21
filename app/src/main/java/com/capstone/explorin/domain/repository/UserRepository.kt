package com.capstone.explorin.domain.repository

import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.LogoutResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun login(email: String, password: String): Flow<Result<LoginResponse>>
    suspend fun register(
        name: String,
        email: String,
        password: String,
    ): Flow<Result<RegisterResponse>>
    suspend fun logout(): Flow<Result<LogoutResponse>>
    suspend fun saveAccessToken(token: String)
    suspend fun removeAccessToken()
    fun getLoginSession(): Flow<Boolean>
    suspend fun saveLoginSession(session: Boolean)
    fun getAccessToken(): Flow<String?>
//    suspend fun getProfile(): Flow<Result<AccountResponse>>
}
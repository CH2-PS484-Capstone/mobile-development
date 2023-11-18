package com.capstone.explorin.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun validateInput(email: String, password: String): Boolean
    suspend fun authenticate(email: String, password: String): String
    suspend fun saveToken(token: String)
    suspend fun isLoggedIn(): Flow<Boolean?>
}
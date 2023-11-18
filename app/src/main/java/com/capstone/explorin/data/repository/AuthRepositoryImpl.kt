package com.capstone.explorin.data.repository

import com.capstone.explorin.data.datastore.DataStoreManager
import com.capstone.explorin.domain.repository.LoginRepository
import com.capstone.explorin.domain.repository.RegisterRepository
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val dataStoreManager: DataStoreManager,
) : LoginRepository, RegisterRepository {
    override suspend fun validateInput(email: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun authenticate(email: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun saveToken(token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun isLoggedIn(): Flow<Boolean?> {
        TODO("Not yet implemented")
    }

    override suspend fun validateInput(fullname: String, email: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun register(fullname: String, email: String, password: String) {
        TODO("Not yet implemented")
    }


}
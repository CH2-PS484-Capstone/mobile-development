package com.capstone.explorin.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.capstone.explorin.data.datasource.remote.ApiService
import com.capstone.explorin.data.datasource.remote.response.DetailResponse
import com.capstone.explorin.data.datasource.remote.response.LoginAccount
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterAccount
import com.capstone.explorin.domain.repository.UserRepository
import retrofit2.Call

class UserRepositoryImpl(
    private val apiService: ApiService,
    private val dataStore: DataStore<Preferences>
) : UserRepository {

    override suspend fun register(requestRegister: RegisterAccount): Call<DetailResponse> {
        return apiService.registerUser(requestRegister)
    }

    override suspend fun login(requestLogin: LoginAccount): Call<LoginResponse> {
        return apiService.loginUser(requestLogin)
    }
}
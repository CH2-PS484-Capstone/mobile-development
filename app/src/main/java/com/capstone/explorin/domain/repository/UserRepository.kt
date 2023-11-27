package com.capstone.explorin.domain.repository

import com.capstone.explorin.data.datasource.remote.response.DetailResponse
import com.capstone.explorin.data.datasource.remote.response.LoginAccount
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterAccount
import retrofit2.Call

interface UserRepository {
    suspend fun register(requestRegister: RegisterAccount): Call<DetailResponse>
    suspend fun login(requestLogin: LoginAccount): Call<LoginResponse>
}
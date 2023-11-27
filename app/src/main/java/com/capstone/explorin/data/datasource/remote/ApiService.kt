package com.capstone.explorin.data.datasource.remote

import com.capstone.explorin.data.datasource.remote.response.DetailResponse
import com.capstone.explorin.data.datasource.remote.response.LoginAccount
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterAccount
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("register")
    fun registerUser(@Body requestRegister: RegisterAccount): Call<DetailResponse>

    @POST("login")
    fun loginUser(@Body requestLogin: LoginAccount): Call<LoginResponse>
}
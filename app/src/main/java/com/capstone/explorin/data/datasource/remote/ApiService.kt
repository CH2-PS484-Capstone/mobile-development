package com.capstone.explorin.data.datasource.remote

import com.capstone.explorin.data.datasource.remote.response.ItineraryResponse
import com.capstone.explorin.data.datasource.remote.response.ItineraryResponseItem
import com.capstone.explorin.data.datasource.remote.response.LoginRequest
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.LogoutResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterRequest
import com.capstone.explorin.data.datasource.remote.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("register")
    suspend fun registerUser(@Body requestRegister: RegisterRequest): RegisterResponse

    @POST("login")
    suspend fun loginUser(@Body requestLogin: LoginRequest): Call<LoginResponse>

    @POST("logout")
    suspend fun logout(
        @Header("Authorization") token: String
    ): LogoutResponse

    @GET("itinerary")
    fun getAllItinerary(): ItineraryResponse

    @GET("itinerary/{id}")
    fun getItineraryById(@Path("id") id: Int): ItineraryResponseItem
}
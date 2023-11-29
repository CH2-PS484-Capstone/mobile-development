package com.capstone.explorin.data.datasource.remote

import com.capstone.explorin.data.datasource.remote.response.DetailResponse
import com.capstone.explorin.data.datasource.remote.response.ItineraryResponse
import com.capstone.explorin.data.datasource.remote.response.ItineraryResponseItem
import com.capstone.explorin.data.datasource.remote.response.LoginAccount
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterAccount
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("register")
    fun registerUser(@Body requestRegister: RegisterAccount): Call<DetailResponse>

    @GET("login")
    fun loginUser(@Body requestLogin: LoginAccount): Call<LoginResponse>

    @GET("itinerary")
    fun getAllItinerary(): ItineraryResponse

    @GET("itinerary/{id}")
    fun getItineraryById(@Path("id") id: Int): ItineraryResponseItem
}
package com.capstone.explorin.data.repository


import com.capstone.explorin.BuildConfig
import com.capstone.explorin.R
import com.capstone.explorin.data.datasource.remote.ApiService
import com.capstone.explorin.data.datasource.remote.response.LoginRequest
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.LogoutResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterRequest
import com.capstone.explorin.data.datasource.remote.response.RegisterResponse
import com.capstone.explorin.data.datastore.UserPreferences
import com.capstone.explorin.domain.repository.UserRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val pref: UserPreferences,
    private val assetManager: AssetManager
) : UserRepository {
    override suspend fun login(email: String, password: String): Flow<Result<LoginResponse>> = flow {
        try {
            val request = LoginRequest(email, password)
            val response: LoginResponse = if (BuildConfig.IS_SERVICE_UP) {
                apiService.loginUser(request)
            } else {
                val gson = Gson()
                val stringJson = assetManager.getStringJson(R.raw.login)
                delay(2500L)
                gson.fromJson(stringJson, LoginResponse::class.java)
            }
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun register(
        name: String,
        email: String,
        password: String,
    ): Flow<Result<RegisterResponse>> = flow {
        try {
            val request = RegisterRequest(name, email, password)
            val response: RegisterResponse = if (BuildConfig.IS_SERVICE_UP) {
                apiService.registerUser(request)
            } else {
                val gson = Gson()
                val stringJson = assetManager.getStringJson(R.raw.register)
                delay(2500L)
                gson.fromJson(stringJson, RegisterResponse::class.java)
            }
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun logout(): Flow<Result<LogoutResponse>> = flow {
        try {
            val response: LogoutResponse = if (BuildConfig.IS_SERVICE_UP) {
                var token = "Bearer "
                runBlocking {
                    token += pref.getAccessToken().first()
                }
                apiService.logout(token)
            } else {
                val gson = Gson()
                val stringJson = assetManager.getStringJson(R.raw.login)
                delay(2500L)
                gson.fromJson(stringJson, LogoutResponse::class.java)
            }
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun saveAccessToken(token: String) {
        pref.saveAccessToken(token)
    }

    override suspend fun removeAccessToken() {
        pref.removeAccessToken()
    }

    override fun getAccessToken(): Flow<String?> = pref.getAccessToken()


}

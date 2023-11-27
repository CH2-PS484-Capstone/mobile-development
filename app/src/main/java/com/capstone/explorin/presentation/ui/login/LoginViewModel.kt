package com.capstone.explorin.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.explorin.data.datasource.remote.response.LoginAccount
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.domain.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResponse>()
    val loginResult: LiveData<LoginResponse> = _loginResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun login(loginAccount: LoginAccount) {
        _isLoading.value = true
        val repo = userRepository.login(loginAccount)
        repo.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                _isLoading.value = false
                val responseBody = response.body()

                if (response.isSuccessful) {
                    _loginResult.value = responseBody!!
                    _message.value = "Hello ${_loginResult.value!!.loginResult.name}!"
                } else {
                    when (response.code()) {
                        401 -> _message.value =
                            "Email atau password yang anda masukan salah, silahkan coba lagi"
                        408 -> _message.value =
                            "Koneksi internet anda lambat, silahkan coba lagi"
                        else -> _message.value = "Pesan error: " + response.message()
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _isLoading.value = false
                _message.value = "Pesan error: " + t.message.toString()
            }

        })
    }

}
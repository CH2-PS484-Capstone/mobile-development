package com.capstone.explorin.presentation.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.datasource.remote.response.RegisterResponse
import com.capstone.explorin.domain.repository.UserRepository
import com.capstone.explorin.presentation.ui.auth.login.LoginUiState
import com.capstone.explorin.presentation.ui.auth.register.RegisterUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: UserRepository,
) : ViewModel() {

    private val _loginstate = MutableStateFlow(LoginUiState())
    val loginstate: StateFlow<LoginUiState> = _loginstate

    fun login(email: String, password: String) {
        viewModelScope.launch {
            setLoginError(false)
            setLoginLoading(true)
            repo.login(email, password).collect { result ->
                setLoginLoading(false)
                result.onSuccess {
                    it.loginResult.token.let { token -> repo.saveAccessToken(token) }
                    setLoginResult(it)
                }
                result.onFailure {
                    setLoginError(true)
                }
            }
        }
    }

    private fun setLoginLoading(value: Boolean) {
        _loginstate.update {
            it.copy(isLoading = value)
        }
    }

    private fun setLoginError(value: Boolean) {
        _loginstate.update {
            it.copy(isError = value)
        }
    }

    private fun setLoginResult(value: LoginResponse) {
        _loginstate.update {
            it.copy(LoginResult = value)
        }
    }

    private var _regisstate = MutableStateFlow(RegisterUiState())
    val regisstate : StateFlow<RegisterUiState> = _regisstate

    fun registerUsers(name:String, email:String, password : String){
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            repo.register(name,email,password).collect { result ->
                isLoading(false)

                result.onFailure {
                    isError(true)
                }
                result.onSuccess {
                    registerSuccess(it)
                }
            }
        }
    }

    private fun isLoading (value : Boolean){
        _regisstate.update {
            it.copy(isLoading = value)
        }
    }
    private fun isError (value : Boolean){
        _regisstate.update {
            it.copy(isError = value)
        }
    }
    private fun registerSuccess(value : RegisterResponse){
        _regisstate.update {
            it.copy(result = value)
        }
    }

    fun getLoginSession(): LiveData<Boolean> {
        return repo.getLoginSession().asLiveData()
    }

    fun saveLoginSession(loginSession: Boolean) {
        viewModelScope.launch {
            repo.saveLoginSession(loginSession)
        }
    }


}
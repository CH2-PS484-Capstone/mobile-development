package com.capstone.explorin.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.remote.response.LoginResponse
import com.capstone.explorin.data.repository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: UserRepositoryImpl,
) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state : StateFlow<LoginUiState> = _state

    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: Flow<Boolean> = _isLoading

    fun login(email: String, password : String) {
        viewModelScope.launch {
            setError(false)
            setLoading(true)
            repo.login(email,password).collect{ result ->
                setLoading(false)
                result.onSuccess {
                    it.loginResult.token.let { token -> repo.saveAccessToken(token) }
                    setResult(it)
                }
                result.onFailure {
                    setError(true)
                }
            }
        }
    }

    private fun setLoading(value:Boolean){
        _state.update {
            it.copy(isLoading = value)
        }
    }
    private fun setError(value:Boolean){
        _state.update {
            it.copy(isError = value)
        }
    }

    private fun setResult(value : LoginResponse){
        _state.update {
            it.copy(LoginResult = value)
        }
    }
}
package com.capstone.explorin.presentation.ui.auth.register


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.remote.response.RegisterResponse

import com.capstone.explorin.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repo: UserRepository,
) : ViewModel() {

    private var _state = MutableStateFlow(RegisterUiState())
    val state : StateFlow<RegisterUiState> = _state

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
        _state.update {
            it.copy(isLoading = value)
        }
    }
    private fun isError (value : Boolean){
        _state.update {
            it.copy(isError = value)
        }
    }
    private fun registerSuccess(value : RegisterResponse){
        _state.update {
            it.copy(result = value)
        }
    }


}
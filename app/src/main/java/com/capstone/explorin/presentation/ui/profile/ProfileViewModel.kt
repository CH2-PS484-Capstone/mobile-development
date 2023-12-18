package com.capstone.explorin.presentation.ui.profile

import androidx.lifecycle.ViewModel
import com.capstone.explorin.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repo: UserRepository,
): ViewModel() {

    private val _state = MutableStateFlow(ProfileUiState())
    val state: StateFlow<ProfileUiState> = _state
    /** Wait for Endpoint

    fun getAccount() {
        viewModelScope.launch {
            setError(false)
            setLoading(true)

            repo.getAccount().collect { result ->
                setLoading(false)

                result.onSuccess { response ->
                    response.data?.account?.let { account ->
                        setData(account)
                    }

                    Log.d("AccountViewModel", response.toString())
                }

                result.onFailure {
                    setError(true)
                }
            }
        }
    }

    fun logout(callback: () -> Unit) {
        viewModelScope.launch {
            setError(false)
            setLoading(true)

            repo.logout().collect { result ->
                setLoading(false)

                result.onSuccess {
                    repo.removeAccessToken()

                    callback()
                }

                result.onFailure {
                    setError(true)
                }
            }
        }
    }

    private fun setLoading(value: Boolean) {
        _state.update { currentState ->
            currentState.copy(isLoading = value)
        }
    }

    private fun setError(value: Boolean) {
        _state.update { currentState ->
            currentState.copy(isError = value)
        }
    }

    private fun setData(value: Account) {
        _state.update { currentState ->
            currentState.copy(account = value)
        }
    }

    **/
}
package com.capstone.explorin.presentation.ui.buddies

import androidx.lifecycle.ViewModel
import com.capstone.explorin.presentation.ui.buddies.detailbuddies.DetailBuddiesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class BuddiesViewModel: ViewModel() {

    private val _state = MutableStateFlow(DetailBuddiesUiState())
    val state: StateFlow<DetailBuddiesUiState> = _state

    private fun getBuddies() {

    }


    private fun isLoading(value: Boolean) {
        _state.update { currentState ->
            currentState.copy(isLoading = value)
        }
    }

    private fun isError(value: Boolean) {
        _state.update { currentState ->
            currentState.copy(isError = value)
        }
    }

}
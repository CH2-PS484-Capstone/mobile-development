package com.capstone.explorin.presentation.ui.buddies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.FakeDataGenerator.Companion.buddiesData
import com.capstone.explorin.domain.model.BuddiesList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BuddiesViewModel: ViewModel() {

    private val _state = MutableStateFlow(BuddiesUiState())
    val state: StateFlow<BuddiesUiState> = _state

    fun getBuddies() {
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakeBuddies = buddiesData()
            setBuddies(fakeBuddies)

            isLoading(false)
        }
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

    private fun setBuddies(buddies: List<BuddiesList>) {
        _state.update {
            it.copy(buddies = buddies)
        }
    }

}
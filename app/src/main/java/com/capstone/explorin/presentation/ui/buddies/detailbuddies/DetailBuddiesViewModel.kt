package com.capstone.explorin.presentation.ui.buddies.detailbuddies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.FakeDataGenerator
import com.capstone.explorin.domain.model.BuddiesList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailBuddiesViewModel: ViewModel() {

    private val _state = MutableStateFlow(DetailBuddiesUiState())
    val state: StateFlow<DetailBuddiesUiState> = _state

    fun getBuddies(id: Int) {
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakeBuddies = FakeDataGenerator.detailBuddies(id)
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

    private fun setBuddies(buddies: BuddiesList) {
        _state.update {
            it.copy(detail = buddies)
        }
    }

}
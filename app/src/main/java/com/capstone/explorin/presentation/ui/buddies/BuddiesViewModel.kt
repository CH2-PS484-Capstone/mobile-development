package com.capstone.explorin.presentation.ui.buddies

import androidx.lifecycle.ViewModel
import com.capstone.explorin.presentation.ui.detail.DetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BuddiesViewModel: ViewModel() {

    private val _state = MutableStateFlow(DetailUiState())
    val state: StateFlow<DetailUiState> = _state
}
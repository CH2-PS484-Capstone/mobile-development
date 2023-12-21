package com.capstone.explorin.presentation.ui.buddies

import com.capstone.explorin.domain.model.BuddiesList


data class BuddiesUiState (
    val isLoading : Boolean = false,
    val isError : Boolean  = false,
    val buddies: List<BuddiesList> = emptyList()
)
package com.capstone.explorin.presentation.ui.detail

import com.capstone.explorin.domain.model.Itinerary

data class DetailUiState (
    val isLoading : Boolean = false,
    val isError : Boolean  = false,
    val itinerary: Itinerary? = null
)
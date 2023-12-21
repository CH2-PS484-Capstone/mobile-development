package com.capstone.explorin.presentation.ui.favorite

import com.capstone.explorin.domain.model.Itinerary

data class FavListUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isEmpty: Boolean = false,
    val itineraries: List<Itinerary> = emptyList()
)
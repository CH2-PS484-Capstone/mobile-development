package com.capstone.explorin.presentation.ui.home

import com.capstone.explorin.domain.model.BuddiesList
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.City
import com.capstone.explorin.domain.model.Itinerary


data class HomeUiState (
    val isLoading : Boolean = false,
    val isError : Boolean  = false,
    val categories : List<Category> = emptyList(),
    val recommendations : List<Itinerary> = emptyList(),
    val city : List<City> = emptyList(),
    val buddies: List<BuddiesList> = emptyList()
)
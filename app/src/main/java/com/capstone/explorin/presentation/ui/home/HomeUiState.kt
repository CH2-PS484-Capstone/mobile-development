package com.capstone.explorin.presentation.ui.home

import com.capstone.explorin.domain.model.BuddiesList
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.City
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.domain.model.User


data class HomeUiState (
    val isLoading : Boolean = false,
    val isError : Boolean  = false,
    val categories : List<Category> = emptyList(),
    val recommendations : List<Itinerary> = emptyList(),
    val city : List<City> = emptyList(),
    val buddies: List<BuddiesList> = emptyList(),
    val user: User? = null
)
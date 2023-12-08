package com.capstone.explorin.presentation.ui.home

import com.capstone.explorin.data.response.City
import com.capstone.explorin.domain.model.Category


data class HomeUiState (
    val isLoading : Boolean = false,
    val isError : Boolean  = false,
    val categories : List<Category> = emptyList(),
//    val recommendations : List<POI> = emptyList(),
    val city : List<City> = emptyList()
)
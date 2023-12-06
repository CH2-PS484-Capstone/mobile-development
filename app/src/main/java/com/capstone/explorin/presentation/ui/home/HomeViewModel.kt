package com.capstone.explorin.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.local.entity.CategoryEntity
import com.capstone.explorin.data.datasource.local.entity.CityEntity
import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import com.capstone.explorin.domain.repository.ItineraryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: ItineraryRepository
) : ViewModel() {
    private val _cities = MutableStateFlow<List<CityEntity>>(emptyList())
    val cities: StateFlow<List<CityEntity>> = _cities

    private val _categories = MutableStateFlow<List<CategoryEntity>>(emptyList())
    val categories: StateFlow<List<CategoryEntity>> = _categories

    private val _itineraries = MutableStateFlow<List<ItineraryWithCityAndCategory>>(emptyList())
    val itineraries: StateFlow<List<ItineraryWithCityAndCategory>> = _itineraries

    init {
//        fetchCities()
        fetchCategories()
        fetchItineraries()
    }

//    private fun fetchCities() {
//        viewModelScope.launch {
//            repo.getCitiesWithItineraries().collect { citiesWithItineraries ->
//                val citiesList = citiesWithItineraries?.flatMap { it.itineraries.map { itinerary -> itinerary.cityId } } ?: emptyList()
//                _cities.value = citiesList
//            }
//        }
//    }

    private fun fetchCategories() {
        viewModelScope.launch {
            repo.getCategoriesWithItineraries().collect { categoriesWithItineraries ->
                val categoriesList = categoriesWithItineraries?.map { it.category } ?: emptyList()
                _categories.value = categoriesList
            }
        }
    }

    private fun fetchItineraries() {
        viewModelScope.launch {
            repo.getAllItineraries().collect { itineraries ->
                _itineraries.value = itineraries ?: emptyList()
            }
        }
    }
}
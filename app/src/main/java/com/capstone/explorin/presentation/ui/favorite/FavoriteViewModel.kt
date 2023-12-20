package com.capstone.explorin.presentation.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.FakeDataGenerator
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.domain.model.Position
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteViewModel: ViewModel() {
    private val _state = MutableStateFlow(FavListUiState())
    val state: StateFlow<FavListUiState> = _state

    fun getFavorites(){
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakeFavorites = FakeDataGenerator.itineraryData()
            setFavorites(fakeFavorites)

            isLoading(false)

        }
    }

    private fun isLoading(value : Boolean){
        _state.update {
            it.copy(isLoading = value)
        }
    }
    private fun isError(value : Boolean){
        _state.update {
            it.copy(isLoading = value)
        }
    }


    private fun setFavorites(favorites: List<Itinerary>) {
        _state.update {
            it.copy(itineraries = favorites)
        }
    }
}
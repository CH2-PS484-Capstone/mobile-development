package com.capstone.explorin.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.FakeDataGenerator
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.Gallery
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.domain.model.Position
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel(
) {

    private val _state = MutableStateFlow(DetailUiState())
    val state: StateFlow<DetailUiState> = _state

    private val _itinerary = MutableStateFlow<Itinerary?>(null)
    val itinerary: StateFlow<Itinerary?> = _itinerary


    fun getDetailItinerary(id: Int) {
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakeCity = FakeDataGenerator.detailItinerary(id)
            setDetail(fakeCity)

            _itinerary.value = fakeCity

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

    private fun setDetail(value: Itinerary) {
        _state.update { currentState ->
            currentState.copy(itinerary = value)
        }
    }

    /** DUMMY DATA **/

//    private fun setItinerary(itinerary: Itinerary) {
//        _state.update {
//            it.copy(itinerary = itinerary)
//        }
//    }

}
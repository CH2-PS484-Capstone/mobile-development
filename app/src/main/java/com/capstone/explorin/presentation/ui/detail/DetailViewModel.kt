package com.capstone.explorin.presentation.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.Gallery
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.domain.model.Position
import com.capstone.explorin.domain.repository.ItineraryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

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

            val fakeCity = detailItinerary(id)
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

    private fun detailItinerary(id: Int): Itinerary {
        return when (id) {
            1 -> {
                Itinerary(
                    id = 1,
                    name = "Candi Borobudur",
                    category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                    image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                    description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                    location = "Yogyakarta",
                    position = Position(long = 7.7520, lat = 110.4916),
                    gallery = listOf(
                        Gallery(
                            id = 1,
                            image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg"
                        )
                    )
                )
            }

            else -> {
                Itinerary(id = 10, name = "Default Name", category = Category(1, "", ""), image = "", description = "", location = "", position = Position())
            }
        }

    }

//    private fun setItinerary(itinerary: Itinerary) {
//        _state.update {
//            it.copy(itinerary = itinerary)
//        }
//    }

}
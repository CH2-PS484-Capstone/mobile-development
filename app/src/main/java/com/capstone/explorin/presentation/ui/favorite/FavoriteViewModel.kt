package com.capstone.explorin.presentation.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

            val fakeFavorites = favoritesData()
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


    private fun favoritesData(): List<Itinerary> {
        return listOf(
            Itinerary(
                id = 1,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 7.7520, lat = 110.4916)
            ),
            Itinerary(
                id = 2,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 7.7520, lat = 110.4916)
            ),
            Itinerary(
                id = 3,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 7.7520, lat = 110.4916)
            ),
            Itinerary(
                id = 4,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 7.7520, lat = 110.4916)
            ),
            Itinerary(
                id = 5,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 7.7520, lat = 110.4916)
            )
        )
    }

    private fun setFavorites(favorites: List<Itinerary>) {
        _state.update {
            it.copy(itineraries = favorites)
        }
    }
}
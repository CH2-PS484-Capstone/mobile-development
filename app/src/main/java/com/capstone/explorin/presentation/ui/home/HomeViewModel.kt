package com.capstone.explorin.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.local.entity.CategoryEntity
import com.capstone.explorin.data.datasource.local.entity.CityEntity
import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.City
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.domain.model.Position
import com.capstone.explorin.domain.repository.ItineraryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class HomeViewModel  : ViewModel() {
    private var _state = MutableStateFlow(HomeUiState())
    val state : StateFlow<HomeUiState> = _state
    fun getCategories(){
        viewModelScope.launch {
            isLoading(true)
            isError(false)

//            repo.getCategories().collect{ result ->
//                isLoading(false)
//                result.onSuccess {
//                    setCategories(it.data)
//                }
//                result.onFailure {
//                    isError(true)
//                }
//            }

            val fakeCategories = categoryData()
            setCategories(fakeCategories)

            isLoading(false)
        }
    }

    fun getPopular(){
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakePopular = popularData()
            setItinerary(fakePopular)

            isLoading(false)
        }
    }

    fun getCities(){
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakeCity = citiesData()
            setCities(fakeCity)

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

    /** # DUMMY DATA **/

    private fun categoryData(): List<Category> {
        return listOf(
            Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
            Category(idCategory = 2, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Sejarah"),
            Category(idCategory = 3, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Pantai"),
            Category(idCategory = 3, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Pantai")
        )
    }

    private fun setCategories(categories: List<Category>) {
        _state.update {
            it.copy(categories = categories)
        }
    }

    private fun popularData(): List<Itinerary> {
        return listOf(
            Itinerary(
                id = 1,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 110.204336, lat = -7.607994)
            ),
            Itinerary(
                id = 2,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 110.204336, lat = -7.607994)
            ),
            Itinerary(
                id = 3,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 110.204336, lat = -7.607994)
            ),
            Itinerary(
                id = 4,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 110.204336, lat = -7.607994)
            ),
            Itinerary(
                id = 5,
                name = "Candi Borobudur",
                category = Category(idCategory = 1, iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png", nameCategory = "Alam"),
                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                location = "Yogyakarta",
                position = Position(long = 110.204336, lat = -7.607994)
            )
        )
    }

    private fun setItinerary(populars: List<Itinerary>) {
        _state.update {
            it.copy(recommendations = populars)
        }
    }

    private fun citiesData(): List<City> {
        return listOf(
            City(
                idCity = 1,
                imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                nameCity = "Surabaya"
            ),
            City(
                idCity = 1,
                imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                nameCity = "Surabaya"
            ),
            City(
                idCity = 1,
                imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                nameCity = "Surabaya"
            ),
            City(
                idCity = 1,
                imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                nameCity = "Surabaya"
            ),
        )
    }

    private fun setCities(cities: List<City>) {
        _state.update {
            it.copy(city = cities)
        }
    }

}
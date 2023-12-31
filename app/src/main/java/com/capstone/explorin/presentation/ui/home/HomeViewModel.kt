package com.capstone.explorin.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.FakeDataGenerator
import com.capstone.explorin.domain.model.BuddiesList
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.City
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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

            val fakeCategories = FakeDataGenerator.categoryData()
            setCategories(fakeCategories)

            isLoading(false)
        }
    }

    fun getPopular(){
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakePopular = FakeDataGenerator.itineraryData()
            setItinerary(fakePopular)

            isLoading(false)
        }
    }

    fun getBuddies() {
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakeBuddies = FakeDataGenerator.buddiesData()
            setBuddies(fakeBuddies)

            isLoading(false)
        }
    }

    fun getCities(){
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakeCity = FakeDataGenerator.citiesData()
            setCities(fakeCity)

            isLoading(false)
        }
    }

    fun getUser() {
        viewModelScope.launch {
            isLoading(true)
            isError(false)

            val fakeUser = FakeDataGenerator.userData()
            setUser(fakeUser)

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
    private fun setCategories(categories: List<Category>) {
        _state.update {
            it.copy(categories = categories)
        }
    }



    private fun setItinerary(populars: List<Itinerary>) {
        _state.update {
            it.copy(recommendations = populars)
        }
    }


    private fun setCities(cities: List<City>) {
        _state.update {
            it.copy(city = cities)
        }
    }

    private fun setBuddies(buddies: List<BuddiesList>) {
        _state.update {
            it.copy(buddies = buddies)
        }
    }

    private fun setUser(users: List<User>) {
        _state.update {
            it.copy(user = users.firstOrNull()) // Use firstOrNull() to get the first user or null if the list is empty
        }
    }
}
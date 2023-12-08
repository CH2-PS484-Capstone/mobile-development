package com.capstone.explorin.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datasource.local.entity.CategoryEntity
import com.capstone.explorin.data.datasource.local.entity.CityEntity
import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import com.capstone.explorin.domain.model.Category
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

}
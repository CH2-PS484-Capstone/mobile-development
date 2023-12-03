package com.capstone.explorin.presentation.ui.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.explorin.data.datastore.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val pref: UserPreferences
): ViewModel() {
    val isFirstTime: Flow<Boolean> = pref.isFirstTime()

    fun setFirstTime(firstTime: Boolean) {
        viewModelScope.launch {
            pref.setFirstTime(firstTime)
        }
    }
}
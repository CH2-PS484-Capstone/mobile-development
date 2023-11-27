package com.capstone.explorin.presentation.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.explorin.data.datasource.remote.response.DetailResponse
import com.capstone.explorin.domain.repository.UserRepository

class RegisterViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _registerResult = MutableLiveData<DetailResponse>()
    val registerResult: LiveData<DetailResponse>
        get() = _registerResult


}
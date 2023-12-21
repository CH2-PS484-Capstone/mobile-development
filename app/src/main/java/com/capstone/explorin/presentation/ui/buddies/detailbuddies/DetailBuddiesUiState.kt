package com.capstone.explorin.presentation.ui.buddies.detailbuddies

import com.capstone.explorin.domain.model.BuddiesList

data class DetailBuddiesUiState (
    val isLoading : Boolean = false,
    val isError : Boolean  = false,
    val detail: BuddiesList? = null
)
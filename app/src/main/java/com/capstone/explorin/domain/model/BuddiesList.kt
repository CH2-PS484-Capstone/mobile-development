package com.capstone.explorin.domain.model

data class BuddiesList (
    val id: Int,
    val itinerary: Itinerary,
    val buddiesDescription: String,
    val people: List<User> = emptyList()
)
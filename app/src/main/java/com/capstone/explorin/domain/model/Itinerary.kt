package com.capstone.explorin.domain.model

import com.capstone.explorin.data.datasource.remote.model.Gallery


data class Itinerary(
    val id: Int,
    val name: String,
    val category: Category,
    val image: String,
    val description: String,
    val location: String,
    val position: Position,
)

data class Position(
    val long: Double? = null,
    val lat: Double? = null,
)
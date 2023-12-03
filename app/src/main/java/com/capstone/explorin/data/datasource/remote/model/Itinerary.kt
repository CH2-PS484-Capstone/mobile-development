package com.capstone.explorin.data.datasource.remote.model


data class Itinerary(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val location: String,
    val position: Position,
    val galleries: Gallery
)

data class Position(
    val long: Double? = null,
    val lat: Double? = null,
)
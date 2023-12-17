package com.capstone.explorin.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Itinerary(
    val id: Int,
    val name: String,
    val rating: Double? = null,
    val category: Category,
    val image: String,
    val description: String,
    val gallery: List<Gallery>? = null,
    val location: String,
    val position: Position,
) : Parcelable

@Parcelize

data class Position(
    val long: Double? = null,
    val lat: Double? = null,
) : Parcelable
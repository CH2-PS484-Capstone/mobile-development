package com.capstone.explorin.data.response

import com.google.gson.annotations.SerializedName

data class ItineraryResponse (
    @field:SerializedName("data")
    val data: List<Itinerary?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)
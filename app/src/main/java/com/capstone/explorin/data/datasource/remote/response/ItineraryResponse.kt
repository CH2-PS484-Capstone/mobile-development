package com.capstone.explorin.data.datasource.remote.response

import com.google.gson.annotations.SerializedName

data class ItineraryResponse(

	@field:SerializedName("ItineraryResponse")
	val itineraryResponse: List<ItineraryResponseItem?>? = null
)

data class ItineraryResponseItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("position")
	val position: List<PositionItem?>? = null
)

data class PositionItem(

	@field:SerializedName("itineraryId")
	val itineraryId: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null,

	@field:SerializedName("long")
	val long: String? = null
)

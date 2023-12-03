package com.capstone.explorin.data.response

import com.google.gson.annotations.SerializedName


data class Itinerary(

	@field:SerializedName("desc_attraction")
	val descItinerary: String? = null,

	@field:SerializedName("photo_attraction")
	val photoItinerary: Any? = null,

	@field:SerializedName("city")
	val city: City? = null,

	@field:SerializedName("attraction_category")
	val category: Category? = null,

	@field:SerializedName("price_attraction")
	val priceItinerary: String? = null,

	@field:SerializedName("close_hour")
	val closeHour: String? = null,

	@field:SerializedName("id_city")
	val idCity: Int? = null,

	@field:SerializedName("name_attraction")
	val nameItinerary: String? = null,

	@field:SerializedName("rating_avg_attraction")
	val ratingAvgItinerary: Any? = null,

	@field:SerializedName("id_attraction_cat")
	val idItineraryCat: Int? = null,

	@field:SerializedName("open_hour")
	val openHour: String? = null,

	@field:SerializedName("id_attraction")
	val idItinerary: Int? = null,

	@field:SerializedName("coordinate_attraction")
	val coordinateItinerary: String? = null
)


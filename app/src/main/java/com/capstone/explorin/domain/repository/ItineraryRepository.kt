package com.capstone.explorin.domain.repository

import com.capstone.explorin.data.datasource.local.entity.CategoryWithItinerary
import com.capstone.explorin.data.datasource.local.entity.CityWithItinerary
import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import com.capstone.explorin.domain.model.Itinerary
import kotlinx.coroutines.flow.Flow

interface ItineraryRepository {
    fun getAllItineraries(): Flow<List<ItineraryWithCityAndCategory>>
    suspend fun getItineraryById(itineraryId: Int): ItineraryWithCityAndCategory?
    suspend fun getCategoriesWithItineraries(): Flow<List<CategoryWithItinerary>?>
    suspend fun getCitiesWithItineraries(): Flow<List<CityWithItinerary>?>

//    suspend fun getItinerary(id: Int): Flow<Result<Itinerary>>

}
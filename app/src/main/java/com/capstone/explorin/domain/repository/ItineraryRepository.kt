package com.capstone.explorin.domain.repository

import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import kotlinx.coroutines.flow.Flow

interface ItineraryRepository {
    fun getAllItineraries(): Flow<List<ItineraryWithCityAndCategory>>
    fun getItineraryById(itineraryId: Int): ItineraryWithCityAndCategory

}
package com.capstone.explorin.data.repository

import com.capstone.explorin.data.datasource.local.entity.CategoryWithItinerary
import com.capstone.explorin.data.datasource.local.entity.CityWithItinerary
import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import com.capstone.explorin.data.datasource.local.room.ItineraryDao
import com.capstone.explorin.domain.repository.ItineraryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItineraryRepositoryImpl @Inject constructor(
    private val itineraryDao: ItineraryDao
) : ItineraryRepository {
    override fun getAllItineraries(): Flow<List<ItineraryWithCityAndCategory>> {
        return itineraryDao.getAllItineraries()
    }

    override suspend fun getItineraryById(itineraryId: Int): ItineraryWithCityAndCategory? {
        return itineraryDao.getItineraryById(itineraryId)
    }

    override suspend fun getCategoriesWithItineraries(): Flow<List<CategoryWithItinerary>?> {
        return itineraryDao.getCategoriesWithItineraries()
    }

    override suspend fun getCitiesWithItineraries(): Flow<List<CityWithItinerary>?> {
        return itineraryDao.getCitiesWithItineraries()
    }
}
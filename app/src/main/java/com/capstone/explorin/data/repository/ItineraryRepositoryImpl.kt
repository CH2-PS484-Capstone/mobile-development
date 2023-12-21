package com.capstone.explorin.data.repository

import com.capstone.explorin.BuildConfig
import com.capstone.explorin.data.datasource.local.entity.CategoryWithItinerary
import com.capstone.explorin.data.datasource.local.entity.CityWithItinerary
import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import com.capstone.explorin.data.datasource.local.room.ItineraryDao
import com.capstone.explorin.data.datasource.remote.ApiService
import com.capstone.explorin.data.datastore.UserPreferences
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.domain.repository.ItineraryRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ItineraryRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val itineraryDao: ItineraryDao,
    private val userPreferences: UserPreferences,
    private val assetManager: AssetManager
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

//    override suspend fun getItinerary(id: Int): Flow<Result<Itinerary>> = flow {
//        try {
//            val response: ItineraryResponse = if (BuildConfig.IS_SERVICE_UP) {
//                var token = "Bearer "
//
//                runBlocking {
//                    token += userPreferences.getAccessToken().first()
//                }
//
//                api.getItineraryById(id)
//            } else {
//                val gson = Gson()
//                val stringJson = assetManager.getStringJson(R.raw.event_detail)
//
//                delay(2500L)
//                gson.fromJson(stringJson, ItineraryResponse::class.java)
//            }
//
//            emit(Result.success(response))
//        } catch (e: Exception) {
//            e.printStackTrace()
//            emit(Result.failure(e))
//        }
//    }.flowOn(Dispatchers.IO)
}
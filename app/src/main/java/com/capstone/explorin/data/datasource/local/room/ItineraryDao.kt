package com.capstone.explorin.data.datasource.local.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ItineraryDao {
    @Transaction
    @Query("SELECT * FROM itinerary")
    fun getAllItineraries(): Flow<List<ItineraryWithCityAndCategory>>

    @Transaction
    @Query("SELECT * FROM itinerary WHERE itineraryId = :itineraryId")
    fun getItineraryById(itineraryId: Int): ItineraryWithCityAndCategory
}
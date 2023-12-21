package com.capstone.explorin.data.datasource.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.capstone.explorin.data.datasource.local.entity.CategoryWithItinerary
import com.capstone.explorin.data.datasource.local.entity.CityWithItinerary
import com.capstone.explorin.data.datasource.local.entity.ItineraryWithCityAndCategory
import com.capstone.explorin.data.datasource.local.entity.UserEntity
import com.capstone.explorin.data.datasource.local.entity.UserWithCity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItineraryDao {
    @Transaction
    @Query("SELECT * FROM itinerary")
    fun getAllItineraries(): Flow<List<ItineraryWithCityAndCategory>>

    @Transaction
    @Query("SELECT * FROM itinerary WHERE itineraryId = :itineraryId")
    fun getItineraryById(itineraryId: Int): ItineraryWithCityAndCategory

    @Transaction
    @Query("SELECT * FROM category")
    fun getCategoriesWithItineraries(): Flow<List<CategoryWithItinerary>?>

    @Transaction
    @Query("SELECT * FROM city")
    fun getCitiesWithItineraries(): Flow<List<CityWithItinerary>>

    @Transaction
    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserById(id: Int): Flow<UserWithCity>

    @Query("SELECT * FROM user WHERE email = :email")
    fun getUserEmail(email: String): Flow<UserEntity?>

    @Update
    fun updateUser(userEntity: UserEntity)
}
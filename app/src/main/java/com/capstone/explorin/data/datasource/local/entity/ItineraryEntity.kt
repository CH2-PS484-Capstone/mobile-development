package com.capstone.explorin.data.datasource.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "itinerary")
data class ItineraryEntity(
    @PrimaryKey
    val itineraryId: Int,
    val name: String,
    val categoryId: Int,
    val description: String,
    val image: String,
    val cityId: Int,
    val lat: Double,
    val long: Double,
    val rating: Double,
)

@Entity(tableName = "city")
data class CityEntity(
    @PrimaryKey
    val cityId: Int,
    val cityName: String,
)

@Entity(tableName = "category")
data class CategoryEntity (
    @PrimaryKey
    val categoryId: Int,
    val categoryName: String,
)

data class ItineraryWithCityAndCategory(
    @Embedded val itinerary: ItineraryEntity,
    @Relation(
        parentColumn = "cityId",
        entityColumn = "cityId"
    )
    val city: CityEntity,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    val category: CategoryEntity
)

data class CategoryWithItinerary(
    @Embedded val category: CategoryEntity,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    val itineraries: List<ItineraryEntity>
)

data class CityWithItinerary(
    @Embedded val city: CityEntity,
    @Relation(
        parentColumn = "cityId",
        entityColumn = "cityId"
    )
    val itineraries: List<ItineraryEntity>
)

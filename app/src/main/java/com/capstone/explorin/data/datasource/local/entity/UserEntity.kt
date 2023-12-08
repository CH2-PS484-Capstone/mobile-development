package com.capstone.explorin.data.datasource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "full_name")
    var fullName: String? = null,

    @ColumnInfo(name = "email")
    var email: String? = null,

    @ColumnInfo(name = "username")
    var username:String? = null,

    @ColumnInfo(name = "phone_number")
    var phoneNumber: String? = null,

    @ColumnInfo(name = "city_id")
    var cityId: Int = 0,

    @ColumnInfo(name = "dob")
    val dateOfBirth: String,

    @ColumnInfo(name = "gender")
    val gender: String
)

data class UserWithCity(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "city_id",
        entityColumn = "cityId"
    )
    val city: CityEntity,
)
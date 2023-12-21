package com.capstone.explorin.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class User(
    var id: Int,
    var fullName: String? = null,
    var email: String? = null,
    var username:String? = null,
    var phoneNumber: String? = null,
    var city: City,
    val dateOfBirth: String,
    val gender: String,
    val imgProfile: String,
)

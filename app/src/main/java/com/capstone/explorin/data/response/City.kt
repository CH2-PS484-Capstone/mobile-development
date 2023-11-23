package com.capstone.explorin.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(

    @field:SerializedName("id_province")
    val idProvince: Int? = null,

    @field:SerializedName("id_city")
    val idCity: Int? = null,

    @field:SerializedName("name_city")
    val nameCity: String? = null
) : Parcelable
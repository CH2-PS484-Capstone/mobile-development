package com.capstone.explorin.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(

    @field:SerializedName("id_attraction_cat")
    val idAttractionCat: Int? = null,

    @field:SerializedName("name_attraction_cat")
    val nameAttractionCat: String? = null
) : Parcelable
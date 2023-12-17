package com.capstone.explorin.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Category(
    val idCategory: Int,
    val iconCategory: String,
    val nameCategory: String,
) : Parcelable
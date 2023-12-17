package com.capstone.explorin.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gallery(
    val id: Int? = null,
//    val name: String? = null,
    val image: String? = null,
) : Parcelable

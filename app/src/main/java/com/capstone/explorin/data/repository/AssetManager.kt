package com.capstone.explorin.data.repository

import android.content.Context
import com.capstone.explorin.presentation.utils.getJsonAsString
import javax.inject.Inject

class AssetManager @Inject constructor(
    private val context: Context
) {
    fun getStringJson(resId: Int): String {
        return getJsonAsString(context, resId)
    }
}
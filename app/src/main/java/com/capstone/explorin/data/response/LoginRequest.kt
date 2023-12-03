package com.capstone.explorin.data.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class LoginRequest(

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

) : Parcelable

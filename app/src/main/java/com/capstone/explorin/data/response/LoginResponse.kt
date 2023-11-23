package com.capstone.explorin.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,


)

data class Data(
	@field:SerializedName("accessToken")
	val accessToken: String? = null
)

package com.capstone.explorin.domain.repository

interface RegisterRepository {

    suspend fun validateInput(
        fullname: String,
        email: String,
        password: String,
    ): Boolean

    suspend fun register(
        fullname: String,
        email: String,
        password: String,
    )
}
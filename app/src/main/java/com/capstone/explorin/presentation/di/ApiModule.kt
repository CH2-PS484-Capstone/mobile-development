package com.capstone.explorin.presentation.di

import com.capstone.explorin.data.datasource.remote.ApiConfig
import com.capstone.explorin.data.datasource.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideAPI(): ApiService = ApiConfig.getApiService()
}
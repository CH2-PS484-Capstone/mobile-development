package com.capstone.explorin.presentation.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.capstone.explorin.data.datasource.local.room.AppDb
import com.capstone.explorin.data.datasource.local.room.ItineraryDao
import com.capstone.explorin.data.datasource.remote.ApiService
import com.capstone.explorin.data.datastore.UserPreferences
import com.capstone.explorin.data.repository.AssetManager
import com.capstone.explorin.data.repository.ItineraryRepositoryImpl
import com.capstone.explorin.data.repository.UserRepositoryImpl
import com.capstone.explorin.domain.repository.ItineraryRepository
import com.capstone.explorin.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "explorin")

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = context.dataStore

    @Provides
    @Singleton
    fun provideUserPreferences(
        dataStore: DataStore<Preferences>
    ): UserPreferences = UserPreferences(dataStore)

    @Provides
    @Singleton
    fun provideUserRepository(
        apiService: ApiService,
        pref: UserPreferences,
        assetManager: AssetManager
    ): UserRepository {
        return UserRepositoryImpl(apiService, pref, assetManager)
    }

    @Provides
    @Singleton
    fun provideItineraryRepository(
        apiService: ApiService,
        itineraryDao: ItineraryDao,
        pref: UserPreferences,
        assetManager: AssetManager
    ): ItineraryRepository {
        return ItineraryRepositoryImpl(apiService, itineraryDao, pref, assetManager)
    }

    @Provides
    fun provideContext(
        @ApplicationContext
        context: Context
    ): Context = context

    @Provides
    fun provideItineraryDao(appDb:AppDb): ItineraryDao {
        return appDb.itineraryDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDb {
        return Room.databaseBuilder(
            appContext,
            AppDb::class.java,
            "explorin_db"
        ).build()
    }
}
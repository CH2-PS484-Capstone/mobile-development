package com.capstone.explorin.data.datasource.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.capstone.explorin.data.datasource.local.entity.CategoryEntity
import com.capstone.explorin.data.datasource.local.entity.CityEntity
import com.capstone.explorin.data.datasource.local.entity.ItineraryEntity
import com.capstone.explorin.data.datasource.local.entity.UserEntity


@Database(
    entities = [ItineraryEntity::class, CityEntity::class, CategoryEntity::class, UserEntity::class],
    version = 1
)
abstract class AppDb: RoomDatabase() {
    abstract fun itineraryDao(): ItineraryDao

//    companion object {
//        @Volatile
//        private var INSTANCE: AppDb? = null
//
//        @JvmStatic
//        fun getDatabase(context: Context): AppDb {
//            if (INSTANCE == null) {
//                synchronized(AppDb::class) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        AppDb::class.java,
//                        "explorin_db"
//                    ).build()
//                }
//            }
//            return INSTANCE as AppDb
//        }
//    }

}
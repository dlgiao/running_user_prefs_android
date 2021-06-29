package com.kmmania.runninguserpreferences.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MeasuringSystem::class], version = 1, exportSchema = false)
abstract class MeasuringSystemDatabase: RoomDatabase() {

    abstract  fun measuringSystemDao(): MeasuringSystemDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MeasuringSystemDatabase? = null

        fun getDatabase(context: Context): MeasuringSystemDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MeasuringSystemDatabase::class.java,
                    "measuring_system_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
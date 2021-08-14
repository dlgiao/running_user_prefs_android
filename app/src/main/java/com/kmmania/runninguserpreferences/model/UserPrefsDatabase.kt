package com.kmmania.runninguserpreferences.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserPrefs::class], version = 1, exportSchema = false)
abstract class UserPrefsDatabase: RoomDatabase() {
    abstract fun userPrefsDao(): UserPrefsDao
}
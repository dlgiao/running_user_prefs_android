package com.kmmania.runninguserpreferences.user_prefs

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserPrefs::class], version = 1, exportSchema = false)
abstract class UserPrefsDatabase: RoomDatabase() {
    abstract fun userPrefsDao(): UserPrefsDao
}
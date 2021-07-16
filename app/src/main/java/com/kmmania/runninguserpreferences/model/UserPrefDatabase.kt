package com.kmmania.runninguserpreferences.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [UserPref::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class UserPrefDatabase: RoomDatabase() {
    abstract fun userPrefDao(): UserPrefDao
}
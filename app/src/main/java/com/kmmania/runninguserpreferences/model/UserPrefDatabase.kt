package com.kmmania.runninguserpreferences.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserPref::class], version = 1, exportSchema = false)
abstract class UserPrefDatabase: RoomDatabase() {

    abstract fun userPrefDao(): UserPrefDao
}
package com.kmmania.runninguserpreferences.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Dob::class], version = 1, exportSchema = false)
abstract class DobDatabase: RoomDatabase() {
    abstract fun dobDao(): DobDao
}
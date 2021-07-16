package com.kmmania.runninguserpreferences.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Dob::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DobDatabase: RoomDatabase() {
    abstract fun dobDao(): DobDao
}
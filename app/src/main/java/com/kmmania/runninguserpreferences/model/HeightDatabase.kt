package com.kmmania.runninguserpreferences.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Height::class], version = 1, exportSchema = false)
abstract class HeightDatabase: RoomDatabase() {
    abstract fun heightDao(): HeightDao
}
package com.kmmania.runninguserpreferences.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Mas::class], version = 1, exportSchema = false)
abstract class MasDatabase: RoomDatabase() {
    abstract fun masDao(): MasDao
}
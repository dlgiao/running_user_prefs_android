package com.kmmania.runninguserpreferences.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Gender::class], version = 1, exportSchema = false)
abstract class GenderDatabase: RoomDatabase() {
}
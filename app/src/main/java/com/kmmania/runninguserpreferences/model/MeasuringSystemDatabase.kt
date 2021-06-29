package com.kmmania.runninguserpreferences.model

import androidx.room.Database

@Database(entities = [MeasuringSystem::class], version = 1, exportSchema = false)
abstract class MeasuringSystemDatabase {
}
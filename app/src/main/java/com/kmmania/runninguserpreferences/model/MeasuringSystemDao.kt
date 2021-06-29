package com.kmmania.runninguserpreferences.model

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface MeasuringSystemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(measuringSystem: MeasuringSystem)
}
package com.kmmania.runninguserpreferences.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface MeasuringSystemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(measuringSystem: MeasuringSystem)

    @Delete
    suspend fun delete(measuringSystem: MeasuringSystem)

    @Query("DELETE FROM measuring_system_table")
    suspend fun deleteAll()
}
package com.kmmania.runninguserpreferences.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface MeasuringSystemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(measuringSystem: MeasuringSystem)

    @Delete
    suspend fun delete(measuringSystem: MeasuringSystem)

    @Query("DELETE FROM measuring_system_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM measuring_system_table ORDER BY created_at ASC")
    fun getAllMeasuringSystem(): Flow<List<MeasuringSystem>>

    @Query("SELECT * FROM measuring_system_table WHERE id = (SELECT max(ID) FROM measuring_system_table)")
    fun getLastMeasuringSystem(): Flow<MeasuringSystem>
}
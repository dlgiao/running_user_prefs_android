package com.kmmania.runninguserpreferences.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MeasuringSystemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(measuringSystem: MeasuringSystem)

    @Query("DELETE FROM measuring_system_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM measuring_system_table")
    fun getMeasuringSystem(): Flow<MeasuringSystem>
}
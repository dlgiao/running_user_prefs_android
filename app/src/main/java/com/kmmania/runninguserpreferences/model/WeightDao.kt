package com.kmmania.runninguserpreferences.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeightDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weight: Weight)

    @Query("DELETE FROM weight_table")
    suspend fun deleteAll()

    @Query("SELECT* FROM weight_table")
    fun getWeight(): Flow<Weight>
}
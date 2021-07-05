package com.kmmania.runninguserpreferences.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HeightDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(height: Height)

    @Query("DELETE FROM height_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM height_table")
    fun getHeight(): Flow<Height>
}
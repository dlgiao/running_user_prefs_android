package com.kmmania.runninguserpreferences.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mas: Mas)

    @Query("DELETE FROM mas_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM mas_table")
    fun getMas(): Flow<Mas>
}
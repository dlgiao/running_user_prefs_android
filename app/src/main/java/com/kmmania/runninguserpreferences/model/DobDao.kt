package com.kmmania.runninguserpreferences.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface DobDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dob: Date)

    @Query("DELETE FROM dob_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM dob_table")
    fun getDob(): Flow<Dob>
}
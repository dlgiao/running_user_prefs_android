package com.kmmania.runninguserpreferences.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GenderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(gender: Gender)

    @Query("DELETE FROM gender_table")
    suspend fun deleteAll()
}
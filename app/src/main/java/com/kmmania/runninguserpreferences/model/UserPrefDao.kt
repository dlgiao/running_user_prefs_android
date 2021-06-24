package com.kmmania.runninguserpreferences.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface UserPrefDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userPref: UserPref)
}
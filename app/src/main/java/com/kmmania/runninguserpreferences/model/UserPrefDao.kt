package com.kmmania.runninguserpreferences.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserPrefDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userPref: UserPref)

    @Query("DELETE FROM user_pref_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM user_pref_table ORDER BY id ASC")
    fun getAllUserPref(): Flow<List<UserPref>>
}
package com.kmmania.runninguserpreferences.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserPrefsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userPrefs: UserPrefs)

    @Query("DELETE FROM user_prefs_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM user_prefs_table")
    fun getUserPrefs(): Flow<UserPrefs>
}
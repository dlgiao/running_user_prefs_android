package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.UserPrefs
import com.kmmania.runninguserpreferences.model.UserPrefsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPrefsRepository @Inject constructor(private val userPrefsDao: UserPrefsDao) {
    val userPrefsValue: Flow<UserPrefs> = userPrefsDao.getUserPrefs()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(userPrefs: UserPrefs) {
        userPrefsDao.deleteAll()
        userPrefsDao.insert(userPrefs)
    }
}
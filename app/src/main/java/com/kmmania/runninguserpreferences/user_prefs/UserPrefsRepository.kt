package com.kmmania.runninguserpreferences.user_prefs

import androidx.annotation.WorkerThread
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
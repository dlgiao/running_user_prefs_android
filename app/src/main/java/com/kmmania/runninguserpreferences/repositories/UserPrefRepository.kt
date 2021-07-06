package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.UserPref
import com.kmmania.runninguserpreferences.model.UserPrefDao
import kotlinx.coroutines.flow.Flow

class UserPrefRepository(private val userPrefDao: UserPrefDao) {

    val userPrefValue: Flow<UserPref> = userPrefDao.getUserPref()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(userPref: UserPref) {
        userPrefDao.deleteAll()
        userPrefDao.insert(userPref)
    }
}
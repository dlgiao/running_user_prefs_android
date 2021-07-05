package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.Height
import com.kmmania.runninguserpreferences.model.HeightDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeightRepository @Inject constructor(private val heightDao: HeightDao) {
    val heightValue: Flow<Height> = heightDao.getHeight()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(height: Height) {
        heightDao.deleteAll()
        heightDao.insert(height)
    }
}
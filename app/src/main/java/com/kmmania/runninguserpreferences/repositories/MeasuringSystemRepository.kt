package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.model.MeasuringSystemDao
import kotlinx.coroutines.flow.Flow

class MeasuringSystemRepository(private val measuringSystemDao: MeasuringSystemDao) {

    val lastMeasuringSystem: Flow<MeasuringSystem> = measuringSystemDao.getLastMeasuringSystem()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(measuringSystem: MeasuringSystem) {
        measuringSystemDao.insert(measuringSystem)
    }
}
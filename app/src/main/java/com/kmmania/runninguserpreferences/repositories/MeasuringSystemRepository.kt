package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.model.MeasuringSystemDao
import kotlinx.coroutines.flow.Flow

class MeasuringSystemRepository(private val msDao: MeasuringSystemDao) {

    val lastMeasuringSystem: Flow<MeasuringSystem> = msDao.getMeasuringSystem()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(measuringSystem: MeasuringSystem) {
        msDao.insert(measuringSystem)
    }
}
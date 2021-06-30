package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.model.MeasuringSystemDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
class MeasuringSystemRepository(private val msDao: MeasuringSystemDao) {

    val msValue: Flow<MeasuringSystem> = msDao.getMeasuringSystem()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(measuringSystem: MeasuringSystem) {
        msDao.deleteAll()
        msDao.insert(measuringSystem)
    }
}
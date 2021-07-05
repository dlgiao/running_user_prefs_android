package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.Weight
import com.kmmania.runninguserpreferences.model.WeightDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeightRepository @Inject constructor(private val weightDao: WeightDao) {
    val weightValue: Flow<Weight> = weightDao.getWeight()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(weight: Weight) {
        weightDao.deleteAll()
        weightDao.insert(weight)
    }
}
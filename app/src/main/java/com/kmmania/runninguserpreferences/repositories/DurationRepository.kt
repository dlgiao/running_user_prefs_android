package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DurationRepository @Inject constructor(private val durationDao: DurationDao) {

    val duration: Flow<Duration> = durationDao.getDuration()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDurationFromDistanceSpeed(distance: Length, speed: Speed) {
        //durationDao.getDurationFromDistanceSpeed(distance, speed)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDurationFromDistancePace(distance: Length, pace: Pace) {
        //durationDao.getDurationFromDistancePace(distance, pace)
    }
}
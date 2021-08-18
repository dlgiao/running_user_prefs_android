package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class DurationRepository(private val durationDao: DurationDao) {
    val duration: Flow<Duration> = durationDao.getDuration()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDurationFromDistanceSpeed(distance: Length, speed: Speed): Duration {
        val distanceValue = distance.lengthValue
        val speedValue = speed.speedValue
        val timeInSec = distanceValue?.div(speedValue!!)?.times(3600)

        return Duration(
            timeInSec?.div(3600)?.toInt(),
            timeInSec?.rem(3600)?.div(60)?.toInt(),
            timeInSec?.rem(3600)?.rem(60)?.toInt()!!,
            timeInSec.minus(timeInSec.toInt()).times(1000).toInt()
        )
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getDurationFromDistancePace(distance: Length, pace: Pace): Duration {
        val distanceValue = distance.lengthValue
        val paceMnValue = pace.paceMin
        val paceScValue = pace.paceSec
        val paceInSec = paceMnValue?.times(60)?.plus(paceScValue!!)
        val timeInSec = paceInSec?.times(distanceValue!!)

        return Duration(
            timeInSec?.div(3600)?.toInt(),
            timeInSec?.rem(3600)?.div(60)?.toInt(),
            timeInSec?.rem(3600)?.rem(60)?.toInt()!!,
            timeInSec.minus(timeInSec.toInt()).times(1000).toInt()
        )
    }
}
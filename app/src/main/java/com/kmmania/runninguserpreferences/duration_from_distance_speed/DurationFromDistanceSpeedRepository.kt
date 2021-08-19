package com.kmmania.runninguserpreferences.duration_from_distance_speed

import com.kmmania.runninguserpreferences.model.*
import com.kmmania.runninguserpreferences.ui.duration.DurationRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DurationFromDistanceSpeedRepository @Inject constructor(
    private val durationRepository: DurationRepository
): DurationFromDistanceSpeedDao {
    override fun getDuration(distance: Length?, speed: Speed?): Duration {
        val distanceValue = distance?.lengthValue
        //val distanceUnit = distance?.lengthUnit
        val speedValue = speed?.speedValue
        //val speedUnit = speed?.speedUnit
        val timeInSec = distanceValue?.div(speedValue!!)?.times(3600)

        return durationRepository.getDuration(
            timeInSec?.div(3600)?.toInt(),
            timeInSec?.rem(3600)?.div(60)?.toInt(),
            timeInSec?.rem(3600)?.rem(60)?.toInt()!!,
            timeInSec.minus(timeInSec.toInt()).times(1000).toInt()
        )
    }

}
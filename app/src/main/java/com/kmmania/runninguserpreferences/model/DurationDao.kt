package com.kmmania.runninguserpreferences.model

interface DurationDao {
    fun getDurationFromDistanceMas(distance: Length): Length?
    fun getDurationFromDistanceSpeed(distance: Length, speed: Speed): Length?
    fun getDurationFromDistancePace(distance: Length, pace: Pace): Length?
}
package com.kmmania.runninguserpreferences.model

import kotlinx.coroutines.flow.Flow

interface DurationDao {
    fun getDuration(): Flow<Duration>
//    fun getDurationFromDistanceMas(distance: Length): Flow<Length>
//    fun getDurationFromDistanceSpeed(distance: Length, speed: Speed): Flow<Length>
//    fun getDurationFromDistancePace(distance: Length, pace: Pace): Flow<Length>
}
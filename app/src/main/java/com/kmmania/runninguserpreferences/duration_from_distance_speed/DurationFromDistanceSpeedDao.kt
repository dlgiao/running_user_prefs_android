package com.kmmania.runninguserpreferences.duration_from_distance_speed

import com.kmmania.runninguserpreferences.duration.Duration
import com.kmmania.runninguserpreferences.length.Length
import com.kmmania.runninguserpreferences.speed.Speed

interface DurationFromDistanceSpeedDao {
    fun getDuration(distance: Length?, speed: Speed?): Duration?
}
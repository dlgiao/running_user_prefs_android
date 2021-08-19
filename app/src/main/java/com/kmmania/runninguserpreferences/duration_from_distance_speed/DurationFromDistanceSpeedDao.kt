package com.kmmania.runninguserpreferences.duration_from_distance_speed

import com.kmmania.runninguserpreferences.model.Duration
import com.kmmania.runninguserpreferences.model.Length
import com.kmmania.runninguserpreferences.model.Speed

interface DurationFromDistanceSpeedDao {
    fun getDuration(distance: Length?, speed: Speed?): Duration?
}
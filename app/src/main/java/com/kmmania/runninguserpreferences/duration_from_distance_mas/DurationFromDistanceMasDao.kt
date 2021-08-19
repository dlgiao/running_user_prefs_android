package com.kmmania.runninguserpreferences.duration_from_distance_mas

import com.kmmania.runninguserpreferences.model.Duration
import com.kmmania.runninguserpreferences.model.Length
import com.kmmania.runninguserpreferences.model.Speed

interface DurationFromDistanceMasDao {
    fun getDuration(distance: Length?, speed: Speed?): Duration?
}
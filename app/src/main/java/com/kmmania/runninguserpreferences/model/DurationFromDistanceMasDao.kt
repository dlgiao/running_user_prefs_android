package com.kmmania.runninguserpreferences.model

interface DurationFromDistanceMasDao {
    fun getDuration(distance: Length?, speed: Speed?): Duration?
}
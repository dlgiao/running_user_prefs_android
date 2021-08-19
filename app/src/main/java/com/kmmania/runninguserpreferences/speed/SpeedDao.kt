package com.kmmania.runninguserpreferences.speed

import com.kmmania.runninguserpreferences.utils.units.SpeedUnit

interface SpeedDao {
    fun getSpeed(speedValue: Double?, speedUnit: SpeedUnit?): Speed?
}
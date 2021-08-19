package com.kmmania.runninguserpreferences.speed

import com.kmmania.runninguserpreferences.utils.units.SpeedUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpeedRepository @Inject constructor(): SpeedDao {
    override fun getSpeed(speedValue: Double?, speedUnit: SpeedUnit?): Speed =
        Speed(speedValue, speedUnit)
}
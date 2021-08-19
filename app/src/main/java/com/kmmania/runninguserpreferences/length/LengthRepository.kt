package com.kmmania.runninguserpreferences.length

import com.kmmania.runninguserpreferences.utils.units.LengthUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LengthRepository @Inject constructor(): LengthDao {
    override fun getLength(lengthValue: Double?, lengthUnit: LengthUnit?): Length {
        return Length(lengthValue, lengthUnit)
    }
}
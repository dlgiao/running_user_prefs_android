package com.kmmania.runninguserpreferences.length

import com.kmmania.runninguserpreferences.utils.units.LengthUnit

interface LengthDao {
    fun getLength(lengthValue: Double?, lengthUnit: LengthUnit?): Length?
}
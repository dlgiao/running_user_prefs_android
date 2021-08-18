package com.kmmania.runninguserpreferences.model

import com.kmmania.runninguserpreferences.model.units.LengthUnit
import com.kmmania.runninguserpreferences.model.units.MeasuringSystemUnit

data class Length(
    val lengthValue: Double?,
    val lengthUnit: LengthUnit?,
    val lengthMS: MeasuringSystemUnit?
)

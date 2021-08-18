package com.kmmania.runninguserpreferences.model

import com.kmmania.runninguserpreferences.model.units.MeasuringSystemUnit
import com.kmmania.runninguserpreferences.model.units.SpeedUnit

data class Speed(
    val speedValue: Double?,
    val speedUnit: SpeedUnit?,
    val speedMS: MeasuringSystemUnit?
)

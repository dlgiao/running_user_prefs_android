package com.kmmania.runninguserpreferences.model

import com.kmmania.runninguserpreferences.utils.units.PaceUnit

data class Pace(
    val paceMin: Int?,
    val paceSec: Int?,
    val paceUnit: PaceUnit?
)

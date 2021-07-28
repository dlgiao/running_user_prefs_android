package com.kmmania.runninguserpreferences.repositories

import com.kmmania.runninguserpreferences.model.DaoInterface
import com.kmmania.runninguserpreferences.model.Distance
import com.kmmania.runninguserpreferences.model.units.LengthUnit
import com.kmmania.runninguserpreferences.model.units.MeasuringSystemUnit

class DistanceRepository {
    private val distanceValue = 13.6
    private val distanceUnit: LengthUnit = LengthUnit.KM
    private val distanceMs: MeasuringSystemUnit = MeasuringSystemUnit.METRIC
    private val distance: DaoInterface = Distance(distanceValue, distanceUnit, distanceMs)

    val distanceVal: MutableMap<String, Any> = distance.getData()
}
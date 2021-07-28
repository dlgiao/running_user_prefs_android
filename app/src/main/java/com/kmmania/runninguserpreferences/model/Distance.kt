package com.kmmania.runninguserpreferences.model

import com.kmmania.runninguserpreferences.model.units.LengthUnit
import com.kmmania.runninguserpreferences.model.units.MeasuringSystemUnit
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.MAX_DISTANCE1
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.MAX_DISTANCE2
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.MIN_DISTANCE
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.M_KM
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.YD_MI

class Distance(
    private var distanceValue: Double?,
    private var distanceUnit: LengthUnit,
    private var distanceMs: MeasuringSystemUnit
): DaoInterface {
    override fun getData(): MutableMap<String, Any> {
        distanceValue = when(distanceMs) {
            MeasuringSystemUnit.METRIC -> when(distanceUnit) {
                LengthUnit.M -> {
                    if (distanceValue!! in MIN_DISTANCE..MAX_DISTANCE1) {
                        distanceValue?.times(M_KM)
                    } else {
                        throw RuntimeException("Distance error M")
                    }
                }
                LengthUnit.KM -> {
                    if (distanceValue!! in MIN_DISTANCE..MAX_DISTANCE2) {
                        distanceValue
                    } else {
                        throw RuntimeException("Distance error KM")
                    }
                }
                else -> throw RuntimeException("Distance error metric")
            }
            MeasuringSystemUnit.IMPERIAL -> when(distanceUnit) {
                LengthUnit.YD -> {
                    if (distanceValue!! in MIN_DISTANCE..MAX_DISTANCE1) {
                        distanceValue?.times(YD_MI)
                    } else {
                        throw RuntimeException("Distance error YD")
                    }
                }
                LengthUnit.MI -> {
                    if (distanceValue!! !in MIN_DISTANCE..MAX_DISTANCE2) {
                        throw RuntimeException("Distance error MI")
                    } else {
                        throw RuntimeException("Distance error MI")
                    }
                }
                else -> throw RuntimeException("Distance error imperial")
            }
        }

        return mutableMapOf(
            "distanceValue" to distanceValue as Any,
            "distanceUnit" to distanceUnit as Any,
            "distanceMs" to distanceMs as Any
        )
    }
}
package com.kmmania.runninguserpreferences.duration

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DurationRepository @Inject constructor(): DurationDao {
    override fun getDuration(hr: Int?, min: Int?, sec: Int?, ms: Int?): Duration =
        Duration(hr, min, sec!!, ms)
}
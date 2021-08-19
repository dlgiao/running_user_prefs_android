package com.kmmania.runninguserpreferences.ui.duration

import com.kmmania.runninguserpreferences.model.Duration
import com.kmmania.runninguserpreferences.model.DurationDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DurationRepository @Inject constructor(): DurationDao {
    override fun getDuration(hr: Int?, min: Int?, sec: Int?, ms: Int?): Duration {
        return Duration(hr, min, sec!!, ms)
    }
}
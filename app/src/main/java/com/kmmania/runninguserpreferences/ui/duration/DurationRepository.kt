package com.kmmania.runninguserpreferences.ui.duration

import com.kmmania.runninguserpreferences.model.Duration
import com.kmmania.runninguserpreferences.model.DurationDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DurationRepository @Inject constructor(
    private val hr: Int?,
    private val min: Int?,
    private val sec: Int?,
    private val ms: Int?
): DurationDao {
    override fun getDuration(): Duration {
        return Duration(hr, min, sec!!, ms)
    }
}
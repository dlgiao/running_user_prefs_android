package com.kmmania.runninguserpreferences.duration

interface DurationDao {
    fun getDuration(hr: Int?, min: Int?, sec: Int?, ms: Int?): Duration?
}
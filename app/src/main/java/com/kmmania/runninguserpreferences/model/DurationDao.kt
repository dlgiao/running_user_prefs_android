package com.kmmania.runninguserpreferences.model

interface DurationDao {
    fun getDuration(hr: Int?, min: Int?, sec: Int?, ms: Int?): Duration?
}
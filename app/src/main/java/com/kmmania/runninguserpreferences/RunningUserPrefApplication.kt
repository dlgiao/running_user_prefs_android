package com.kmmania.runninguserpreferences

import android.app.Application
import com.kmmania.runninguserpreferences.model.MeasuringSystemDatabase
import com.kmmania.runninguserpreferences.repositories.MeasuringSystemRepository

class RunningUserPrefApplication: Application() {
    private val measuringSystemDatabase by lazy {
        MeasuringSystemDatabase.getDatabase(this)
    }
    val measuringSystemRepository by lazy {
        MeasuringSystemRepository(measuringSystemDatabase.measuringSystemDao())
    }
}
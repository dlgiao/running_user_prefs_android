package com.kmmania.runninguserpreferences.application

import android.app.Application
import com.kmmania.runninguserpreferences.model.MeasuringSystemDatabase
import com.kmmania.runninguserpreferences.repositories.MeasuringSystemRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class RunningUserPrefApplication: Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val msDatabase by lazy {
        MeasuringSystemDatabase.getDatabase(this, applicationScope)
    }
    val msRepository by lazy {
        MeasuringSystemRepository(msDatabase.measuringSystemDao())
    }
}
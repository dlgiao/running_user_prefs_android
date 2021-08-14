package com.kmmania.runninguserpreferences

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RunningUserPrefApplication: Application() {
//    private val applicationScope = CoroutineScope(SupervisorJob())
//
//    private val msDatabase by lazy {
//        MeasuringSystemDatabase.getDatabase(this, applicationScope)
//    }
//    val msRepository by lazy {
//        MeasuringSystemRepository(msDatabase.measuringSystemDao())
//    }
}
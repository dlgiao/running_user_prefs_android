package com.kmmania.runninguserpreferences

import android.app.Application
import com.kmmania.runninguserpreferences.model.MeasuringSystemDatabase
import com.kmmania.runninguserpreferences.model.UserPrefDatabase
import com.kmmania.runninguserpreferences.repositories.MeasuringSystemRepository
import com.kmmania.runninguserpreferences.repositories.UserPrefRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class RunningUserPrefApplication: Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    private val msDatabase by lazy {
        MeasuringSystemDatabase.getDatabase(this, applicationScope)
    }
    val msRepository by lazy {
        MeasuringSystemRepository(msDatabase.measuringSystemDao())
    }
}
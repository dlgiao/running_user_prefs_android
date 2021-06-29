package com.kmmania.runninguserpreferences

import android.app.Application
import com.kmmania.runninguserpreferences.model.MeasuringSystemDatabase
import com.kmmania.runninguserpreferences.model.UserPrefDatabase
import com.kmmania.runninguserpreferences.repositories.MeasuringSystemRepository
import com.kmmania.runninguserpreferences.repositories.UserPrefRepository

class RunningUserPrefApplication: Application() {
    private val database by lazy { UserPrefDatabase.getDatabase(this) }
    val repository by lazy { UserPrefRepository(database.userPrefDao()) }

    private val measuringSystemDatabase by lazy {
        MeasuringSystemDatabase.getDatabase(this)
    }
    val measuringSystemRepository by lazy {
        MeasuringSystemRepository(measuringSystemDatabase.measuringSystemDao())
    }
}
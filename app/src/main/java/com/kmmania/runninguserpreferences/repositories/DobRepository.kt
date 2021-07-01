package com.kmmania.runninguserpreferences.repositories

import com.kmmania.runninguserpreferences.model.Dob
import com.kmmania.runninguserpreferences.model.DobDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DobRepository @Inject constructor(private val dobDao: DobDao) {
    val dobValue: Flow<Dob> = dobDao.getDob()
}
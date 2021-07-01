package com.kmmania.runninguserpreferences.repositories

import com.kmmania.runninguserpreferences.model.DobDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DobRepository @Inject constructor(private val dobDao: DobDao) {
}
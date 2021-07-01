package com.kmmania.runninguserpreferences.repositories

import com.kmmania.runninguserpreferences.model.GenderDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GenderRepository @Inject constructor(private val genderDao: GenderDao) {
}
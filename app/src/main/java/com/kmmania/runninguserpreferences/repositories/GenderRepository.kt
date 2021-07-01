package com.kmmania.runninguserpreferences.repositories

import com.kmmania.runninguserpreferences.model.Gender
import com.kmmania.runninguserpreferences.model.GenderDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GenderRepository @Inject constructor(private val genderDao: GenderDao) {
    val genderValue: Flow<Gender> = genderDao.getGender()
}
package com.kmmania.runninguserpreferences.repositories

import com.kmmania.runninguserpreferences.model.Length
import com.kmmania.runninguserpreferences.model.LengthDao
import kotlinx.coroutines.flow.Flow

class LengthRepository(private val lengthDao: LengthDao) {

    private val length: Flow<Length> = lengthDao.getLength()
}
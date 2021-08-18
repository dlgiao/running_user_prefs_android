package com.kmmania.runninguserpreferences.repositories

import com.kmmania.runninguserpreferences.model.Speed
import com.kmmania.runninguserpreferences.model.SpeedDao
import kotlinx.coroutines.flow.Flow

class SpeedRepository(private val speedDao: SpeedDao) {

    private val speed: Flow<Speed> = speedDao.getSpeed()
}
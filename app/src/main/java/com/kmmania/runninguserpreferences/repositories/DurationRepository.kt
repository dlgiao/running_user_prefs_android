package com.kmmania.runninguserpreferences.repositories

import com.kmmania.runninguserpreferences.model.*
import kotlinx.coroutines.flow.Flow

class DurationRepository(lengthDao: LengthDao, speedDao: SpeedDao, paceDao: PaceDao) {
    val distance: Flow<Length> = lengthDao.getLength()
    val speed: Flow<Speed> = speedDao.getSpeed()
    val pace: Flow<Pace> = paceDao.getPace()
}
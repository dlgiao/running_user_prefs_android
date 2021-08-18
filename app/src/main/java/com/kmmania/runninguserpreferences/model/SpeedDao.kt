package com.kmmania.runninguserpreferences.model

import kotlinx.coroutines.flow.Flow

interface SpeedDao {
    fun getSpeed(): Flow<Speed>
}
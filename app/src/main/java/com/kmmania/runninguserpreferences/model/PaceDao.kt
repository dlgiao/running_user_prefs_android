package com.kmmania.runninguserpreferences.model

import kotlinx.coroutines.flow.Flow

interface PaceDao {
    fun getPace(): Flow<Pace>
}
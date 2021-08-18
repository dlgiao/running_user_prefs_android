package com.kmmania.runninguserpreferences.model

import kotlinx.coroutines.flow.Flow

interface DurationDao {
    fun getDuration(): Flow<Duration>
}
package com.kmmania.runninguserpreferences.model

import kotlinx.coroutines.flow.Flow

interface LengthDao {
    fun getLength(): Flow<Length>
}
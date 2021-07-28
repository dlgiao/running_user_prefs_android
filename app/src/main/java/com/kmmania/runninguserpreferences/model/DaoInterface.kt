package com.kmmania.runninguserpreferences.model

import kotlinx.coroutines.flow.Flow

interface DaoInterface {
    fun getData(): Flow<MutableMap<String, Any>>
}
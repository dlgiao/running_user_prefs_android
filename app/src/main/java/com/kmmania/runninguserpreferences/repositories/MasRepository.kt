package com.kmmania.runninguserpreferences.repositories

import androidx.annotation.WorkerThread
import com.kmmania.runninguserpreferences.model.Mas
import com.kmmania.runninguserpreferences.model.MasDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MasRepository @Inject constructor(private val masDao: MasDao) {
    val masValue: Flow<Mas> = masDao.getMas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(mas: Mas) {
        masDao.deleteAll()
        masDao.insert(mas)
    }
}
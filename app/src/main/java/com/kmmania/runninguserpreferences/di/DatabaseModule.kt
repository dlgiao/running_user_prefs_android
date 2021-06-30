package com.kmmania.runninguserpreferences.di

import android.content.Context
import androidx.room.Room
import com.kmmania.runninguserpreferences.model.MeasuringSystemDao
import com.kmmania.runninguserpreferences.model.MeasuringSystemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideMeasuringSystemDatabase(
        //@ApplicationContext AppContext: Context, scope: CoroutineScope
        @ApplicationContext AppContext: Context
    ): MeasuringSystemDatabase {
        return Room.databaseBuilder(
            AppContext.applicationContext,
            MeasuringSystemDatabase::class.java,
            "measuring_system_database"
        )
            //.addCallback(MeasuringSystemDatabase.MeasuringSystemDatabaseCallback(scope))
            .build()
    }

    @Provides
    fun provideMeasuringSystemDao(
        measuringSystemDatabase: MeasuringSystemDatabase
    ): MeasuringSystemDao {
        return measuringSystemDatabase.measuringSystemDao()
    }


}
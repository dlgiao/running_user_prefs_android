package com.kmmania.runninguserpreferences.di

import android.content.Context
import androidx.room.Room
import com.kmmania.runninguserpreferences.model.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//import kotlinx.coroutines.CoroutineScope

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

    @Provides
    @Singleton
    fun provideGenderDatabase(
        @ApplicationContext AppContext: Context
    ): GenderDatabase {
        return Room.databaseBuilder(
            AppContext.applicationContext,
            GenderDatabase::class.java,
            "gender_database"
        )
            .build()
    }

    @Provides
    fun provideGenderDao(genderDatabase: GenderDatabase): GenderDao {
        return genderDatabase.genderDao()
    }

    @Provides
    @Singleton
    fun provideDobDatabase(
        @ApplicationContext AppContext: Context
    ): DobDatabase {
        return Room.databaseBuilder(
            AppContext.applicationContext,
            DobDatabase::class.java,
            "dob_database"
        )
            .build()
    }

    @Provides
    fun provideDobDao(dobDatabase: DobDatabase): DobDao {
        return dobDatabase.dobDao()
    }

}
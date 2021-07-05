package com.kmmania.runninguserpreferences.di

import android.content.Context
import androidx.room.Room
import com.kmmania.runninguserpreferences.model.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideCoroutineScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob())
    }

    @Provides
    @Singleton
    fun provideMeasuringSystemDatabase(
        @ApplicationContext AppContext: Context,
        scope: CoroutineScope
        //@ApplicationContext AppContext: Context
    ): MeasuringSystemDatabase {
        return Room.databaseBuilder(
            AppContext.applicationContext,
            MeasuringSystemDatabase::class.java,
            "measuring_system_database"
        )
            .addCallback(MeasuringSystemDatabase.MeasuringSystemDatabaseCallback(scope))
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

    @Provides
    @Singleton
    fun provideMasDatabase(
        @ApplicationContext AppContext: Context
    ): MasDatabase {
        return Room.databaseBuilder(
            AppContext.applicationContext,
            MasDatabase::class.java,
            "mas_database"
        )
            .build()
    }

    @Provides
    fun provideMasDao(masDatabase: MasDatabase): MasDao {
        return masDatabase.masDao()
    }

    @Provides
    @Singleton
    fun provideHeightDatabase(
        @ApplicationContext AppContext: Context
    ): HeightDatabase {
        return Room.databaseBuilder(
            AppContext.applicationContext,
            HeightDatabase::class.java,
            "height_database"
        )
            .build()
    }

    @Provides
    fun provideHeightDao(heightDatabase: HeightDatabase): HeightDao {
        return heightDatabase.heightDao()
    }

    @Provides
    @Singleton
    fun provideWeightDatabase(
        @ApplicationContext AppContext: Context
    ): WeightDatabase {
        return Room.databaseBuilder(
            AppContext.applicationContext,
            WeightDatabase::class.java,
            "weight_database"
        )
            .build()
    }

    @Provides
    fun provideWeightDao(weightDatabase: WeightDatabase): WeightDao {
        return weightDatabase.weightDao()
    }
}
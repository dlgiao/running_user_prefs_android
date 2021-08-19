package com.kmmania.runninguserpreferences.di

import com.kmmania.runninguserpreferences.duration_from_distance_speed.DurationFromDistanceSpeedDao
import com.kmmania.runninguserpreferences.duration.DurationDao
import com.kmmania.runninguserpreferences.duration.DurationRepository
import com.kmmania.runninguserpreferences.length.LengthDao
import com.kmmania.runninguserpreferences.length.LengthRepository
import com.kmmania.runninguserpreferences.speed.SpeedDao
import com.kmmania.runninguserpreferences.speed.SpeedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DaoModule {

    @Binds
    abstract fun bindDurationDao(durationRepository: DurationRepository): DurationDao

    @Binds
    abstract fun bindDurationFromDistanceMasDao(
        durationRFromDistanceSpeedDao: DurationFromDistanceSpeedDao
    ): DurationFromDistanceSpeedDao

    @Binds
    abstract fun bindLengthDao(lengthRepository: LengthRepository): LengthDao

    @Binds
    abstract fun bindSpeedDao(speedRepository: SpeedRepository): SpeedDao
}
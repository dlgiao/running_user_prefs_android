package com.kmmania.runninguserpreferences.di

import com.kmmania.runninguserpreferences.duration_from_distance_speed.DurationFromDistanceSpeedDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DaoModule {
    @Binds
    abstract fun bindDurationFromDistanceMasDao(
        durationRFromDistanceSpeedDao: DurationFromDistanceSpeedDao
    ): DurationFromDistanceSpeedDao
}
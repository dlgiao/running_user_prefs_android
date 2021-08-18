package com.kmmania.runninguserpreferences.di

import com.kmmania.runninguserpreferences.model.DurationDao
import com.kmmania.runninguserpreferences.repositories.DurationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DaoModule {
//    @Binds
//    abstract fun bindDurationDao(durationRepository: DurationRepository): DurationDao
}
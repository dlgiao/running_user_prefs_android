package com.kmmania.runninguserpreferences.speed

import androidx.lifecycle.ViewModel
import com.kmmania.runninguserpreferences.utils.units.SpeedUnit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpeedViewModel @Inject constructor(
    private val speedRepository: SpeedRepository
): ViewModel() {
    fun getSpeed(speedValue: Double?, speedUnit: SpeedUnit?): Speed =
        speedRepository.getSpeed(speedValue, speedUnit)
}
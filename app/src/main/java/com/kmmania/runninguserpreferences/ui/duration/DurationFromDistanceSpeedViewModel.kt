package com.kmmania.runninguserpreferences.ui.duration

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kmmania.runninguserpreferences.model.Duration
import com.kmmania.runninguserpreferences.model.Length
import com.kmmania.runninguserpreferences.model.Speed
import com.kmmania.runninguserpreferences.repositories.DurationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DurationFromDistanceSpeedViewModel @Inject constructor(
    //private val durationRepository: DurationRepository
): ViewModel() {
    //val duration: LiveData<Duration> = durationRepository.duration.asLiveData()

//    fun getDurationFromDistanceSpeed(distance: Length, speed: Speed) = viewModelScope.launch {
//        durationRepository.getDurationFromDistanceSpeed(distance, speed)
//    }

    fun getDurationFromDistanceSpeed(distance: Length, speed: Speed): Duration {
        val distanceValue = distance.lengthValue
        val distanceUnit = distance.lengthUnit
        val speedValue = speed.speedValue
        val speedUnit = speed.speedUnit
        val timeInSec = distanceValue?.div(speedValue!!)?.times(3600)

        return Duration(
            timeInSec?.div(3600)?.toInt(),
            timeInSec?.rem(3600)?.div(60)?.toInt(),
            timeInSec?.rem(3600)?.rem(60)?.toInt()!!,
            timeInSec.minus(timeInSec.toInt()).times(1000).toInt()
        )
    }
}
package com.kmmania.runninguserpreferences.duration_from_distance_speed

import androidx.lifecycle.ViewModel
import com.kmmania.runninguserpreferences.duration.Duration
import com.kmmania.runninguserpreferences.length.Length
import com.kmmania.runninguserpreferences.speed.Speed
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DurationFromDistanceSpeedViewModel @Inject constructor(
    private val durationFromDistanceSpeedRepository: DurationFromDistanceSpeedRepository
): ViewModel() {

    fun getDurationFromDistanceSpeed(distance: Length, speed: Speed): Duration =
        durationFromDistanceSpeedRepository.getDuration(distance, speed)
}
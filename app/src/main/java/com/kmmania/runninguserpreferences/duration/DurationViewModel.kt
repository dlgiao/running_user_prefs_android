package com.kmmania.runninguserpreferences.duration

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DurationViewModel @Inject constructor(
    private val durationRepository: DurationRepository
): ViewModel() {
    fun getDuration(hr: Int?, min: Int?, sec: Int?, ms: Int?): Duration {
        return durationRepository.getDuration(hr, min, sec, ms)
    }
}
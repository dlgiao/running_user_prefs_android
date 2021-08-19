package com.kmmania.runninguserpreferences.length

import androidx.lifecycle.ViewModel
import com.kmmania.runninguserpreferences.utils.units.LengthUnit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LengthViewModel @Inject constructor(
    private val lengthRepository: LengthRepository
): ViewModel() {
    fun getLength(lengthValue: Double?, lengthUnit: LengthUnit?): Length = lengthRepository.getLength(lengthValue, lengthUnit)
}
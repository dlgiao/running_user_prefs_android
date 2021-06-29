package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.*
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.repositories.MeasuringSystemRepository
import kotlinx.coroutines.launch

class MeasuringSystemViewModel(
    private val measuringSystemRepository: MeasuringSystemRepository
): ViewModel() {
    val lastMeasuringSystem: LiveData<MeasuringSystem> = measuringSystemRepository
        .lastMeasuringSystem
        .asLiveData()

    fun insert(measuringSystem: MeasuringSystem) = viewModelScope.launch {
        measuringSystemRepository.insert(measuringSystem)
    }
}

class MeasuringSystemViewModelFactory(
    private val measuringSystemRepository: MeasuringSystemRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MeasuringSystemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MeasuringSystemViewModel(measuringSystemRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
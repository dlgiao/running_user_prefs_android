package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.*
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.repositories.MeasuringSystemRepository
import kotlinx.coroutines.launch

class MeasuringSystemViewModel(
    private val msRepository: MeasuringSystemRepository
): ViewModel() {
    val lastMS: LiveData<MeasuringSystem> = msRepository.lastMS.asLiveData()

    fun insert(measuringSystem: MeasuringSystem) = viewModelScope.launch {
        msRepository.insert(measuringSystem)
    }
}

class MeasuringSystemViewModelFactory(
    private val msRepository: MeasuringSystemRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MeasuringSystemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MeasuringSystemViewModel(msRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
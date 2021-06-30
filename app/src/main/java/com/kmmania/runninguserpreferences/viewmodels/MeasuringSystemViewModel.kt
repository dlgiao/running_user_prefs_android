package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.*
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.repositories.MeasuringSystemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasuringSystemViewModel @Inject constructor(
    private val msRepository: MeasuringSystemRepository
): ViewModel() {
    val msValue: LiveData<MeasuringSystem> = msRepository.msValue.asLiveData()

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
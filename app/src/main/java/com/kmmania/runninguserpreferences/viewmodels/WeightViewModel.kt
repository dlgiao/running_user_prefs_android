package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kmmania.runninguserpreferences.model.Weight
import com.kmmania.runninguserpreferences.repositories.WeightRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val weightRepository: WeightRepository
): ViewModel() {
    val weightValue: LiveData<Weight> = weightRepository.weightValue.asLiveData()

    fun insert(weight: Weight) = viewModelScope.launch {
        weightRepository.insert(weight)
    }
}
package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kmmania.runninguserpreferences.model.Height
import com.kmmania.runninguserpreferences.repositories.HeightRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val heightRepository: HeightRepository
): ViewModel() {
    val heightValue: LiveData<Height> = heightRepository.heightValue.asLiveData()

    fun insert(height: Height) = viewModelScope.launch {
        heightRepository.insert((height))
    }
}
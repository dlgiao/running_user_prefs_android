package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kmmania.runninguserpreferences.model.Gender
import com.kmmania.runninguserpreferences.repositories.GenderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val genderRepository: GenderRepository
): ViewModel() {
    val genderValue: LiveData<Gender> = genderRepository.genderValue.asLiveData()
}
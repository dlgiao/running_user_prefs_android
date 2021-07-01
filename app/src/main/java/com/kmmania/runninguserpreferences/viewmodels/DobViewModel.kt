package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kmmania.runninguserpreferences.model.Dob
import com.kmmania.runninguserpreferences.repositories.DobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DobViewModel @Inject constructor(
    private val dobRepository: DobRepository
): ViewModel() {
    val dobValue: LiveData<Dob> = dobRepository.dobValue.asLiveData()
}
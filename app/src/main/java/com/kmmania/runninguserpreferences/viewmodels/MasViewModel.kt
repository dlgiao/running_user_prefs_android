package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kmmania.runninguserpreferences.model.Mas
import com.kmmania.runninguserpreferences.repositories.MasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MasViewModel @Inject constructor(
    private val masRepository: MasRepository
): ViewModel() {
    val masValue: LiveData<Mas> = masRepository.masValue.asLiveData()
}
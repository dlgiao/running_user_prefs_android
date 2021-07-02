package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kmmania.runninguserpreferences.model.Mas
import com.kmmania.runninguserpreferences.repositories.MasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MasViewModel @Inject constructor(
    private val masRepository: MasRepository
): ViewModel() {
    val masValue: LiveData<Mas> = masRepository.masValue.asLiveData()

    fun insert(mas: Mas) = viewModelScope.launch {
        masRepository.insert(mas)
    }
}
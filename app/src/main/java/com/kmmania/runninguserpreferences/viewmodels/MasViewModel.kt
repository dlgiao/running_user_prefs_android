package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.ViewModel
import com.kmmania.runninguserpreferences.repositories.MasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MasViewModel @Inject constructor(
    private val masRepository: MasRepository
): ViewModel() {
}
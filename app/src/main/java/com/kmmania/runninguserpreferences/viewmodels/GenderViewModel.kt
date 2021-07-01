package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.ViewModel
import com.kmmania.runninguserpreferences.repositories.GenderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val genderRepository: GenderRepository
): ViewModel() {
}
package com.kmmania.runninguserpreferences.user_prefs

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPrefsViewModel @Inject constructor(
    private val userPrefsRepository: UserPrefsRepository
): ViewModel() {
    val userPrefsValue: LiveData<UserPrefs> = userPrefsRepository.userPrefsValue.asLiveData()

    fun insert(userPrefs: UserPrefs) = viewModelScope.launch {
        userPrefsRepository.insert(userPrefs)
    }
}
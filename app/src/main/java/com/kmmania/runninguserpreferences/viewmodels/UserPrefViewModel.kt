package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.*
import com.kmmania.runninguserpreferences.model.UserPref
import com.kmmania.runninguserpreferences.repositories.UserPrefRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPrefViewModel @Inject constructor(
    private val userPrefRepository: UserPrefRepository
): ViewModel() {
    val userPrefValue: LiveData<UserPref> = userPrefRepository.userPrefValue.asLiveData()

    fun insert(userPref: UserPref) = viewModelScope.launch {
        userPrefRepository.insert(userPref)
    }
}
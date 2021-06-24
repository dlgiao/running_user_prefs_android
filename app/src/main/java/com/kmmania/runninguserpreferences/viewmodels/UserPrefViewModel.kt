package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kmmania.runninguserpreferences.model.UserPref
import com.kmmania.runninguserpreferences.repositories.UserPrefRepository
import kotlinx.coroutines.launch

class UserPrefViewModel(private val userPrefRepository: UserPrefRepository): ViewModel() {
    val allUserPref: LiveData<List<UserPref>> = userPrefRepository.allUserPref.asLiveData()

    fun insert(userPref: UserPref) = viewModelScope.launch {
        userPrefRepository.insert(userPref)
    }
}
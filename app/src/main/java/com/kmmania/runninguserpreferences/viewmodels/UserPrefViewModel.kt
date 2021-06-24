package com.kmmania.runninguserpreferences.viewmodels

import androidx.lifecycle.*
import com.kmmania.runninguserpreferences.model.UserPref
import com.kmmania.runninguserpreferences.repositories.UserPrefRepository
import kotlinx.coroutines.launch

class UserPrefViewModel(private val userPrefRepository: UserPrefRepository): ViewModel() {
    val allUserPref: LiveData<List<UserPref>> = userPrefRepository.allUserPref.asLiveData()

    fun insert(userPref: UserPref) = viewModelScope.launch {
        userPrefRepository.insert(userPref)
    }
}

class UserPrefViewModelFactory(private val userPrefRepository: UserPrefRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserPrefViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserPrefViewModel(userPrefRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
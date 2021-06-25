package com.kmmania.runninguserpreferences

import android.app.Application
import com.kmmania.runninguserpreferences.model.UserPrefDatabase
import com.kmmania.runninguserpreferences.repositories.UserPrefRepository

class UserPrefApplication: Application() {
    private val database by lazy { UserPrefDatabase.getDatabase(this) }
    val repository by lazy { UserPrefRepository(database.userPrefDao()) }
}
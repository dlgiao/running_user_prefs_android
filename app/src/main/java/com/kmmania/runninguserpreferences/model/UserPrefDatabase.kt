package com.kmmania.runninguserpreferences.model

import androidx.room.Database

@Database(entities = [UserPref::class], version = 1, exportSchema = false)
abstract class UserPrefDatabase {
}
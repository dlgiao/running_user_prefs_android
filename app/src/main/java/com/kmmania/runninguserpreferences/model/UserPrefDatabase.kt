package com.kmmania.runninguserpreferences.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserPref::class], version = 1, exportSchema = false)
abstract class UserPrefDatabase: RoomDatabase() {
    abstract fun userPrefDao(): UserPrefDao

//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: UserPrefDatabase? = null
//
//        fun getDatabase(context: Context): UserPrefDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    UserPrefDatabase::class.java,
//                    "user_pref_database"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
}
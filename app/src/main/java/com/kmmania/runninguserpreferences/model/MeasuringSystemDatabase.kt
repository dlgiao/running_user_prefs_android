package com.kmmania.runninguserpreferences.model

import androidx.room.Database
//import androidx.room.Room
import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.kmmania.runninguserpreferences.application.RunningUserPrefApplication
//import com.kmmania.runninguserpreferences.utils.units.MeasuringSystemUnit
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch

@Database(entities = [MeasuringSystem::class], version = 1, exportSchema = false)
abstract class MeasuringSystemDatabase: RoomDatabase() {

    abstract  fun measuringSystemDao(): MeasuringSystemDao

//    private class MeasuringSystemDatabaseCallback(
//        private val scope: CoroutineScope
//    ): RoomDatabase.Callback() {
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//            INSTANCE?.let { database ->
//                scope.launch {
//                    val measuringSystemDao = database.measuringSystemDao()
//                    measuringSystemDao.deleteAll()
//                    val initialMeasuringSystem = MeasuringSystem(MeasuringSystemUnit.METRIC)
//                    measuringSystemDao.insert(initialMeasuringSystem)
//                }
//            }
//        }
//    }

//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: MeasuringSystemDatabase? = null
//
//        fun getDatabase(
//            context: RunningUserPrefApplication,
//            scope: CoroutineScope
//        ): MeasuringSystemDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    MeasuringSystemDatabase::class.java,
//                    "measuring_system_database"
//                )
//                    .addCallback(MeasuringSystemDatabaseCallback(scope))
//                    .build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
}
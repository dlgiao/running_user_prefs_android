package com.kmmania.runninguserpreferences.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kmmania.runninguserpreferences.model.units.*
import com.kmmania.runninguserpreferences.user_prefs.UserPrefs
import com.kmmania.runninguserpreferences.user_prefs.UserPrefsDao
import com.kmmania.runninguserpreferences.user_prefs.UserPrefsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUserPrefsDatabase(
        @ApplicationContext AppContext: Context,
        @ApplicationScope scope: CoroutineScope
    ): UserPrefsDatabase {
        var userPrefsInstance: UserPrefsDatabase? = null
        return userPrefsInstance?: synchronized(this) {
            val instance = Room.databaseBuilder(
                AppContext,
                UserPrefsDatabase::class.java,
                "user_prefs_database"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        userPrefsInstance?.let { database ->
                            scope.launch {
                                val userPrefsDao = database.userPrefsDao()
                                userPrefsDao.deleteAll()
                                // User prefs initial values
                                val userPrefs = UserPrefs(
                                    MeasuringSystemUnit.METRIC,
                                    GenderUnit.MALE,
                                    0,
                                    0.0, SpeedUnit.KMH,
                                    0, LengthUnit.CM,
                                    0.0, WeightUnit.KG
                                )
                                userPrefsDao.insert(userPrefs)
                            }
                        }
                    }
                })
                .build()
            userPrefsInstance = instance
            instance
        }
    }

    @Provides
    fun provideUserPrefsDao(userPrefsDatabase: UserPrefsDatabase): UserPrefsDao {
        return userPrefsDatabase.userPrefsDao()
    }
}
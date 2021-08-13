package com.kmmania.runninguserpreferences.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kmmania.runninguserpreferences.model.*
import com.kmmania.runninguserpreferences.model.units.*
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
        @ApplicationContext scope: CoroutineScope
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
                                    null,
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

    @Provides
    @Singleton
    fun provideMeasuringSystemDatabase(
        @ApplicationContext AppContext: Context,
        @ApplicationScope scope: CoroutineScope
    ): MeasuringSystemDatabase {
        var msInstance: MeasuringSystemDatabase? = null
        return msInstance?: synchronized(this) {
            val instance = Room.databaseBuilder(
                AppContext,
                MeasuringSystemDatabase::class.java,
                "measuring_system_database"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        msInstance?.let { database ->
                            scope.launch {
                                val msDao = database.measuringSystemDao()
                                msDao.deleteAll()
                                val ms = MeasuringSystem(MeasuringSystemUnit.METRIC)
                                msDao.insert(ms)
                            }
                        }
                    }
                })
                .build()
            msInstance = instance
            instance
        }
    }

    @Provides
    fun provideMeasuringSystemDao(
        measuringSystemDatabase: MeasuringSystemDatabase
    ): MeasuringSystemDao {
        return measuringSystemDatabase.measuringSystemDao()
    }

    @Provides
    @Singleton
    fun provideGenderDatabase(
        @ApplicationContext AppContext: Context,
        @ApplicationScope scope: CoroutineScope
    ): GenderDatabase {
        var genderInstance: GenderDatabase? = null
        return genderInstance?: synchronized(this) {
            val instance = Room.databaseBuilder(
                AppContext,
                GenderDatabase::class.java,
                "gender_database"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        genderInstance?.let { database ->
                            scope.launch {
                                val genderDao = database.genderDao()
                                genderDao.deleteAll()
                                val gender = Gender(GenderUnit.MALE)
                                genderDao.insert(gender)
                            }
                        }
                    }
                })
                .build()
            genderInstance = instance
            instance
        }
    }

    @Provides
    fun provideGenderDao(genderDatabase: GenderDatabase): GenderDao {
        return genderDatabase.genderDao()
    }

    @Provides
    @Singleton
    fun provideDobDatabase(
        @ApplicationContext AppContext: Context,
        @ApplicationScope scope: CoroutineScope
    ): DobDatabase {
        var dobInstance: DobDatabase? = null
        return dobInstance?: synchronized(this) {
            val instance = Room.databaseBuilder(
                AppContext.applicationContext,
                DobDatabase::class.java,
                "dob_database"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        dobInstance?.let { database ->
                            scope.launch {
                                // TODO: add Dob initial date
                            }
                        }
                    }
                })
                .build()
            dobInstance = instance
            instance
        }
    }

    @Provides
    fun provideDobDao(dobDatabase: DobDatabase): DobDao {
        return dobDatabase.dobDao()
    }

    @Provides
    @Singleton
    fun provideMasDatabase(
        @ApplicationContext AppContext: Context,
        @ApplicationScope scope: CoroutineScope
    ): MasDatabase {
        var masInstance: MasDatabase? = null
        return masInstance?: synchronized(this) {
            val instance = Room.databaseBuilder(
                AppContext.applicationContext,
                MasDatabase::class.java,
                "mas_database"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        masInstance?.let { database ->
                            scope.launch {
                                val masDao = database.masDao()
                                masDao.deleteAll()
                                val mas = Mas(0.0, SpeedUnit.KMH)
                                masDao.insert(mas)
                            }
                        }
                    }
                })
                .build()
            masInstance = instance
            instance
        }
    }

    @Provides
    fun provideMasDao(masDatabase: MasDatabase): MasDao {
        return masDatabase.masDao()
    }

    @Provides
    @Singleton
    fun provideHeightDatabase(
        @ApplicationContext AppContext: Context,
        @ApplicationScope scope: CoroutineScope
    ): HeightDatabase {
        var heightInstance: HeightDatabase? = null
        return heightInstance?: synchronized(this) {
            val instance = Room.databaseBuilder(
                AppContext,
                HeightDatabase::class.java,
                "height_database"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        heightInstance?.let { database ->
                            scope.launch {
                                val heightDao = database.heightDao()
                                heightDao.deleteAll()
                                val height = Height(0, LengthUnit.CM)
                                heightDao.insert(height)
                            }
                        }
                    }
                })
                .build()
            heightInstance = instance
            instance
        }
    }

    @Provides
    fun provideHeightDao(heightDatabase: HeightDatabase): HeightDao {
        return heightDatabase.heightDao()
    }

    @Provides
    @Singleton
    fun provideWeightDatabase(
        @ApplicationContext AppContext: Context,
        @ApplicationScope scope: CoroutineScope
    ): WeightDatabase {
        var weightInstance: WeightDatabase? = null
        return weightInstance?: synchronized(this) {
            val instance = Room.databaseBuilder(
                AppContext,
                WeightDatabase::class.java,
                "weight_database"
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        weightInstance?.let { database ->
                            scope.launch {
                                val weightDao = database.weightDao()
                                weightDao.deleteAll()
                                val weight = Weight(0.0, WeightUnit.KG)
                                weightDao.insert(weight)
                            }
                        }
                    }
                })
                .build()
            weightInstance = instance
            instance
        }
    }

    @Provides
    fun provideWeightDao(weightDatabase: WeightDatabase): WeightDao {
        return weightDatabase.weightDao()
    }
}
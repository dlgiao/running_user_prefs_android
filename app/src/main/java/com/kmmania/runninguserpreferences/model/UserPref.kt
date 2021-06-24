package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.utils.units.LengthUnit
import com.kmmania.runninguserpreferences.utils.units.MeasuringSystemUnit
import com.kmmania.runninguserpreferences.utils.units.SpeedUnit
import java.util.*

@Entity(tableName = "user_pref_table")
data class UserPref(
    @ColumnInfo(name = "measuring_system")
    val measuringSystem: MeasuringSystemUnit,
    @ColumnInfo(name = "mas")
    val mas: Double,
    @ColumnInfo(name = "unit_mas")
    val unitMas: SpeedUnit,
    @ColumnInfo(name = "dob")
    val dob: Date,
    @ColumnInfo(name = "height")
    val height: Int,
    @ColumnInfo(name = "unit_height")
    val unitHeight: LengthUnit

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

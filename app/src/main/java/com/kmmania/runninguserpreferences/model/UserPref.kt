package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.utils.units.*

@Entity(tableName = "user_pref_table")
data class UserPref(
    @ColumnInfo(name = "measuring_system")
    val measuringSystem: MeasuringSystemUnit,
    @ColumnInfo(name = "mas")
    val mas: Double,
    @ColumnInfo(name = "unit_mas")
    val unitMas: SpeedUnit,
    @ColumnInfo(name = "dob")
    val dob: String,
    @ColumnInfo(name = "height")
    val height: Int,
    @ColumnInfo(name = "unit_height")
    val unitHeight: LengthUnit,
    @ColumnInfo(name = "weight")
    val weight: Double,
    @ColumnInfo(name = "unit_weight")
    val unitWeightUnit: WeightUnit,
    @ColumnInfo(name = "gender")
    val gender: Gender

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.model.units.*

@Entity(tableName = "user_prefs_table")
data class UserPrefs(
    @ColumnInfo(name = "measuring_system")
    val measuringSystem: MeasuringSystemUnit?,
    @ColumnInfo(name = "gender")
    val gender: GenderUnit?,
    @ColumnInfo(name = "age")
    val age: Int?,
    @ColumnInfo(name = "mas_value")
    val masValue: Double?,
    @ColumnInfo(name = "mas_unit")
    val masUnit: SpeedUnit?,
    @ColumnInfo(name = "height_value")
    val heightValue: Int?,
    @ColumnInfo(name = "height_unit")
    val heightUnit: LengthUnit?,
    @ColumnInfo(name = "weight_value")
    val weightValue: Double?,
    @ColumnInfo(name = "weight_unit")
    val weightUnit: WeightUnit?

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

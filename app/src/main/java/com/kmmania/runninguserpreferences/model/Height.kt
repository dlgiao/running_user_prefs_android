package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.utils.units.LengthUnit

@Entity(tableName = "height_table")
data class Height(
    @PrimaryKey
    @ColumnInfo(name = "height_value")
    val heightValue: Int,
    @ColumnInfo(name = "height_unit")
    val heightUnit: LengthUnit
)

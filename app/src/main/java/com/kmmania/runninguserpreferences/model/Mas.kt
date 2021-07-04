package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.utils.units.SpeedUnit

@Entity(tableName = "mas_table")
data class Mas(
    @PrimaryKey
    @ColumnInfo(name = "mas_value")
    val masValue: Double?,
    @ColumnInfo(name = "mas_unit")
    val masUnit: SpeedUnit
)

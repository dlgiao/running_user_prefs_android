package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.utils.units.WeightUnit

@Entity(tableName = "weight_table")
data class Weight(
    @PrimaryKey
    @ColumnInfo(name = "weight_value")
    val weightValue: Double,
    @ColumnInfo(name = "weight_unit")
    val weightUnit: WeightUnit
)

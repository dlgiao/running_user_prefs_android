package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.utils.units.MeasuringSystemUnit

@Entity(tableName = "measuring_system_table")
data class MeasuringSystem(
    @PrimaryKey
    @ColumnInfo(name = "measuring_system")
    val measuringSystem: MeasuringSystemUnit
)
//{
//    @PrimaryKey(autoGenerate = true)
//    var id: Long = 0
//}

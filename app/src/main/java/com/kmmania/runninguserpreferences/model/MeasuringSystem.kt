package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.utils.units.MeasuringSystemUnit
import java.util.*

@Entity(tableName = "measuring_system_table")
data class MeasuringSystem(
    @ColumnInfo(name = "measuring_system")
    val measuringSystem: MeasuringSystemUnit,
    @ColumnInfo(name = "created_at")
    val createdAt: Date
) {
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
}

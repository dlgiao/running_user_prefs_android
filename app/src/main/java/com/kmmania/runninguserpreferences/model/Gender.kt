package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kmmania.runninguserpreferences.utils.units.GenderUnit

@Entity(tableName = "gender_table")
data class Gender(
    @PrimaryKey
    @ColumnInfo(name = "gender")
    val gender: GenderUnit
)

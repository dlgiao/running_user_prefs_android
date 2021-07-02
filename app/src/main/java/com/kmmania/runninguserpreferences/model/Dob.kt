package com.kmmania.runninguserpreferences.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "dob_table")
data class Dob(
    @PrimaryKey
    @ColumnInfo(name = "dob")
    //val dob: Date
    val dob: String
)

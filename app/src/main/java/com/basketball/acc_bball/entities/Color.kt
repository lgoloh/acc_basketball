package com.basketball.acc_bball.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.basketball.acc_bball.utils.Constants

@Entity(tableName = Constants.COLOR)
data class Color(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = Constants.NAME) val name: String
)

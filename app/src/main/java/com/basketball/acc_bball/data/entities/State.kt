package com.basketball.acc_bball.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.basketball.acc_bball.utils.Constants

@Entity(tableName = Constants.STATE)
data class State(
    @PrimaryKey @ColumnInfo(name = Constants.STATE_ID) val id: Int,
    @ColumnInfo(name = Constants.NAME) val name: String
)

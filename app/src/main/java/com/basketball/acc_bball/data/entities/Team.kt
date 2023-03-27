package com.basketball.acc_bball.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.basketball.acc_bball.utils.Constants

@Entity(tableName = Constants.TEAM)
data class Team(
    @PrimaryKey @ColumnInfo(name = Constants.TEAM_ID) val id: Int,
    @ColumnInfo(name = Constants.NAME) val name: String,
    @ColumnInfo(name = Constants.STATE_ID) val state_id: Int,
    @ColumnInfo(name = Constants.COLOR_ID) val color_id: Int,
    @ColumnInfo(name = Constants.WINS) val wins: Int,
    @ColumnInfo(name = Constants.LOSSES) val losses: Int
)

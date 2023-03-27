package com.basketball.acc_bball.entities

import com.basketball.acc_bball.utils.Constants
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Constants.PLAYER)
data class Player(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = Constants.TEAM_ID) val team_id: Int,
    @ColumnInfo(name = Constants.UNIFORM_NUM)val uniform_num: Int,
    @ColumnInfo(name = Constants.FIRST_NAME) val firstName: String,
    @ColumnInfo(name = Constants.LAST_NAME) val lastName: String,
    @ColumnInfo(name = Constants.MPG)val mpg: Int,
    @ColumnInfo(name = Constants.PPG)val ppg: Int,
    @ColumnInfo(name = Constants.RPG)val rpg: Int,
    @ColumnInfo(name = Constants.APG)val apg: Int,
    @ColumnInfo(name = Constants.SPG)val spg: Double,
    @ColumnInfo(name = Constants.BPG)val bpg: Double
)

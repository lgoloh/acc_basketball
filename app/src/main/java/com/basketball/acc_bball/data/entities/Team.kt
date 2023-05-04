package com.basketball.acc_bball.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.basketball.acc_bball.R
import com.basketball.acc_bball.utils.Constants

@Entity(tableName = Constants.TEAM)
data class Team(
    @PrimaryKey @ColumnInfo(name = Constants.TEAM_ID) val id: Int,
    @ColumnInfo(name = Constants.NAME) val name: String,
    @ColumnInfo(name = Constants.STATE_ID) val state_id: Int,
    @ColumnInfo(name = Constants.COLOR_ID) val color_id: Int,
    @ColumnInfo(name = Constants.WINS) val wins: Int,
    @ColumnInfo(name = Constants.LOSSES) val losses: Int,
    val resource_id: Int = setResource(name)
)
private fun setResource(name: String) : Int =
    when (name) {
        "Duke" ->  R.drawable.duke
        "BostonCollege" -> R.drawable.boston
        "Clemson" ->  R.drawable.clemson
        "FloridaState" ->  R.drawable.floridastate
        "GeorgiaTech" ->  R.drawable.georgiaTech
        "Louisville" ->  R.drawable.louisville
        "Miami" -> R.drawable.miami
        "NotreDame" ->  R.drawable.notredame
        "Pittsburgh" ->  R.drawable.pittsburgh
        "Syracuse" ->  R.drawable.syracuse
        "Virginia" ->  R.drawable.virginia
        "VirginiaTech" ->  R.drawable.virginiaTech
        "WakeForest" -> R.drawable.wakeForest
        else -> { throw UnsupportedOperationException("Invalid Operation")}
    }


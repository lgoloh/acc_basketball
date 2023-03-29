package com.basketball.acc_bball.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.basketball.acc_bball.data.entities.Player

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(players: List<Player>)

    @Query("SELECT * FROM player")
    fun getAll(): List<Player>

}
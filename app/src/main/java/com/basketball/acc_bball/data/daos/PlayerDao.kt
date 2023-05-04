package com.basketball.acc_bball.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.basketball.acc_bball.data.entities.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(players: List<Player>)

    @Query("SELECT * FROM player")
    fun getAll(): Flow<List<Player>>

    @Query("SELECT * FROM player "
            + "JOIN team ON player.team_id = team.team_id "
            + "WHERE team.name = :team_name")
    fun getPlayersForTeam(team_name: String) : Flow<List<Player>>
}
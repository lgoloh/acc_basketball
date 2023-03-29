package com.basketball.acc_bball.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.basketball.acc_bball.data.entities.Team
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun getTeams(): Flow<List<Team>>

    @Query("SELECT * FROM team WHERE name = :t_name")
    fun getTeamInfo(t_name: String): Flow<Team>

    @Query("SELECT team.name FROM team " +
            " JOIN color ON team.color_id = color.color_id WHERE color.name = :t_color")
    fun getTeamsWithColor(t_color: String): Flow<List<String>>

    @Insert
    fun addTeam(team: Team)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(teams: List<Team>)
}
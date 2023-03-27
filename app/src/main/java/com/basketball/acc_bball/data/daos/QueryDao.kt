package com.basketball.acc_bball.data.daos

import androidx.room.*
import com.basketball.acc_bball.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface QueryDao {
    /*@Query()
    fun query1(): List<Player>*/

    //SELECT "TEAM"."NAME" FROM "TEAM", "COLOR" WHERE "TEAM"."COLOR_ID" = "COLOR"."COLOR_ID" AND "COLOR"."NAME" = team_color;
    @Query("SELECT team.name FROM team " +
            " JOIN color ON team.color_id = color.id WHERE color.name = :uniform_color")
    fun query2(uniform_color: String): Flow<List<String>>

    //SELECT "FIRST_NAME", "LAST_NAME" FROM "PLAYER", "TEAM" WHERE "PLAYER"."TEAM_ID" = "TEAM"."TEAM_ID" AND "NAME" = 'Duke' ORDER BY "PPG" DESC;
    @Query("SELECT firstName, lastName FROM player " +
            "JOIN team ON player.team_id = team.id WHERE team.name = :team ORDER BY :Utils.PPG DESC")
    fun query3(team: String): Flow<List<PlayerName>>

    //SELECT "UNIFORM_NUM", "FIRST_NAME", "LAST_NAME" FROM "PLAYER", "TEAM", "STATE", "COLOR" WHERE "PLAYER"."TEAM_ID" = "TEAM"."TEAM_ID" AND "TEAM"."STATE_ID" = "STATE"."STATE_ID" AND "TEAM"."COLOR_ID" = "COLOR"."COLOR_ID" AND "STATE"."NAME" = 'VA' AND "COLOR"."NAME" = 'Maroon';
    @Query("SELECT uniform_num, firstName, lastName FROM player " +
            "JOIN team ON player.team_id = team.id " +
            "JOIN state ON team.state_id = state.id " +
            "JOIN color ON team.color_id = color.id " +
            "WHERE state.name = :state AND color.name = :uniform_color")
    fun query4(state: String, uniform_color: String): Flow<List<PlayerUniform>>

    //SELECT "FIRST_NAME", "LAST_NAME", "TEAM"."NAME", "WINS" FROM "PLAYER", "TEAM" WHERE "PLAYER"."TEAM_ID" = "TEAM"."TEAM_ID" AND "WINS" > 2;
    @Query("SELECT firstName, lastName, team.name, wins FROM player " +
            "JOIN team ON player.team_id = team.id " +
            "WHERE wins > :num_wins")
    fun query5(num_wins: Int): Flow<List<TeamWins>>

    data class PlayerName(
        @ColumnInfo(name = Constants.FIRST_NAME) val first: String?,
        @ColumnInfo(name = Constants.LAST_NAME) val last: String?
    )

    data class PlayerUniform(
        @ColumnInfo(name = Constants.UNIFORM_NUM) val uniform_num: Int?,
        @Embedded val player: PlayerName?
    )

    data class PlayerTeamPair(
        @Embedded val player: PlayerName?,
        @ColumnInfo(name = Constants.NAME) val team: String?
    )

    data class TeamWins(
        @Embedded val playerTeam: PlayerTeamPair?,
        @ColumnInfo(name = Constants.WINS) val wins: Int?
    )


}
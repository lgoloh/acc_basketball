package com.basketball.acc_bball.data

import android.content.Context
import com.basketball.acc_bball.data.daos.QueryDao
import com.basketball.acc_bball.data.entities.Player
import com.basketball.acc_bball.data.entities.State
import com.basketball.acc_bball.data.entities.Team
import kotlinx.coroutines.flow.Flow

class DataRepository(context: Context) : DataRepositoryInterface {
    private val db: ACCDatabase = ACCDatabase.getDatabase(context)

    override fun getTeams(): Flow<List<Team>> {
        return db.teamDao().getTeams()
    }

    override fun getPlayersForTeam(team: String): Flow<List<QueryDao.PlayerName>> {
        return db.queryDao().query3(team)
    }

    override fun getTeamsFromState(state: String): Flow<List<State>> {
        TODO("Not yet implemented")
    }


}
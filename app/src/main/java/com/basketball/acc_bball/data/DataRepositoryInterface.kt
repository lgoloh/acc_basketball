package com.basketball.acc_bball.data

import com.basketball.acc_bball.data.daos.QueryDao
import com.basketball.acc_bball.data.entities.Player
import com.basketball.acc_bball.data.entities.State
import com.basketball.acc_bball.data.entities.Team
import kotlinx.coroutines.flow.Flow

interface DataRepositoryInterface {
    fun getTeams() : Flow<List<Team>>

    fun getPlayersForTeam(team: String) : Flow<List<QueryDao.PlayerName>>

    fun getTeamsFromState(state: String): Flow<List<State>>
}
package com.basketball.acc_bball.viewmodels

import androidx.lifecycle.ViewModel
import com.basketball.acc_bball.data.DataRepositoryInterface
import com.basketball.acc_bball.data.daos.QueryDao
import com.basketball.acc_bball.data.entities.Team
import kotlinx.coroutines.flow.Flow

class TeamViewModel(
    private val dataSource: DataRepositoryInterface
) : ViewModel() {

    fun getTeams() : Flow<List<Team>> {
        return dataSource.getTeams()
    }

    fun getTeamPlayers(name: String): Flow<List<QueryDao.PlayerName>> {
        return dataSource.getPlayersForTeam(name)
    }
}
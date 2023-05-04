package com.basketball.acc_bball.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.basketball.acc_bball.data.daos.QueryDao.PlayerName
import com.basketball.acc_bball.data.entities.Team
import com.basketball.acc_bball.viewmodels.TeamViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun TeamItem(
    team: Team,
    viewModel: TeamViewModel
)
{
    lateinit var players: List<PlayerName>
    val coroutineScope = rememberCoroutineScope()
    val getPlayersOnClick: () -> Unit = {
        coroutineScope.launch {
            viewModel.getTeamPlayers(team.name).collect {
                players = it
                //TODO: naviage to player list view
            }
        }
    }
    Card(
        modifier = Modifier.clickable { getPlayersOnClick() },
        shape = RoundedCornerShape(14.dp)
    ) {
        val description = "Team card for ${team.name} university"
        Column (
            modifier = Modifier.background(color = Color.White),
        ) {
            Image(
                painter = painterResource(id = team.resource_id),
                contentDescription = description
            )
            Text(text = team.name)
        }
    }
}
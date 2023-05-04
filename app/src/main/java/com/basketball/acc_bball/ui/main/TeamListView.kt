package com.basketball.acc_bball.ui.main

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import com.basketball.acc_bball.ui.TeamItem
import com.basketball.acc_bball.viewmodels.TeamViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamListView (
    viewModel: TeamViewModel,
    context: Context
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {

        coroutineScope.launch {
            viewModel.getTeams().collect {
                items(it) {team ->
                    TeamItem(team = team, viewModel)
                }
            }
        }

    }
}
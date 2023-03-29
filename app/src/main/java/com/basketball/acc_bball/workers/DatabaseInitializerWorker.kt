package com.basketball.acc_bball.workers

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.basketball.acc_bball.data.ACCDatabase
import com.basketball.acc_bball.data.entities.*
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader


class DatabaseInitializerWorker(
    context: Context,
    workerParams: WorkerParameters
): CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            populateTable("color.json")
            populateTable("state.json")
            populateTable("team.json")
            populateTable("player.json")
            Result.success()
        } catch (ex: Exception) {
            Log.e(TAG, "Error initializing database", ex)
            Result.failure()
        }
    }

    private fun populateTable(filename: String) {
        val database = ACCDatabase.getDatabase(applicationContext)
        applicationContext.assets.open(filename).use { inputStream ->
            JsonReader(inputStream.reader()).use { reader ->
                when(filename) {
                    "color.json" -> {
                        val tableType = object : TypeToken<List<Color>>() {}.type
                        val colorList: List<Color> = Gson().fromJson(reader, tableType)
                        database.colorDao().addAll(colorList)
                    }
                    "player.json" -> {
                        val tableType = object : TypeToken<List<Player>>() {}.type
                        val playerList: List<Player> = Gson().fromJson(reader, tableType)
                        database.playerDao().addAll(playerList)
                    }
                    "state.json" -> {
                        val tableType = object : TypeToken<List<State>>() {}.type
                        val stateList: List<State> = Gson().fromJson(reader, tableType)
                        database.stateDao().addAll(stateList)
                    }
                    "team.json"  -> {
                        val tableType = object : TypeToken<List<Team>>() {}.type
                        val teamList: List<Team> = Gson().fromJson(reader, tableType)
                        database.teamDao().addAll(teamList)
                    }
                }
            }
        }
    }
}
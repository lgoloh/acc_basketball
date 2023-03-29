package com.basketball.acc_bball.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.basketball.acc_bball.data.entities.State

@Dao
interface StateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(states: List<State>)

    @Query("SELECT * FROM state")
    fun getAll(): List<State>
}
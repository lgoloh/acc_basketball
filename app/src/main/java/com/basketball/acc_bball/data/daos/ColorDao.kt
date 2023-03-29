package com.basketball.acc_bball.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.basketball.acc_bball.data.entities.Color

@Dao
interface ColorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(colors: List<Color>)

    @Query("SELECT * FROM color")
    fun getAll(): List<Color>
}
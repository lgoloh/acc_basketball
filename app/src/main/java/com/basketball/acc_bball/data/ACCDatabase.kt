package com.basketball.acc_bball.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.basketball.acc_bball.data.daos.QueryDao
import com.basketball.acc_bball.data.daos.TeamDao
import com.basketball.acc_bball.data.entities.*
import com.basketball.acc_bball.utils.Constants

@Database(version = 1,
    entities = [Player::class, Team::class, State::class, Color::class],
    exportSchema = true)
abstract class ACCDatabase : RoomDatabase() {
    abstract fun teamDao() : TeamDao
    abstract fun queryDao(): QueryDao

    companion object {

        @Volatile //setting the database is visible in other threads
        private var acc_database: ACCDatabase? = null

        fun getDatabase(context: Context): ACCDatabase {
            return acc_database ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context): ACCDatabase {
            return Room.databaseBuilder(
                context, ACCDatabase::class.java, Constants.DB_NAME
            ).addCallback(
                //call back to pre-populate database after building
                object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                }
            ).build()
        }
    }
}

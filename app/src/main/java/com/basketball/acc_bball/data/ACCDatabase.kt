package com.basketball.acc_bball.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.basketball.acc_bball.data.daos.*
import com.basketball.acc_bball.data.entities.*
import com.basketball.acc_bball.utils.Constants
import com.basketball.acc_bball.workers.DatabaseInitializerWorker

@Database(version = 1,
    entities = [Player::class, Team::class, State::class, Color::class],
    exportSchema = false)
abstract class ACCDatabase : RoomDatabase() {
    abstract fun teamDao() : TeamDao
    abstract fun queryDao(): QueryDao
    abstract fun playerDao() : PlayerDao
    abstract fun stateDao() : StateDao
    abstract fun colorDao() : ColorDao

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
                        val request =
                            OneTimeWorkRequestBuilder<DatabaseInitializerWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                }
            ).build()
        }
    }
}

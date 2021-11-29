package com.example.busschedule.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.database.Schedule.Schedule

abstract class AppDatabase: RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao
    companion object {
    }
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_database")
                .createFromAsset("database/bus_schedule.db")
                .build()
            INSTANCE = instance

            instance

            @Database(entities = arrayOf(Schedule::class), version = 1)
        }
    }
}

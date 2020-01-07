package com.example.danshotspotapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.danshotspotapp.model.Event

@Database(entities = [Event::class], version = 1, exportSchema = false)
abstract class eventRoomDatabase : RoomDatabase(){

    abstract fun eventDao(): EventDao

    companion object {
        private const val DATABASE_NAME = "Event_database"

        @Volatile
        private var reminderRoomDatabaseInstance: eventRoomDatabase? = null

        fun getDatabase(context: Context): eventRoomDatabase? {
            if (reminderRoomDatabaseInstance == null) {
                synchronized(eventRoomDatabase::class.java) {
                    if (reminderRoomDatabaseInstance == null) {
                        reminderRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            eventRoomDatabase::class.java, DATABASE_NAME
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return reminderRoomDatabaseInstance
        }
    }


}
package com.example.danshotspotapp.database

import android.content.Context

public class EventRepository(context: Context) {

    private var eventDao: EventDao

    init {
        val eventRoomDatabase = eventRoomDatabase.getDatabase(context)
        eventDao = eventRoomDatabase!!.eventDao()
    }

    fun getAllEvents(): List<Event> {
        return eventDao.getAllEvents()
    }

    fun insertEvent(reminder: Event) {
        eventDao.insertEvent(reminder)
    }

    fun delteEvent(reminder: Event) {
        eventDao.delteEvent(reminder)
    }

    fun updateEvent(reminder: Event) {
        eventDao.updateEvent(reminder)
    }

}

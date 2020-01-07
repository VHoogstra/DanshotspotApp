package com.example.danshotspotapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.danshotspotapp.database.EventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EventActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val eventRepository = EventRepository(application.applicationContext)

    val events: LiveData<List<Event>> = eventRepository.getAllEvents()
    fun insertEvent(event: Event) {
        ioScope.launch {
            eventRepository.insertEvent(event)
        }
    }

    fun deleteEvent(event: Event) {
        ioScope.launch {
            eventRepository.delteEvent(event)
        }
    }

    fun updateFromDHS(DhsEvents: List<Event>) {
        eventRepository.deleteAll()
        for(event in DhsEvents){
            this.insertEvent(event)
        }

    }
}

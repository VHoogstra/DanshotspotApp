package com.example.danshotspotapp.model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.danshotspotapp.api.DansRepository
import com.example.danshotspotapp.database.EventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

    fun updateFromDHS() {
        val apiInterface = DansRepository()
        val call = apiInterface.getAllEvents()
        this.onResponse(call)

    }

    private fun onResponse(response: Call<ApiResponseEvents>) {
        response.enqueue(object : Callback<ApiResponseEvents> {
            override fun onResponse(
                call: Call<ApiResponseEvents>,
                response: Response<ApiResponseEvents>
            ) {
                if (response.isSuccessful) {
                    eventRepository.deleteAll()
                    for (event in response.body()!!.data) {
                        this@EventActivityViewModel.insertEvent(event)
                    }
                } else {

                }
            }

            override fun onFailure(call: Call<ApiResponseEvents>, t: Throwable) {

            }
        })
    }
}

package com.example.danshotspotapp.api

class DansRepository {
    private val dhsApi: DanshotspotApiService = DanshotspotApi.createApi()

    fun getAllEvents() = dhsApi.getAllEvents()
    fun getAllTodo() = dhsApi.getAllTodo()
    fun getEvent() = dhsApi.getEvent()
}

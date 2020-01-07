package com.example.danshotspotapp.api

import com.example.danshotspotapp.model.ApiResponseEvent
import com.example.danshotspotapp.model.ApiResponseEvents
import com.example.danshotspotapp.model.Event
import retrofit2.Call
import retrofit2.http.GET

public interface DanshotspotApiService {
    // The GET method needed to retrieve a random number trivia.
    @GET("/api/event/all?api_token=sdfsdfsdfsdf")
    fun getAllEvents(): Call<ApiResponseEvents>

    @GET("/todo/all")
    fun getAllTodo():  Call<ApiResponseEvents>

    @GET("event/get?api_token=sdfsdfsdfsdf")
    fun getEvent(): Call<ApiResponseEvent>
}

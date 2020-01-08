package com.example.danshotspotapp.api

import retrofit2.Call
import retrofit2.http.GET

public interface DanshotspotApiService {
    // The GET method needed to retrieve a random number trivia.
    @GET("/api/event/all?api_token=sdfsdfsdfsdf")
    fun getAllEvents(): Call<ApiResponseEvents>

    @GET("/api/todo/all?api_token=sdfsdfsdfsdf")
    fun getAllTodo():  Call<ApiResponseTodos>

    @GET("event/get?api_token=sdfsdfsdfsdf")
    fun getEvent(): Call<ApiResponseEvent>
}

package com.example.danshotspotapp.model


import com.google.gson.annotations.SerializedName

data class ApiResponseEvents(@SerializedName("data") var data: List<Event>)
data class ApiResponseEvent(@SerializedName("data") var data: Event)
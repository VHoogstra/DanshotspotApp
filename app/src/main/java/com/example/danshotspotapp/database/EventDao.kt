package com.example.danshotspotapp.database

import androidx.room.*

@Dao
interface EventDao {

    @Query("SELECT * FROM eventTable")
    fun getAllEvents(): List<Event>

    @Insert
    fun insertEvent(event: Event)

    @Delete
    fun delteEvent(event: Event)

    @Update
    fun updateEvent(event: Event)

}

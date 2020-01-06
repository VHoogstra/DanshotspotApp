package com.example.danshotspotapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EventDao {

    @Query("SELECT * FROM eventTable order by date")
    fun getAllEvents(): LiveData<List<Event>>

    @Insert
    fun insertEvent(event: Event)

    @Delete
    fun delteEvent(event: Event)

    @Update
    fun updateEvent(event: Event)

}

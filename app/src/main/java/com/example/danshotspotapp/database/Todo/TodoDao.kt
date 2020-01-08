package com.example.danshotspotapp.database.Todo


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo order by date")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert
    fun insertTodo(todo: Todo)

    @Delete
    fun delteTodo(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Query("DELETE FROM todo where 1")
    fun deleteAll()

}

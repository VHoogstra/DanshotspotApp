package com.example.danshotspotapp.database.Todo

import android.content.Context
import androidx.lifecycle.LiveData

public class TodoRepository(context: Context) {

    private var todoDao: TodoDao

    init {
        val todoDatabase =
            TodoDatabase.getDatabase(context)
        todoDao = todoDatabase!!.todoDao()
    }

    fun getAllTodo(): LiveData<List<Todo>> {
        return todoDao.getAllTodo()
    }

    fun insertTodo(todo: Todo) {
        return todoDao.insertTodo(todo)
    }

    fun updateTodo(todo: Todo) {
        todoDao.updateTodo(todo)
    }

    fun deleteAll() {
        todoDao.deleteAll()
    }
}

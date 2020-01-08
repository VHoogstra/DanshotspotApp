package com.example.danshotspotapp.model

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.danshotspotapp.api.ApiResponseTodos
import com.example.danshotspotapp.api.DansRepository
import com.example.danshotspotapp.database.Todo.Todo
import com.example.danshotspotapp.database.Todo.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val todoRepository =
        TodoRepository(application.applicationContext)

    val todos: LiveData<List<Todo>> = todoRepository.getAllTodo()

    fun insertTodo(todo: Todo) {
        ioScope.launch {
            todoRepository.insertTodo(todo)
        }
    }

    fun updateTodo(todo: Todo) {
        ioScope.launch {
            todoRepository.updateTodo(todo)
        }

    }

    fun deleteAll() {
        ioScope.launch {
            todoRepository.deleteAll()
        }
    }

    fun updateFromDHS() {
        val apiInterface = DansRepository()
        val call = apiInterface.getAllTodo()
        this.onResponse(call)

    }

    private fun onResponse(response: Call<ApiResponseTodos>) {
        response.enqueue(object : Callback<ApiResponseTodos> {
            override fun onResponse(
                call: Call<ApiResponseTodos>,
                response: Response<ApiResponseTodos>
            ) {
                if (response.isSuccessful) {
                    this@TodoViewModel.deleteAll()
                    for (todo in response.body()!!.data) {
                        this@TodoViewModel.insertTodo(todo)
                    }
                    println("done inserting todo")
//todo stop spinner
                } else {
                    println("failed")

                }
            }

            override fun onFailure(call: Call<ApiResponseTodos>, t: Throwable) {
                println("how u get here..")
            }
        })
    }
}

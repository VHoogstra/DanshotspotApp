package com.example.danshotspotapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.danshotspotapp.R
import com.example.danshotspotapp.Util
import com.example.danshotspotapp.database.Event.Event
import com.example.danshotspotapp.database.Todo.Todo
import kotlinx.android.synthetic.main.event_item.view.*


class TodoAdapter(private val Todos: List<Todo>, private val onClick: (Todo) -> Unit) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Todos[position])
    }


    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.event_item,
                parent,
                false
            )
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return Todos.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val context = itemView.context
        init {
            itemView.setOnClickListener { onClick(Todos[adapterPosition]) }
        }
        fun bind(event: Todo) {
            itemView.tvDateShow.text = event.title
            itemView.tvEvent.text = Util.getDate(event.date, "d-M-Y kk:mm")
            itemView.tvTodo.text = "111"
        }
    }
}
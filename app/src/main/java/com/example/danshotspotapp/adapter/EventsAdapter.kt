package com.example.danshotspotapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.danshotspotapp.R
import com.example.danshotspotapp.Util
import com.example.danshotspotapp.model.Event
import com.example.danshotspotapp.ui.EventShowActivity
import kotlinx.android.synthetic.main.event_item.view.*
import android.app.Activity
import com.example.danshotspotapp.ui.EVENT_OBJECT


class EventsAdapter(private val Events: List<Event>) :
    RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Events[position])
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
        return Events.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val context = itemView.context
        fun bind(event: Event) {
            itemView.setOnClickListener {
                val activity = context as Activity
                val showIntent = Intent(context, EventShowActivity::class.java)
                showIntent.putExtra(EVENT_OBJECT,event)
                activity.startActivity(showIntent)
                activity.overridePendingTransition(
                    R.anim.slidedown,
                    R.anim.fadeout
                )
            }
            itemView.tvDateShow.text = event.title
            itemView.tvEvent.text = Util.getDate(event.date, "d-M-Y kk:mm")
            itemView.tvTodo.text = "111"
        }
    }
}
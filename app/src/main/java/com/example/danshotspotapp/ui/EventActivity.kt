package com.example.danshotspotapp.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.danshotspotapp.R
import com.example.danshotspotapp.adapter.EventsAdapter
import com.example.danshotspotapp.database.Event
import com.example.danshotspotapp.database.EventRepository
import kotlinx.android.synthetic.main.activity_event_create.*
import kotlinx.android.synthetic.main.activity_events.*
import kotlinx.android.synthetic.main.activity_events.menu_todo

//import kotlinx.android.synthetic.main.oldactivity_event.*
const val GET_NEW_EVENT = 300

class EventActivity : AppCompatActivity() {
    private val events = arrayListOf<Event>()
    private val eventAdapter = EventsAdapter(events)
    private lateinit var eventRepository: EventRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        eventRepository = EventRepository(this)
        supportActionBar?.title = "event view"

        fab.setOnClickListener { view ->
            val intent = Intent(this, EventCreateActivity::class.java)
            startActivityForResult(intent, GET_NEW_EVENT)

            overridePendingTransition(
                R.anim.fadein,
                R.anim.fadeout
            )

//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
        }

        menu_todo.setOnClickListener {
            val intent = Intent(this, TodoActivity::class.java)
            startActivity(intent)
            overridePendingTransition(
                R.anim.slideright,
                R.anim.fadeout
            )
            finish()
        }
        initViews()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_open_settings -> {
                val profileActivityIntent = Intent(this, SettingsActivity::class.java)
                startActivity(profileActivityIntent)
                overridePendingTransition(
                    R.anim.slidedown,
                    R.anim.fadeout
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                GET_NEW_EVENT -> {
                    val event = data!!.getParcelableExtra<Event>(EVENT_OBJECT)
                    eventRepository.insertEvent(event)
                    getEventsFromDatabase()

                }
            }
        }
    }

    private fun initViews() {

        // Initialize the recycler view with a linear layout manager, adapter
        rvEvent.layoutManager =
            LinearLayoutManager(this@EventActivity, RecyclerView.VERTICAL, false)
        rvEvent.adapter = eventAdapter
        rvEvent.addItemDecoration(
            DividerItemDecoration(
                this@EventActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        createItemTouchHelper().attachToRecyclerView(rvEvent)
        getEventsFromDatabase()

    }
    private fun getEventsFromDatabase() {
        val events = eventRepository.getAllEvents()
        this@EventActivity.events.clear()
        this@EventActivity.events.addAll(events)
        eventAdapter.notifyDataSetChanged()
    }

    /**
     * Create a touch helper to recognize when a user swipes an item from a recycler view.
     * An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
     * and uses callbacks to signal when a user is performing these actions.
     */
    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val position = viewHolder.adapterPosition
//                reminders.removeAt(position)
//                reminderAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }

}

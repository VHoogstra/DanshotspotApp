package com.example.danshotspotapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_event.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_event.menu_event
import kotlinx.android.synthetic.main.activity_event.menu_todo
import kotlinx.android.synthetic.main.activity_main.*

//import kotlinx.android.synthetic.main.oldactivity_event.*

class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        supportActionBar?.title =  "event view"

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        menu_todo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slideright, R.anim.fadeout)
            finish()
        }
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
                overridePendingTransition(R.anim.slidedown, R.anim.fadeout)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

}

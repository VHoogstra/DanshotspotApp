package com.example.danshotspotapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.danshotspotapp.R
import com.example.danshotspotapp.Util
import com.example.danshotspotapp.model.Event
import kotlinx.android.synthetic.main.activity_event_show.*


class EventShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_show)
        val event  = intent.getParcelableExtra<Event>(EVENT_OBJECT)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        tvTitle.setText(getString(R.string.title) + ": "+ event.title)
        tvLocation.setText(getString(R.string.location) + ": "+ event.location)
        tvTodo.setText("323sdf")
        tvDateShow.setText(Util.getDate(event.date.toLong(),"d-M-Y kk:mm"))
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
            android.R.id.home -> {
                finish()
                overridePendingTransition(
                    R.anim.fadein,
                    R.anim.slideup
                )

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

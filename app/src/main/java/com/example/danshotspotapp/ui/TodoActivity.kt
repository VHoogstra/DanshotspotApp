package com.example.danshotspotapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import com.example.danshotspotapp.R
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        menu_event.setOnClickListener {
            val intent = Intent(this, EventActivity::class.java)
            startActivity(intent)
            overridePendingTransition(
                R.anim.slideleft,
                R.anim.fadeout
            )
            finish()
        }
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this /* Activity context */)
        val name = sharedPreferences.getString("username", "test")
        menu_event.setText(name)
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

}

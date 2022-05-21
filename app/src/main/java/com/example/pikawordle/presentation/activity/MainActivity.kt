package com.example.pikawordle.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.pikawordle.R
import com.example.pikawordle.presentation.MainViewModel
import com.example.pikawordle.presentation.UsersListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonHS = findViewById<ImageButton>(R.id.high_score_button)
        buttonHS.setOnClickListener {
            val intent = UserActivity.newIntent(this)
            startActivity(intent)
        }
        val buttonGame = findViewById<ImageButton>(R.id.new_game_button)
        buttonGame.setOnClickListener {
            val intent = GameActivity.newIntent(this)
            startActivity(intent)
        }
        val buttonSettings = findViewById<ImageButton>(R.id.settings_button)
        buttonSettings.setOnClickListener {
            val intent = SettingsActivity.newIntent(this)
            startActivity(intent)
        }
    }


}
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

        val buttonAdd = findViewById<ImageButton>(R.id.high_score_button)
        buttonAdd.setOnClickListener {
            val intent = UserActivity.newIntent(this)
            startActivity(intent)
        }
    }


}
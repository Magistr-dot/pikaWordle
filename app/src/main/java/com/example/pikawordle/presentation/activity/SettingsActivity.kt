package com.example.pikawordle.presentation.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.pikawordle.R
import com.example.pikawordle.presentation.MainViewModel
import com.example.pikawordle.presentation.UsersListAdapter

class SettingsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

    }

    companion object {
        private const val EXTRA_MODE = "extra_mode"
        private const val DATA_BASE = "server"

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, SettingsActivity::class.java)
            intent.putExtra(EXTRA_MODE, DATA_BASE)
            return intent
        }
    }

}
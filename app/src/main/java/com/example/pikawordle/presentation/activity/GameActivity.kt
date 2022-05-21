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

class GameActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        println(viewModel.word.name)
    }

    companion object {
        private const val EXTRA_MODE = "extra_mode"
        private const val NEW_GAME = true

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, GameActivity::class.java)
            intent.putExtra(EXTRA_MODE, NEW_GAME)
            return intent
        }

    }
}
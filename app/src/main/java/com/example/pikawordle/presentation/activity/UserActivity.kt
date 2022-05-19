package com.example.pikawordle.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.pikawordle.R
import com.example.pikawordle.presentation.MainViewModel
import com.example.pikawordle.presentation.UsersListAdapter

class UserActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var usersListAdapter: UsersListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_high_score)
        setupRecycler()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        usersListAdapter.submitList(viewModel.list)
    }

    private fun setupRecycler() {
        val rvUsersList = findViewById<RecyclerView>(R.id.users_list)

        with(rvUsersList) {
            usersListAdapter = UsersListAdapter()
            adapter = usersListAdapter
        }
    }
    companion object {
        private const val EXTRA_MODE = "extra_mode"
        private const val LANGUAGE = "RU"

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, UserActivity::class.java)
            intent.putExtra(EXTRA_MODE, LANGUAGE)
            return intent
        }
    }
}
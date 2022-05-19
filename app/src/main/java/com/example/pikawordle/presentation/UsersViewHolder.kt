package com.example.pikawordle.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pikawordle.R


class UsersViewHolder {
    class UsersViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.nameText)
        val place: TextView = view.findViewById(R.id.placeText)
        val score: TextView = view.findViewById(R.id.scoreText)
    }
}
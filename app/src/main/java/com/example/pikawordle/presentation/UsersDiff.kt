package com.example.pikawordle.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.pikawordle.domain.users.Users

class UsersDiff : DiffUtil.ItemCallback<Users>() {
    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }

}
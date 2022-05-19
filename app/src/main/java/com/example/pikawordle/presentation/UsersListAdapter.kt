package com.example.pikawordle.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pikawordle.R
import com.example.pikawordle.domain.users.Users


class UsersListAdapter :
    ListAdapter<Users, UsersViewHolder.UsersViewHolder>(UsersDiff()) {

    var onShopItemLongClickListener: ((Users) -> Unit)? = null
    var onShopItemShortClickListener: ((Users) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersViewHolder.UsersViewHolder {
        return when (viewType) {
            ACTIVE -> {
                UsersViewHolder.UsersViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.user_item,
                        parent,
                        false
                    )
                )
            }
            else -> throw Exception("$viewType")
        }
    }

    override fun onBindViewHolder(holder: UsersViewHolder.UsersViewHolder, position: Int) {
        val user = getItem(position)
        holder.name.text = user.name
        holder.place.text = user.place.toString()
        holder.score.text = user.score.toString()
        holder.view.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(user)
            true
        }
        holder.view.setOnClickListener {
            onShopItemShortClickListener?.invoke(user)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).score.isFinite()) {
            true -> ACTIVE
            else -> NOT_ACTIVE
        }
    }

    companion object {
        const val ACTIVE = 101
        const val NOT_ACTIVE = 100
    }
}

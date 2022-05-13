package com.example.pikawordle.data

import com.example.pikawordle.domain.users.Users
import com.example.pikawordle.domain.users.UsersRepo

object UsersRepoImpl : UsersRepo {

    private var usersList = mutableListOf<Users>()

    init {
        for ((c, i) in ('a'..'t').withIndex()) {
            val item = Users("",c,"cкeт$i", c.toDouble(),c)
            usersList.add(item)
        }
    }

    override fun getUsers(id: Int): List<Users> {
        usersList.sortBy { it.place  }
        return usersList
    }

    override fun pushUser(user: Users) {
        usersList.forEach { if(it.id==user.id) {it.score = user.score} else {
            usersList.add(user)} }
    }
}
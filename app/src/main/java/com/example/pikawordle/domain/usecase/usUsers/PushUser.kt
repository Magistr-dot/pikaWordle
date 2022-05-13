package com.example.pikawordle.domain.usecase.usUsers

import com.example.pikawordle.domain.users.Users
import com.example.pikawordle.domain.users.UsersRepo

class PushUser(private val usersRepo: UsersRepo) {
    fun pushUser(user: Users) {
        return usersRepo.pushUser(user)
    }
}
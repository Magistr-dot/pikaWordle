package com.example.pikawordle.domain.usecase.usUsers

import com.example.pikawordle.domain.users.Users
import com.example.pikawordle.domain.users.UsersRepo

class GetUsers(private val usersRepo: UsersRepo) {
    fun getUsers(id:Int): List<Users> {
        return usersRepo.getUsers(id)
    }
}
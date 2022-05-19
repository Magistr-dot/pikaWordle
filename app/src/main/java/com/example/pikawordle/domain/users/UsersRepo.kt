package com.example.pikawordle.domain.users

interface UsersRepo {
    fun getUsers(id: Int): List<Users> {
        TODO()
    }

    fun pushUser (user: Users){
        TODO()
    }
}
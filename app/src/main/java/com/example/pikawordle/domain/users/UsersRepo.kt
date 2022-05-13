package com.example.pikawordle.domain.users

import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.word.Word

interface UsersRepo {
    fun getUsers(id: Int): List<Users> {
        TODO()
    }

    fun pushUser (user: Users){
        TODO()
    }
}
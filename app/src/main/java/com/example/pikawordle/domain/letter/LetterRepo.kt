package com.example.pikawordle.domain.letter

import com.example.pikawordle.domain.enum.MyColor

interface LetterRepo {
    fun addLetter(letter: Letter) {
        TODO()
    }

    fun deleteLetter(letter: Letter) {
        TODO()
    }
    fun getLetter():List<Letter> {
        TODO()
    }
    fun checkLetter(id: Int, color: MyColor):Letter {
        TODO()
    }
    fun getScreenLetter():MutableList<Letter> {
        TODO()
    }
}
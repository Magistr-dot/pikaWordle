package com.example.pikawordle.domain.letter

import com.example.pikawordle.domain.enum.MyColor

interface LetterRepo {
    fun addLetter(list: List<Letter>, letter: Char, list1: MutableList<Letter>) {
        TODO()
    }

    fun deleteLetter(letter: Letter) {
        TODO()
    }

    fun getLetter(): List<Letter> {
        TODO()
    }

    fun checkLetter(id: Int, color: MyColor): Letter {
        TODO()
    }

    fun getScreenLetter(): MutableList<Letter> {
        TODO()
    }

    fun letterInList(list: List<Letter>, letter: Char): Letter? {
        TODO()
    }
}
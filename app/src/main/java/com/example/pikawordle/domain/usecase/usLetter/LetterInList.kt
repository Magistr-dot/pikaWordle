package com.example.pikawordle.domain.usecase.usLetter

import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

class LetterInList(private val letterRepo: LetterRepo) {
    fun letterInList(list: List<Letter>, letter: Char): Letter? {
        return letterRepo.letterInList(list, letter)
    }
}
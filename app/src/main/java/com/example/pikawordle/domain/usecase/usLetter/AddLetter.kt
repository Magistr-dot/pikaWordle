package com.example.pikawordle.domain.usecase.usLetter

import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

class AddLetter(private val letterRepo: LetterRepo) {
    fun addLetter(letter: Letter) {
        letterRepo.addLetter(letter)
    }
}
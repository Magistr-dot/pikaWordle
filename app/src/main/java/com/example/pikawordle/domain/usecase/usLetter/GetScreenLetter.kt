package com.example.pikawordle.domain.usecase.usLetter

import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

class GetScreenLetter(private val letterRepo: LetterRepo) {
    fun getScreenLetter() : MutableList<Letter> {
        return letterRepo.getScreenLetter()
    }
}
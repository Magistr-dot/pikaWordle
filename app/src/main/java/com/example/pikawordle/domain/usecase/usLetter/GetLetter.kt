package com.example.pikawordle.domain.usecase.usLetter

import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

class GetLetter(private val letterRepo: LetterRepo) {
    fun getLetter() : List<Letter> {
        return letterRepo.getLetter()
    }
}
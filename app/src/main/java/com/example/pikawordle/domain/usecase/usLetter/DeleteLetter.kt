package com.example.pikawordle.domain.usecase.usLetter

import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

class DeleteLetter(private val letterRepo: LetterRepo) {
    fun deleteLetter(letter: Letter) {
        letterRepo.deleteLetter(letter)
    }
}
package com.example.pikawordle.domain.usecase

import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

class CheckLetter(private val letterRepo: LetterRepo) {
    fun checkLetter(letter: Letter, color: MyColor) :Letter {
        return letterRepo.checkLetter(letter, color)
    }
}
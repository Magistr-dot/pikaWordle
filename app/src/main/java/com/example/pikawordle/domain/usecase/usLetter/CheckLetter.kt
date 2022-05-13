package com.example.pikawordle.domain.usecase.usLetter

import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

class CheckLetter(private val letterRepo: LetterRepo) {
    fun checkLetter(id: Int, color: MyColor) :Letter {
        return letterRepo.checkLetter(id, color)
    }
}
package com.example.pikawordle.domain.usecase

import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.domain.word.WordRepo

class CheckWord(private val wordRepo: WordRepo) {
    fun checkWord(word: Word) {
        wordRepo.checkWord(word)
    }
}
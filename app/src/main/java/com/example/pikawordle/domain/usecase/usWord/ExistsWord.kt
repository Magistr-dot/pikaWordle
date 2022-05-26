package com.example.pikawordle.domain.usecase.usWord

import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.domain.word.WordRepo

class ExistsWord(private val wordRepo: WordRepo) {
    fun existsWord(word: Word): Boolean {
        return wordRepo.existsWord(word)
    }
}
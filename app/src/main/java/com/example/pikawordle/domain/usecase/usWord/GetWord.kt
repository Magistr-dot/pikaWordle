package com.example.pikawordle.domain.usecase.usWord

import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.domain.word.WordRepo

class GetWord(private val wordRepo: WordRepo) {
    fun getWord(): Word {
        return wordRepo.getWord()
    }
}
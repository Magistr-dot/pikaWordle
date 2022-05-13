package com.example.pikawordle.domain.usecase.usWord

import com.example.pikawordle.domain.word.*


class AddWord(private val wordRepo: WordRepo) {
    fun addWord(word: Word) {
        wordRepo.addWord(word)
    }
}
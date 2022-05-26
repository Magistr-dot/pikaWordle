package com.example.pikawordle.domain.usecase.usWord

import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.domain.word.WordRepo

class CheckWord(private val wordRepo: WordRepo) {
    fun checkWord(word: Word, list: MutableList<Letter>) : MutableList<Letter>{
        return wordRepo.checkWord(word, list)
    }
}
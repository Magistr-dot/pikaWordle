package com.example.pikawordle.domain.word

import androidx.lifecycle.LiveData


interface WordRepo {
    fun checkWord(word: Word) {
        TODO()
    }

    fun getWord(): LiveData<Word> {
        TODO()
    }

    fun addWord (word: Word){
        TODO()
    }
}
package com.example.pikawordle.domain.word

import androidx.lifecycle.LiveData
import com.example.pikawordle.domain.letter.Letter


interface WordRepo {
    fun checkWord(word: Word, list: MutableList<Letter>) {
        TODO()
    }

    fun getWord(): Word {
        TODO()
    }

    fun addWord (word: Word){
        TODO()
    }
}
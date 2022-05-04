package com.example.pikawordle.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pikawordle.domain.enum.MyLanguage
import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.domain.word.WordRepo

object WordRepoImpl : WordRepo {

    private var autoID = 0
    private val wordList = mutableListOf<Word>()
    private var shopListLD = MutableLiveData <List<Word>>()

    init {
        for (i in 0 until 10) {
            val item = Word(MyLanguage.ru, i)
            addWord(item)
        }
    }

    override fun checkWord(word: Word) {
        super.checkWord(word)
    }

    override fun getWord(): LiveData<Word> {
        return super.getWord()
    }

    override fun addWord(word: Word) {
        if (word.id == Word.UNDEFINED_ID) {
            word.id = autoID++
        }
        wordList.add(word)
        updateList()
    }
    private fun updateList() {
        shopListLD.value = wordList.toList()
    }
}
package com.example.pikawordle.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.enum.MyLanguage
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.domain.word.WordRepo
import kotlin.random.Random

object WordRepoImpl : WordRepo {

    private var autoID = 0
    private val wordList = mutableListOf<Word>()
    //private var shopListLD = MutableLiveData <List<Word>>()

    init {
        for ((c, i) in ('a'..'f').withIndex()) {
            val item = Word("cкeт$i", id = c)
            addWord(item)
        }

    }

    override fun checkWord(word: Word, list: MutableList<Letter>) {

        for ((c, i) in (list).withIndex()) {
            if (word.name.contains(i.oneLetter) && word.name[c] == i.oneLetter) {
                //think
                LetterRuRepoImpl.checkLetter(i.id, MyColor.green)

            } else if (word.name.contains(i.oneLetter)) {
                LetterRuRepoImpl.checkLetter(i.id, MyColor.yelow)
            } else LetterRuRepoImpl.checkLetter(i.id, MyColor.black)
        }
    }

    override fun getWord(): Word {
        println(wordList)
        return wordList.random(Random(10))
    }

    override fun addWord(word: Word) {
        println(wordList)
        wordList.add(word)
    }


}
package com.example.pikawordle.data

import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.domain.word.WordRepo
import kotlin.random.Random

object WordRepoImpl : WordRepo {

    private val wordList = mutableListOf<Word>()
    //private var shopListLD = MutableLiveData <List<Word>>()

    init {
//        for ((c, i) in ('a'..'f').withIndex()) {
//            val item = Word("cкeт$i", id = c)
//            addWord(item)
//        }
        addWord(Word("clean",id = 1))
        addWord(Word("house",id = 2))
        addWord(Word("brick",id = 3))

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
        return wordList.random(Random(10))
    }

    override fun addWord(word: Word) {
        wordList.add(word)
    }


}
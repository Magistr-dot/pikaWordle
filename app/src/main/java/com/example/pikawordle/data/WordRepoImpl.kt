package com.example.pikawordle.data

import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.word.Word
import com.example.pikawordle.domain.word.WordRepo
import kotlin.random.Random

object WordRepoImpl : WordRepo {

    private val wordList = mutableListOf<Word>()


    init {

        addWord(Word("clean", id = 1))
        addWord(Word("house", id = 2))
        addWord(Word("brick", id = 3))

    }

    override fun checkWord(word: Word, list: MutableList<Letter>): MutableList<Letter> {
        val newList = mutableListOf<Letter>()
        for ((c, i) in (list).withIndex()) {
            if (word.name.contains(i.oneLetter) && word.name[c] == i.oneLetter) {
                //think
                newList.add(LetterRuRepoImpl.checkLetter(i.id, MyColor.green))
            } else if (word.name.contains(i.oneLetter)) {
                newList.add(LetterRuRepoImpl.checkLetter(i.id, MyColor.yelow))
            } else newList.add(LetterRuRepoImpl.checkLetter(i.id, MyColor.black))
        }
        return newList
    }

    override fun existsWord(word: Word): Boolean {
        return true
    }

    override fun getWord(): Word {
        return wordList.random(Random(10))
    }

    override fun addWord(word: Word) {
        wordList.add(word)
    }


}
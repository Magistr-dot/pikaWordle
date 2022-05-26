package com.example.pikawordle.data

import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

object LetterRuRepoImpl : LetterRepo {

    private const val MAX_SIZE_SCREEN_LETTER = 4
    private var letterList = mutableListOf<Letter>()
    private var letterScreenList = mutableListOf<Letter>()
    // private var LetterListLD = MutableLiveData<List<Letter>>()

    init {
        for ((c, i) in ('a'..'z').withIndex()) {
            val letter = Letter(i, id = c)
            letterList.add(letter)
        }
    }

    override fun addLetter(list: List<Letter>, letter: Char, list1: MutableList<Letter>) {
        if (list1.size <= MAX_SIZE_SCREEN_LETTER) {
            println("stage1")
            letterInList(list, letter)?.let { list1.add(it) }
        } else println("error")
    }

    override fun letterInList(list: List<Letter>, letter: Char): Letter? {

        list.forEach {
            if (it.oneLetter == letter) {
                return it
            }
        }
        return null

    }

    override fun deleteLetter(letter: Letter) {
        if (letterScreenList.size > 0) {
            letterScreenList.remove(letter)
        }
    }

    override fun getLetter(): List<Letter> {
        return letterList
    }

    override fun getScreenLetter(): MutableList<Letter> {
        return letterScreenList
    }

    override fun checkLetter(id: Int, color: MyColor): Letter {
        val oldLetter = letterList[id]
        letterList.remove(oldLetter)
        val newLetter = Letter(oldLetter.oneLetter, oldLetter.language, color, oldLetter.id)
        letterList.add(newLetter.id, newLetter)

        return newLetter
    }
}
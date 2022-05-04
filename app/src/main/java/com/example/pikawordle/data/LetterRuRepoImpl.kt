package com.example.pikawordle.data

import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.letter.LetterRepo

object LetterRuRepoImpl : LetterRepo {


    private var letterList = mutableListOf<Letter>()
    private var letterScreenList = mutableListOf<Letter>()
   // private var LetterListLD = MutableLiveData<List<Letter>>()

    init {
        for ((c, i) in ('а'..'я').withIndex()) {
            val letter = Letter(i, id = c)
            letterList.add(letter)
        }
    }


    override fun addLetter(letter: Letter) {
        letterScreenList.add(letter)
        updateList()
    }

    override fun deleteLetter(letter: Letter) {
        letterScreenList.remove(letter)
       // updateList()
    }

    override fun getLetter(): List<Letter> {
        return letterList
    }

    override fun checkLetter(letter: Letter, color: MyColor): Letter {
        println(letterList)
        letterList.remove(letter)
        val newLetter = Letter(letter.oneLetter,letter.language, color, letter.id)

        letterList.add(letter.id,newLetter)
        println("new-$newLetter")
        println(letterList)
        letterList = letterList.toMutableList()
        return newLetter
    }
    private fun updateList() {
        letterList = letterList.toMutableList()
        letterScreenList = letterScreenList.toMutableList()
    }
}
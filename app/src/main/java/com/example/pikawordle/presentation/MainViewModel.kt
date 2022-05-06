package com.example.pikawordle.presentation

import androidx.lifecycle.ViewModel
import com.example.pikawordle.data.LetterRuRepoImpl
import com.example.pikawordle.data.LetterRuRepoImpl.getLetter
import com.example.pikawordle.data.WordRepoImpl
import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.usecase.*
import com.example.pikawordle.domain.word.Word

class MainViewModel :ViewModel(){
    private val repository = LetterRuRepoImpl

    private val getLetter = GetLetter(repository)
    private val deleteLetter = DeleteLetter(repository)
    private val addLetter = AddLetter(repository)
    private val getScreenLetter = GetScreenLetter(repository)
    private val checkLetter = CheckLetter(repository)

    val letterList = getLetter.getLetter()
    val letterScreenList = getScreenLetter.getScreenLetter()


    fun deleteLetter(item: Letter) {
        deleteLetter.deleteLetter(item)
    }
    fun checkLetter(id: Int, color: MyColor) {
        checkLetter.checkLetter(id, color)
    }
    fun addLetter(item: Letter) {
        addLetter.addLetter(item)
    }
    ////
    private val repositoryWord = WordRepoImpl
    private val getWord = GetWord(repositoryWord)
    private val addWord = AddWord(repositoryWord)
    private val checkWord = CheckWord(repositoryWord)

    val word = getWord.getWord()

    fun addWord(item: Word) {
        addWord.addWord(item)
    }

    fun checkWord(item: Word, list: MutableList<Letter>){
        checkWord.checkWord(item, list)
    }

}
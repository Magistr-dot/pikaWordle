package com.example.pikawordle.presentation

import androidx.lifecycle.ViewModel
import com.example.pikawordle.data.LetterRuRepoImpl
import com.example.pikawordle.data.LetterRuRepoImpl.getLetter
import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.usecase.AddLetter
import com.example.pikawordle.domain.usecase.CheckLetter
import com.example.pikawordle.domain.usecase.DeleteLetter
import com.example.pikawordle.domain.usecase.GetLetter

class MainViewModel :ViewModel(){
    private val repository = LetterRuRepoImpl

    private val getLetter = GetLetter(repository)

    private val deleteLetter = DeleteLetter(repository)
    private val addLetter = AddLetter(repository)
    private val checkLetter = CheckLetter(repository)

    val letterList = getLetter.getLetter()


    fun deleteLetter(item: Letter) {
        deleteLetter.deleteLetter(item)
    }
    fun checkLetter(item: Letter, color: MyColor) {
        checkLetter.checkLetter(item, color)
    }
    fun addLetter(item: Letter) {
        addLetter.addLetter(item)
    }
}
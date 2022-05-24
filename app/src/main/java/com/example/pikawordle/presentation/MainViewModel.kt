package com.example.pikawordle.presentation

import androidx.lifecycle.ViewModel
import com.example.pikawordle.data.LetterRuRepoImpl
import com.example.pikawordle.data.UsersRepoImpl
import com.example.pikawordle.data.WordRepoImpl
import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.letter.Letter
import com.example.pikawordle.domain.usecase.usLetter.*
import com.example.pikawordle.domain.usecase.usUsers.GetUsers
import com.example.pikawordle.domain.usecase.usUsers.PushUser
import com.example.pikawordle.domain.usecase.usWord.AddWord
import com.example.pikawordle.domain.usecase.usWord.CheckWord
import com.example.pikawordle.domain.usecase.usWord.GetWord
import com.example.pikawordle.domain.users.Users
import com.example.pikawordle.domain.word.Word

class MainViewModel :ViewModel(){
    private val repository = LetterRuRepoImpl

    private val getLetter = GetLetter(repository)
    private val deleteLetter = DeleteLetter(repository)
    private val addLetter = AddLetter(repository)
    private val getScreenLetter = GetScreenLetter(repository)
    private val checkLetter = CheckLetter(repository)
    private val letterInList = LetterInList(repository)

    val letterList = getLetter.getLetter()
    val letterScreenList = getScreenLetter.getScreenLetter()


    fun deleteLetter(item: Letter) {
        deleteLetter.deleteLetter(item)
    }
    fun checkLetter(id: Int, color: MyColor) {
        checkLetter.checkLetter(id, color)
    }
    fun addLetter(item: Char ) {
        addLetter.addLetter(letterList, item, letterScreenList)
    }
    fun letterInList(letter: Char): Letter? {
        return letterInList.letterInList(letterList, letter)
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
    //////
    private val repositoryUsers = UsersRepoImpl
    private val pushUser = PushUser(repositoryUsers)
    private val getUsers = GetUsers(repositoryUsers)

    val list = getUsers.getUsers(10)

    fun pushUser(users: Users){
        pushUser.pushUser(users)
    }

    fun getUsers(id:Int):List<Users>{
        return getUsers.getUsers(id)
    }

}
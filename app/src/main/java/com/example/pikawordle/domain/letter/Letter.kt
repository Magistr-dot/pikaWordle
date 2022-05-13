package com.example.pikawordle.domain.letter

import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.enum.MyLanguage

data class Letter (
    val oneLetter: Char,
    val language: MyLanguage = LANGUAGE,
    val color: MyColor = NEW_LETTER,
    var id: Int = UNDEFINED_ID
    ){
    companion object {
        val NEW_LETTER = MyColor.grey
        val LANGUAGE = MyLanguage.ru
        const val UNDEFINED_ID = -1
    }
}
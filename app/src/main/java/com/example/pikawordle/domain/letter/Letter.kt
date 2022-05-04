package com.example.pikawordle.domain.letter

import com.example.pikawordle.domain.enum.MyColor
import com.example.pikawordle.domain.enum.MyLanguage

class Letter (
    oneLetter: Char,
    language: MyLanguage = LANGUAGE,
    color: MyColor = NEW_LETTER,
    ){
    companion object {
        val NEW_LETTER = MyColor.grey
        val LANGUAGE = MyLanguage.ru
    }
}
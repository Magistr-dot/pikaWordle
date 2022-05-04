package com.example.pikawordle.domain.word

import com.example.pikawordle.domain.enum.MyLanguage

class Word (
    language: MyLanguage = LANGUAGE,
    ){
    companion object {
        val LANGUAGE = MyLanguage.ru
    }
}
package com.example.pikawordle.domain.word

import com.example.pikawordle.domain.enum.MyLanguage

data class Word(
    var name: String,
    var language: MyLanguage = LANGUAGE,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
        val LANGUAGE = MyLanguage.ru
    }
}
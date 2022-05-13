package com.example.pikawordle.domain.users


data class Users (
    val ava: String = "not now",
    val place: Int = UNKNOWN_PLACE,
    val name: String = "Name",
    var score: Double = SCORE,
    var id: Int = UNDEFINED_ID
){
    companion object {
        const val UNDEFINED_ID = -1
        const val UNKNOWN_PLACE = 0
        const val SCORE = 0.0
    }
}
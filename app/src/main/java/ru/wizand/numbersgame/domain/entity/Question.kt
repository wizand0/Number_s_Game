package ru.wizand.numbersgame.domain.entity

data class Question (
    val sum: Int,
    val visibleNumber: Int,
    val options: List<Int>

)
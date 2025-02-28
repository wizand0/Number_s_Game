package ru.wizand.numbersgame.domain.entity

data class GameSettings (
    val maSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSeconds: Int
)
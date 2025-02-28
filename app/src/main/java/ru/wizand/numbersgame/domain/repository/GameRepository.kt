package ru.wizand.numbersgame.domain.repository

import ru.wizand.numbersgame.domain.entity.GameSettings
import ru.wizand.numbersgame.domain.entity.Level
import ru.wizand.numbersgame.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings

}
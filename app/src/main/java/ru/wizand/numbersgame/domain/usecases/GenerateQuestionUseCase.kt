package ru.wizand.numbersgame.domain.usecases

import ru.wizand.numbersgame.domain.entity.GameSettings
import ru.wizand.numbersgame.domain.entity.Question
import ru.wizand.numbersgame.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }


}
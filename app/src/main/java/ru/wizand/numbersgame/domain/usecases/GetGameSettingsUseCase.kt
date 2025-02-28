package ru.wizand.numbersgame.domain.usecases

import ru.wizand.numbersgame.domain.entity.GameSettings
import ru.wizand.numbersgame.domain.entity.Level
import ru.wizand.numbersgame.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}
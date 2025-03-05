package ru.wizand.numbersgame.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult (
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameSettings: GameSettings
): Parcelable {

    val countOfRightAnswersString: String
        get() = countOfRightAnswers.toString()

    val countOfQuestionsString: String
        get() = countOfQuestions.toString()
}
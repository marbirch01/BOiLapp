package pl.marbirch.boilapp.data.model.domain

import pl.marbirch.boilapp.data.model.QuizQuestions

sealed class QuizState {
    data object NotStarted: QuizState()
    data object Loading: QuizState()

    data class Running(
        val currentQuestion: QuizQuestions,
        val correctAnsweredQuestions: Int = 0,
        val displayedQuestions: Int = 0
    ): QuizState()

    data class Answered(
        val isCorrect: Boolean,
        val currentQuestion: QuizQuestions,
        val correctAnsweredQuestions: Int = 0,
        val displayedQuestions: Int = 0
    ): QuizState()

    data class Finished(
        val correctAnsweredQuestions: Int = 0,
        val displayedQuestions: Int = 0
    ): QuizState()
}
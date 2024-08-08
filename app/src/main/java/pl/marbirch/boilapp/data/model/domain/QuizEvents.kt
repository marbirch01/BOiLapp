package pl.marbirch.boilapp.data.model.domain

sealed class QuizEvents {
    data class CheckAns(val userAnswer: UserAnswer): QuizEvents()
    data class NextQue(
        val correctAnsweredQuestions: Int = 0,
        val displayedQuestions: Int = 0
    ): QuizEvents()
}
package pl.marbirch.boilapp.data.model.domain

import pl.marbirch.boilapp.data.model.QuizQuestions

data class UserAnswer(val quizQuestions: QuizQuestions, val answer: String = "", val correctAnsweredQuestions: Int = 0, val displayedQuestions: Int = 0 )
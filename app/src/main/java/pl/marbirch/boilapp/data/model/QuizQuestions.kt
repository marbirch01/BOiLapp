package pl.marbirch.boilapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizQuestions(
    @SerialName("question")
    val question: String,
    @SerialName("answerA")
    val answerA: String,
    @SerialName("answerB")
    val answerB: String,
    @SerialName("answerC")
    val answerC: String,
    @SerialName("answerD")
    val answerD: String,
    @SerialName("correctAnswer")
    val correctAnswer: String
)








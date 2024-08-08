package pl.marbirch.boilapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Questions(
    @SerialName("questions")
    val questions: List<QuizQuestions>
)
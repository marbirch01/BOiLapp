package pl.marbirch.boilapp.data.model.domain

import pl.marbirch.boilapp.data.model.dto.DtoQuizHistory
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.math.max

data class QuizHistory(
    val id: Int = 0,
    val quizResult: Int = 0,
    val maxQuizPoints: Int = 0,
    val date: String = ""
){
    fun convertToDto(): DtoQuizHistory{
        val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val convertedDate = sdf.parse(date)?.time ?: 0L
        return DtoQuizHistory(
            id = id,
            quizResult = quizResult,
            maxQuizPoints = maxQuizPoints,
            timestamp = convertedDate
        )
    }
}

package pl.marbirch.boilapp.data.model.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.marbirch.boilapp.data.model.domain.QuizHistory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity(tableName = "quiz_history")
data class DtoQuizHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val quizResult: Int = 0,
    val maxQuizPoints: Int = 0,
    val timestamp: Long = 0
) {
    fun convertToModel(): QuizHistory{
        val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val date = Date(timestamp)
        val convertedDate = sdf.format(date)
        return QuizHistory(
            id = id,
            quizResult = quizResult,
            maxQuizPoints = maxQuizPoints,
            date =  convertedDate
        )
    }
}
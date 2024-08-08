package pl.marbirch.boilapp.data.local

import android.content.Context
import kotlinx.serialization.json.Json
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.data.model.Questions
import pl.marbirch.boilapp.data.model.QuizQuestions

class QuestionLoader(private val context: Context) {

    private var questions: Questions? = Questions(emptyList())
    private val json = Json {
        ignoreUnknownKeys = true
    }

    fun load(resourceId: Int = R.raw.question): Boolean{
        val jsonString = loadJsonFromR(context,resourceId) ?: return false
        val parsedJ = json.decodeFromString<Questions>(jsonString)
        questions = parsedJ
        return true
    }

    private fun loadJsonFromR(context: Context, resourceId: Int): String? {
        return try {
            context.resources.openRawResource(resourceId).use {inputSteam ->
                val bytes = inputSteam.readBytes()
                String(bytes)
            }
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }

    fun get (): List<QuizQuestions>{
        return questions?.questions ?: emptyList()
    }


}
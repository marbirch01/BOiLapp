package pl.marbirch.boilapp.data.repository

import android.content.Context
import pl.marbirch.boilapp.data.local.QuestionLoader
import pl.marbirch.boilapp.data.model.QuizQuestions

class QuestionRepository (context: Context) {
    private val questionsLoader = QuestionLoader(context)

    fun loadQuestions(): Boolean{
        return questionsLoader.load()
    }

    fun getQuestions(): List<QuizQuestions> {
        return questionsLoader.get()
    }
}
package pl.marbirch.boilapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pl.marbirch.boilapp.data.model.QuizQuestions
import pl.marbirch.boilapp.data.model.domain.MenuEvents
import pl.marbirch.boilapp.data.model.domain.QuizEvents
import pl.marbirch.boilapp.data.model.domain.QuizState
import pl.marbirch.boilapp.data.repository.QuestionRepository
import pl.marbirch.boilapp.data.repository.QuizRepository

class MainViewModel(app: Application): AndroidViewModel(app){
    private val quizRepository = QuizRepository()
    private val questionRepository = QuestionRepository(app)

    val currentQuizState = quizRepository.getQuizState().stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(), initialValue = QuizState.NotStarted)

    fun menuEventHandler(menuEvents: MenuEvents) = viewModelScope.launch {
        when(menuEvents){
            MenuEvents.Theory -> {}
            MenuEvents.Quiz -> {
                val isSuccess = loadQuestions()
                if (isSuccess){
                    quizRepository.startQuiz(getQuestions())
                }
            }
            MenuEvents.OpenTasks -> {}
        }
    }

    fun quizEventHandler(quizEvents: QuizEvents) = viewModelScope.launch {
        when(quizEvents){
            is QuizEvents.NextQue -> {
                quizRepository.loadNextQuestion(correctAnsweredQuestions = quizEvents.correctAnsweredQuestions, displayedQuestions = quizEvents.displayedQuestions)
            }
            is QuizEvents.CheckAns -> {
                quizRepository.checkAnswer(userAnswer = quizEvents.userAnswer)
            }
        }
    }

    private fun loadQuestions(): Boolean{
        return questionRepository.loadQuestions()
    }

    private fun getQuestions(): List<QuizQuestions>{
        return questionRepository.getQuestions()
    }
}
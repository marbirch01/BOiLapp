package pl.marbirch.boilapp.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.marbirch.boilapp.data.model.QuizQuestions
import pl.marbirch.boilapp.data.model.domain.QuizState
import pl.marbirch.boilapp.data.model.domain.UserAnswer

class QuizRepository {

    private val _quizState = MutableStateFlow<QuizState>(QuizState.NotStarted)
    private val leftQuestions: ArrayList<QuizQuestions> = ArrayList()
    private var questionsListSize = -1

    private fun updateQuizState(quizState: QuizState){
        _quizState.update { quizState }
    }

    fun getQuizState() = _quizState.asStateFlow()

    suspend fun startQuiz(questionsList: List<QuizQuestions>){
        updateQuizState(QuizState.Loading)
        delay(4000)
        if (leftQuestions.isEmpty()){
            leftQuestions.addAll(questionsList)
            questionsListSize = questionsList.size
        }
        val runningQuizState = QuizState.Running(
            currentQuestion = leftQuestions.removeFirst(),
            correctAnsweredQuestions = 0,
            displayedQuestions = 0
        )
        updateQuizState(runningQuizState)
    }

    fun checkAnswer(userAnswer: UserAnswer){
        val currentState = _quizState.value
        if (currentState is QuizState.Running){
            val isCorrect = currentState.currentQuestion.correctAnswer
            when (isCorrect == userAnswer.answer){
                true -> handleCorrectAnswer(userAnswer)
                false -> handleIncorrectAnswer(userAnswer)
            }
        }
    }

    private fun handleCorrectAnswer(userAnswer: UserAnswer) {
        val answered = QuizState.Answered(
            isCorrect = true,
            currentQuestion = userAnswer.quizQuestions,
            correctAnsweredQuestions = userAnswer.correctAnsweredQuestions +1,
            displayedQuestions = userAnswer.displayedQuestions +1
        )
        updateQuizState(answered)
    }
    private fun handleIncorrectAnswer(userAnswer: UserAnswer) {
        val answered = QuizState.Answered(
            isCorrect = false,
            currentQuestion = userAnswer.quizQuestions,
            correctAnsweredQuestions = userAnswer.correctAnsweredQuestions,
            displayedQuestions = userAnswer.displayedQuestions +1
        )
        updateQuizState(answered)
    }

    suspend fun loadNextQuestion(correctAnsweredQuestions: Int, displayedQuestions: Int){
        if (leftQuestions.isNotEmpty()){
            val nextQuestionState = QuizState.Running(
                currentQuestion = leftQuestions.removeFirst(),
                correctAnsweredQuestions = correctAnsweredQuestions,
                displayedQuestions = displayedQuestions
            )
            updateQuizState(nextQuestionState)
            return
        } else {
            val finishedQuizState = QuizState.Finished(correctAnsweredQuestions, displayedQuestions)
            updateQuizState(finishedQuizState)
        }
    }
}
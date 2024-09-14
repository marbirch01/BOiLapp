package pl.marbirch.boilapp

import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withTimeout
import org.junit.Test

import org.junit.Assert.*
import pl.marbirch.boilapp.data.model.QuizQuestions
import pl.marbirch.boilapp.data.model.domain.QuizState
import pl.marbirch.boilapp.data.model.domain.UserAnswer
import pl.marbirch.boilapp.data.repository.QuizHistoryRepository
import pl.marbirch.boilapp.data.repository.QuizRepository

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun startQuizShouldReturnLoadedQuestions() = runTest {
        val mockRepo = mockk<QuizHistoryRepository>(relaxed = true)
        val quizRepository = QuizRepository(mockRepo)

        val question = listOf(
            QuizQuestions(question = "Example1", answerA = "x", answerB = "y", answerC = "z", answerD = "v", correctAnswer = "A"),
            QuizQuestions(question = "Example2", answerA = "a", answerB = "b", answerC = "c", answerD = "d", correctAnswer = "B"),
            QuizQuestions(question = "Example3", answerA = "k", answerB = "j", answerC = "i", answerD = "o", correctAnswer = "D")
        )

        assertTrue(quizRepository.getQuizState().value is QuizState.NotStarted)
        quizRepository.startQuiz(question)
        advanceTimeBy(3000)

        val runningQuiz = quizRepository.getQuizState().first {it is QuizState.Running}
        assertTrue(runningQuiz is QuizState.Running)
        runningQuiz as QuizState.Running

        assertEquals("Example1", runningQuiz.currentQuestion.question)
        assertEquals(0, runningQuiz.correctAnsweredQuestions)
        assertEquals(0, runningQuiz.displayedQuestions)

    }

    @Test
    fun whenAnswerIsCorrectCheckAnswerShouldReturnTrue() = runTest {
        val mockRepo = mockk<QuizHistoryRepository>(relaxed = true)
        val quizRepository = QuizRepository(mockRepo)

        val question = QuizQuestions(question = "Example1", answerA = "x", answerB = "y", answerC = "z", answerD = "v", correctAnswer = "A")

        quizRepository.startQuiz(listOf(question))

        val userAnswer = UserAnswer(quizQuestions = question, answer = "A", correctAnsweredQuestions = 0, displayedQuestions = 0)

        quizRepository.checkAnswer(userAnswer)

        val updateState = quizRepository.getQuizState().value
        assertTrue(updateState is QuizState.Answered)

        val answeredState = updateState as QuizState.Answered

        assertTrue(answeredState.isCorrect)
        assertEquals(1, answeredState.correctAnsweredQuestions)
        assertEquals(question, answeredState.currentQuestion)
        assertEquals(1, answeredState.displayedQuestions)
    }
    @Test
    fun whenAnswerIsInCorrectCheckAnswerShouldReturnFalse() = runTest {
        val mockRepo = mockk<QuizHistoryRepository>(relaxed = true)
        val quizRepository = QuizRepository(mockRepo)

        val question = QuizQuestions(question = "Example1", answerA = "x", answerB = "y", answerC = "z", answerD = "v", correctAnswer = "A")

        quizRepository.startQuiz(listOf(question))

        val userAnswer = UserAnswer(quizQuestions = question, answer = "C", correctAnsweredQuestions = 0, displayedQuestions = 0)

        quizRepository.checkAnswer(userAnswer)

        val updateState = quizRepository.getQuizState().value
        assertTrue(updateState is QuizState.Answered)

        val answeredState = updateState as QuizState.Answered

        assertFalse(answeredState.isCorrect)
        assertEquals(0, answeredState.correctAnsweredQuestions)
        assertEquals(question, answeredState.currentQuestion)
        assertEquals(1, answeredState.displayedQuestions)
    }


    @Test
    fun loadingNextQuestionTest() = runTest {
        val question = mutableListOf(
            QuizQuestions(question = "Example1", answerA = "x", answerB = "y", answerC = "z", answerD = "v", correctAnswer = "A"),
            QuizQuestions(question = "Example2", answerA = "a", answerB = "b", answerC = "c", answerD = "d", correctAnswer = "B"),
            QuizQuestions(question = "Example3", answerA = "k", answerB = "j", answerC = "i", answerD = "o", correctAnswer = "D")
        )
        val mockRepo = mockk<QuizHistoryRepository>(relaxed = true)
        val quizRepository = QuizRepository(mockRepo)

        quizRepository.startQuiz(question)

        quizRepository.loadNextQuestion(correctAnsweredQuestions = 1, displayedQuestions = 1)

        val quizState = quizRepository.getQuizState().value

        assertTrue(quizState is QuizState.Running)
        val runningState = quizState as QuizState.Running
        assertEquals(question[1], runningState.currentQuestion)
        assertEquals(1, runningState.correctAnsweredQuestions)
        assertEquals(1, runningState.displayedQuestions)
    }

    @Test
    fun loadingNextQuestionTestFinished() = runTest {
        val question = mutableListOf(
            QuizQuestions(question = "Example1", answerA = "x", answerB = "y", answerC = "z", answerD = "v", correctAnswer = "A"),
            QuizQuestions(question = "Example2", answerA = "a", answerB = "b", answerC = "c", answerD = "d", correctAnswer = "B")
        )
        val mockRepo = mockk<QuizHistoryRepository>(relaxed = true)
        val quizRepository = QuizRepository(mockRepo)

        quizRepository.startQuiz(question)

        quizRepository.loadNextQuestion(correctAnsweredQuestions = 1, displayedQuestions = 1)
        quizRepository.loadNextQuestion(correctAnsweredQuestions = 1, displayedQuestions = 2)

        val quizState = quizRepository.getQuizState().value

        assertTrue(quizState is QuizState.Finished)
    }
}

package pl.marbirch.boilapp.ui.screens.quiz

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.data.model.QuizQuestions
import pl.marbirch.boilapp.data.model.domain.QuizState
import pl.marbirch.boilapp.data.model.domain.UserAnswer
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.AppButtonColor
import pl.marbirch.boilapp.ui.theme.Blue
import pl.marbirch.boilapp.ui.theme.Brown
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Gray
import pl.marbirch.boilapp.ui.theme.Green
import pl.marbirch.boilapp.ui.theme.LightGray
import pl.marbirch.boilapp.ui.theme.NavyBlue
import pl.marbirch.boilapp.ui.theme.QuestionButtonColor
import pl.marbirch.boilapp.ui.theme.Red
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    quizState: QuizState = QuizState.NotStarted,
    onCheck: (UserAnswer) -> Unit = {},
    onNext: (UserAnswer) -> Unit = {},
    onFinish: () -> Unit = {}
) {

    Surface(modifier = modifier.fillMaxSize(), color = Cream) {
        when(quizState){
            QuizState.NotStarted -> {}
            QuizState.Loading -> LoadingAnimation()
            is QuizState.Running -> RunningQuizScreen(
                state = quizState,
                textQue = quizState.currentQuestion.question,
                textA = quizState.currentQuestion.answerA,
                textB = quizState.currentQuestion.answerB,
                textC = quizState.currentQuestion.answerC,
                textD = quizState.currentQuestion.answerD,
                onCheck = {answer ->
                    val userAnswer = UserAnswer(
                        quizQuestions = quizState.currentQuestion,
                        answer = answer,
                        correctAnsweredQuestions = quizState.correctAnsweredQuestions,
                        displayedQuestions = quizState.displayedQuestions
                    )
                    onCheck(userAnswer)
                },
                onNext = {
                    val userAnswer = UserAnswer(
                        quizQuestions = quizState.currentQuestion,
                        answer = "",
                        correctAnsweredQuestions = (quizState as QuizState.Answered).correctAnsweredQuestions,
                        displayedQuestions = quizState.displayedQuestions
                    )
                    onNext(userAnswer)
                }
            )
            is QuizState.Answered -> RunningQuizScreen(
                state = quizState,
                textQue = quizState.currentQuestion.question,
                textA = quizState.currentQuestion.answerA,
                textB = quizState.currentQuestion.answerB,
                textC = quizState.currentQuestion.answerC,
                textD = quizState.currentQuestion.answerD,
                onNext = {
                    val userAnswer = UserAnswer(
                        quizQuestions = quizState.currentQuestion,
                        answer = "",
                        correctAnsweredQuestions = quizState.correctAnsweredQuestions,
                        displayedQuestions = quizState.displayedQuestions
                    )
                    onNext(userAnswer)
                })
            is QuizState.Finished -> {
                FinishScreen(quizState = quizState, onFinished = onFinish)
            }
        }
    }
    
}

@Composable
fun RunningQuizScreen(
    state: QuizState,
    userAns: String = "",
    textQue: String = "",
    textA: String = "",
    textB: String = "",
    textC: String = "",
    textD: String = "",
    userAnswer: String = "",
    onCheck: (String) ->Unit = {},
    onNext: () -> Unit = {}
) {
    var answer by remember { mutableStateOf(userAns) }

    var isClickedA by remember { mutableStateOf(false) }
    var isClickedB by remember { mutableStateOf(false) }
    var isClickedC by remember { mutableStateOf(false) }
    var isClickedD by remember { mutableStateOf(false) }
    

    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize()) {
        Column(modifier = Modifier
            .size(250.dp, 300.dp)
            .background(Cream)
            .padding(36.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
            when(state){
                is QuizState.Running -> {
                    ShowPoints(state.correctAnsweredQuestions, state.displayedQuestions, color = Color.White)
                    Column(modifier = Modifier
                        .padding(10.dp)
                        .size(250.dp, 400.dp), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally){
                        Text(text = textQue, color = Color.Black, style = Typography.labelLarge.copy(textAlign = TextAlign.Center, shadow = Shadow(color = Gray, offset = Offset(x = 7f, y= 7f), blurRadius = 9f), fontSize = 20.sp))
                        Spacer(modifier = Modifier.padding(bottom = 7.dp))
                        Button(
                            modifier = Modifier.padding(bottom = 8.dp),
                            onClick = { answer = "A"
                                      isClickedA = true
                                      isClickedB = false
                                      isClickedC = false
                                      isClickedD = false},
                            colors = ButtonDefaults.buttonColors(containerColor = if (isClickedA) Blue else QuestionButtonColor),
                        ){
                            Text(text = textA, style = Typography.titleSmall, fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            modifier = Modifier.padding(bottom = 8.dp),
                            onClick = { answer = "B"
                                        isClickedA = false
                                        isClickedB = true
                                        isClickedC = false
                                        isClickedD = false},
                            colors = ButtonDefaults.buttonColors(containerColor = if (isClickedB) Blue else QuestionButtonColor)
                        ) {
                            Text(text = textB, style = Typography.titleSmall, fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            modifier = Modifier.padding(bottom = 8.dp),
                            onClick = { answer = "C"
                                        isClickedA = false
                                        isClickedB = false
                                        isClickedC = true
                                        isClickedD = false},
                            colors = ButtonDefaults.buttonColors(containerColor = if (isClickedC) Blue else QuestionButtonColor)
                        ) {
                            Text(text = textC, style = Typography.titleSmall, fontSize = 20.sp, color = Color.White)
                        }
                        Button(
                            onClick = { answer = "D"
                                        isClickedA = false
                                        isClickedB = false
                                        isClickedC = false
                                        isClickedD = true},
                            colors = ButtonDefaults.buttonColors(containerColor = if (isClickedD) Blue else QuestionButtonColor)
                        ) {
                            Text(text = textD, style = Typography.titleSmall, fontSize = 20.sp, color = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    AppButton(modifier = Modifier.size(250.dp, 65.dp), text = "Sprawdź odpowiedź!", onClick = {onCheck(answer)}, textStyle = Typography.labelLarge.copy(fontSize = 20.sp), textColor = LightGray)

                }
                is QuizState.Answered -> {
                    ShowPoints(state.correctAnsweredQuestions, state.displayedQuestions, color = if (state.isCorrect) Green else Red)
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 160.dp),
                        text = if (state.isCorrect) "Poprawna" else "Niepoprawna",
                        color = if (state.isCorrect) Green else Red,
                        textAlign = TextAlign.Center,
                        style = Typography.headlineLarge.copy(fontSize = 40.sp, shadow = Shadow(color = Gray, offset = Offset(8f, 8f), blurRadius = 8f), letterSpacing = 0.04.em
                        )
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 150.dp),
                        text = "odpowiedź!",
                        color = if (state.isCorrect) Green else Red,
                        textAlign = TextAlign.Center,
                        style = Typography.headlineLarge.copy(fontSize = 40.sp, shadow = Shadow(color = Gray, offset = Offset(8f, 8f), blurRadius = 8f), letterSpacing = 0.04.em
                        ))
                    AppButton(modifier = Modifier
                        .size(250.dp, 65.dp)
                        .padding(bottom = 0.dp), text = "Następne pytanie!", onClick = onNext, textStyle = Typography.labelLarge.copy(fontSize = 20.sp), textColor = LightGray)
                }
                else -> {}
            }
        }
    }

}

@Composable
fun ShowPoints(correctAnsweredQuestions: Int, displayedQuestions: Int, color: Color) {
    Text(text = "$correctAnsweredQuestions/$displayedQuestions", style = Typography.labelLarge, color = color)
}

@Composable
fun LoadingAnimation(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "")

    val elementSize by transition.animateFloat(
        initialValue =41f,
        targetValue =63f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = CubicBezierEasing(0.62f, 0.1f, 0.91f, 0.9f)
            ), repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val elementRotate by transition.animateFloat(
        initialValue = 0f,
        targetValue = 180f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = CubicBezierEasing(0.62f, 0.1f, 0.91f, 0.9f)
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val elementShape by transition.animateFloat(
        initialValue = 0f,
        targetValue = 23f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = CubicBezierEasing(0.62f, 0.1f, 0.91f, 0.9f)
            ), repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Surface(modifier = Modifier
            .size(elementSize.dp)
            .rotate(elementRotate), shape = RoundedCornerShape(elementShape.dp), color = AppButtonColor) {
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RunningQuizScreenPreview() {
    RunningQuizScreen(
        state = QuizState.Running(
            currentQuestion = QuizQuestions(
                question = "What is the capital of France?",
                answerA = "Paris",
                answerB = "Berlin",
                answerC = "Madrid",
                answerD = "Rome",
                correctAnswer = "a"
            ),
            correctAnsweredQuestions = 0,
            displayedQuestions = 0
        ),
        textQue = "What is the capital of France?",
        textA = "Paris",
        textB = "Berlin",
        textC = "Madrid",
        textD = "Rome"
    )
}

@Preview
@Composable
private fun CorrectAnsweredQuizScreenPreview() {
    RunningQuizScreen(
        state = QuizState.Answered(
            isCorrect = true,
            currentQuestion = QuizQuestions(
                question = "What is the capital of France?",
                answerA = "Paris",
                answerB = "Berlin",
                answerC = "Madrid",
                answerD = "Rome",
                correctAnswer = "a"
            ),
            correctAnsweredQuestions = 1,
            displayedQuestions = 1
        ),
        textQue = "What is the capital of France?",
        textA = "Paris",
        textB = "Berlin",
        textC = "Madrid",
        textD = "Rome"
    )
}

@Preview
@Composable
private fun InCorrectAnsweredQuizScreenPreview() {
    RunningQuizScreen(
        state = QuizState.Answered(
            isCorrect = false,
            currentQuestion = QuizQuestions(
                question = "What is the capital of France?",
                answerA = "Paris",
                answerB = "Berlin",
                answerC = "Madrid",
                answerD = "Rome",
                correctAnswer = "a"
            ),
            correctAnsweredQuestions = 0,
            displayedQuestions = 0
        ),
        textQue = "What is the capital of France?",
        textA = "Paris",
        textB = "Berlin",
        textC = "Madrid",
        textD = "Rome"
    )
}

package pl.marbirch.boilapp.ui.screens.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.data.model.domain.QuizState
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Black
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.LightGray
import pl.marbirch.boilapp.ui.theme.Typography
import kotlin.math.roundToInt

@Composable
fun FinishScreen(quizState: QuizState.Finished, modifier: Modifier = Modifier, onFinished: () -> Unit = {}) {
    Surface(modifier = modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val punctation by remember {
                    val pointsScored = quizState.correctAnsweredQuestions.toFloat()
                    val maxPoints = quizState.displayedQuestions.toFloat()
                    val percent = ((pointsScored/maxPoints) * 100).roundToInt()
                    val finalText = when(percent){
                        in 0..49 -> "Uzyskałeś ocenę: 2.0"
                        in 50..60 -> "Uzyskałeś ocenę 3.0"
                        in 61..70 -> "Uzyskałeś ocenę 3.5"
                        in 71..80 -> "Uzyskałeś ocenę 4.0"
                        in 81..90 -> "Uzyskałeś ocenę 4.5"
                        in 91..100 -> "Uzyskałeś ocenę 5.0"
                        else -> "Coś poszło nie tak!"
                    }
                    mutableStateOf(finalText)
                }
                Spacer(modifier = Modifier.padding(top = 50.dp))
                Text(text = punctation.uppercase(), style = Typography.headlineLarge.copy(
                        shadow = Shadow(
                            color = Color.Gray,
                            blurRadius = 25f,
                            offset = Offset(x = 8f, y = 8f)
                        )
                    ), textAlign = TextAlign.Center, fontSize = 35.sp, color = Black)
                Spacer(modifier = Modifier.padding(vertical = 14.dp))
                Text(
                    text = "${quizState.correctAnsweredQuestions}/${quizState.displayedQuestions}",
                    style = Typography.headlineLarge,
                    color = Color.Gray
                )
            }
            AppButton(
                modifier = Modifier.size(250.dp, 65.dp),
                text = "Wyjście!",
                textStyle = Typography.headlineLarge.copy(fontSize = 20.sp),
                onClick = onFinished,
                textColor = LightGray
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FinishScreenPreview() {
    val state = QuizState.Finished(20,20)
    FinishScreen(quizState = state)
}
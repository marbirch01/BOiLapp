package pl.marbirch.boilapp.ui.screens.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Gray
import pl.marbirch.boilapp.ui.theme.LightGray
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onTheory: () -> Unit = {},
    onQuiz: () -> Unit = {},
    onOpenTasks: () -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxSize(), color = Cream) {
        Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(modifier = Modifier.padding(bottom = 75.dp), text = "BOiLapp", style = Typography.headlineLarge.copy(shadow = Shadow(color = Color.Gray, offset = Offset(x = 8f, y = 8f), blurRadius = 10f)), color = Color.Black.copy(alpha = 0.6f))
            AppButton(
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .size(240.dp, 75.dp),
                onClick = onTheory,
                text = "Teoria",
                textStyle = Typography.labelLarge,
                textColor = LightGray
            )
            AppButton(modifier = Modifier
                .padding(bottom = 15.dp)
                .size(240.dp, 75.dp),
                onClick = onQuiz,
                text = "Egzamin",
                textStyle = Typography.labelLarge,
                textColor = LightGray)
            AppButton(modifier = Modifier.size(240.dp, 75.dp),
                onClick = onOpenTasks,
                text = "Zadania otwarte",
                textStyle = Typography.labelLarge,
                textColor = LightGray)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun StartScreenPreview() {
    StartScreen()
}
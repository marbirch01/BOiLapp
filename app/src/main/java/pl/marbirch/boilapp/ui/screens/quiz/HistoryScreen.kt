package pl.marbirch.boilapp.ui.screens.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.data.model.domain.QuizHistory
import pl.marbirch.boilapp.data.model.dto.DtoQuizHistory
import pl.marbirch.boilapp.ui.theme.AppButtonColor
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography
import pl.marbirch.boilapp.ui.theme.White

@Composable
fun HistoryScreen(quizHistoryList: List<QuizHistory>, modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column {
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp), text = "Historia Egzaminów", textAlign = TextAlign.Center, style = Typography.headlineLarge.copy(shadow = Shadow(color = Color.Gray,blurRadius = 25f,offset = Offset(x = 8f, y = 8f)), fontSize = 35.sp), color = Color.Black)
            LazyColumn(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp), verticalArrangement = Arrangement.spacedBy(10.dp), contentPadding =  PaddingValues(vertical = 20.dp)){
                items(quizHistoryList){
                    QuizHistoryRow(it)
                }
            }
        }
    }
}

@Composable
fun QuizHistoryRow(quizHistory: QuizHistory, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = AppButtonColor)) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Text(text = quizHistory.date, style = Typography.headlineMedium, fontSize = 29.sp, color = Color.LightGray)
            Spacer(modifier = Modifier.padding(horizontal = 30.dp))
            Text(text = "${quizHistory.quizResult}/${quizHistory.maxQuizPoints}", style = Typography.headlineMedium, fontSize = 29.sp, color = Color.LightGray)
        }
    }
}

@Preview
@Composable
private fun QuizHistoryRowPreview() {
    QuizHistoryRow(quizHistory = QuizHistory(quizResult = 18, maxQuizPoints = 20, date = "14.09.2024"))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HistoryScreenPreview() {
    val list = buildList { for (i in 0..100){
        val history = QuizHistory(
            quizResult = i%20,
            maxQuizPoints = 20,
            date = "14.09.2024"
        )
        add(history)
     }
    }
    HistoryScreen(quizHistoryList = list)
}


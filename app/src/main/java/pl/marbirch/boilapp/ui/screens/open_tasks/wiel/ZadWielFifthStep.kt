package pl.marbirch.boilapp.ui.screens.open_tasks.wiel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun ZadWielFifthStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    var answer3 by remember { mutableStateOf("") }
    var answer4 by remember { mutableStateOf("") }
    var answer5 by remember { mutableStateOf("") }
    var answer6 by remember { mutableStateOf("") }
    var answer7 by remember { mutableStateOf("") }
    var answer8 by remember { mutableStateOf("") }
    var answer9 by remember { mutableStateOf("") }
    val correctAns = listOf("F2", "B2", "C2", "E5", "F5", "E6", "F6", "E7", "F7")
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 25.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Etap piąty polegał będzie na uzupełnieniu okna narzędzia \"Solver\", które obliczy wynik uwzględniając wszytskie wyznaczone ograniczenia. Dane w tym etapie uzupełniaj bazując na numerach komórek znajdujących się na grafice poniżej:")
            Image(
                painter = painterResource(id = R.drawable.zadwiel6),
                contentDescription = "zadwiel6",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(390.dp, 200.dp)
            )
            Text(modifier = Modifier.padding(vertical = 10.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Okno narzędzia \"Solver\":")
            Image(
                painter = painterResource(id = R.drawable.zadwiel5),
                contentDescription = "zadwiel5",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(380.dp, 400.dp)
            )
            Spacer(modifier = Modifier.padding(15.dp))
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.headlineMedium,
                text = "Ustaw cel:")
            TextField(value = answer1, onValueChange = {answer1 = it})
            Spacer(modifier = Modifier.padding(15.dp))
            Text(modifier = Modifier.padding(vertical = 15.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.headlineMedium,
                text = "Przez zmienianie komórek zmiennych:")
            Row {
                TextField(modifier = Modifier.size(75.dp, 57.dp),value = answer2, onValueChange = {answer2 = it})
                Spacer(modifier = modifier.padding(horizontal = 30.dp))
                TextField(modifier = Modifier.size(75.dp, 57.dp),value = answer3, onValueChange = {answer3 = it})
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.headlineMedium,
                text = "Podlegających ograniczeniom:")
            Row {
                Text(modifier = Modifier.padding(vertical = 20.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.bodyMedium,
                    text = "Ograniczenie 1:  ")
                TextField(modifier = Modifier.size(60.dp, 57.dp),value = answer4, onValueChange = {answer4 = it})
                Text(modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineMedium,
                    text = " ≤")
                TextField(modifier = Modifier.size(60.dp, 57.dp),value = answer5, onValueChange = {answer5 = it})
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row {
                Text(modifier = Modifier.padding(vertical = 20.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.bodyMedium,
                    text = "Ograniczenie 2:  ")
                TextField(modifier = Modifier.size(60.dp, 57.dp),value = answer6, onValueChange = {answer6 = it})
                Text(modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineMedium,
                    text = " ≤")
                TextField(modifier = Modifier.size(60.dp, 57.dp),value = answer7, onValueChange = {answer7 = it})
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row {
                Text(modifier = Modifier.padding(vertical = 20.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.bodyMedium,
                    text = "Ograniczenie 3:  ")
                TextField(modifier = Modifier.size(60.dp, 57.dp),value = answer8, onValueChange = {answer8 = it})
                Text(modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineMedium,
                    text = " ≥")
                TextField(modifier = Modifier.size(60.dp, 57.dp),value = answer9, onValueChange = {answer9 = it})
            }
            Spacer(modifier = Modifier.padding(15.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = (answer1.uppercase() == correctAns[0] && answer2.uppercase() == correctAns[1] && answer3.uppercase() == correctAns[2] && answer4.uppercase() == correctAns[3] && answer5.uppercase() == correctAns[4] && answer6.uppercase() == correctAns[5] && answer7.uppercase() == correctAns[6] && answer8.uppercase() == correctAns[7] && answer9.uppercase() == correctAns[8])
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(25.dp))
        }
    }
}

@Preview
@Composable
private fun ZadWielFifthStepPreview() {
    ZadWielFifthStep(onCheckAns = {})
}
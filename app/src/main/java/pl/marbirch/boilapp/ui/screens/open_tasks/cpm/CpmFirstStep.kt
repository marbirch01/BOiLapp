package pl.marbirch.boilapp.ui.screens.open_tasks.cpm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.roads.Roads
import pl.marbirch.boilapp.ui.theme.LightGray
import pl.marbirch.boilapp.ui.theme.Red

@Composable
fun CpmFirstStepScreen(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
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
    var answer10 by remember { mutableStateOf("") }
    val correctAns = listOf("3", "4", "6", "7", "1", "2", "3", "4", "1", "2")
    Surface(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
            .fillMaxSize(), color = Cream
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 40.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Na podstawie danych z tabeli oraz rysunku:"
            )
            Text(modifier = Modifier.padding(vertical = 5.dp),
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "1. przyporządkuj czasy trwania czynności")
            Text(modifier = Modifier.padding(vertical = 5.dp),
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "2. oblicz najwcześniejsze możliwe czasy zaistnienia zdarzeń")
            Text(modifier = Modifier.padding(vertical = 5.dp),
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "3. oblicz najpóźniejsze możliwe czasy zaistnienia zdarzeń")
            Text(modifier = Modifier.padding(vertical = 5.dp),
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "4. oblicz zapasy czasu")
            Text(modifier = Modifier.padding(vertical = 5.dp),
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "5. podaj ścieżkę krytyczną")
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.cpmtab),
                contentDescription = "cpm2",
                modifier = Modifier
                    .size(380.dp, 240.dp)
                    .padding(top = 0.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.cpmfirststep),
                contentDescription = "cpm2",
                modifier = Modifier
                    .size(340.dp, 170.dp)
                    .padding(top = 0.dp)
            )
            Text(
                modifier = Modifier.padding(top = 25.dp),
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Etap 1: Podaj czasy trwania podanych czynności: "
            )
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "A:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer1,
                onValueChange = { answer1 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "B:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer2,
                onValueChange = { answer2 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "C:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer3,
                onValueChange = { answer3 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "D:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer4,
                onValueChange = { answer4 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "E:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer5,
                onValueChange = { answer5 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "F:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer6,
                onValueChange = { answer6 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "G:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer7,
                onValueChange = { answer7 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "H:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer8,
                onValueChange = { answer8 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "I:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer9,
                onValueChange = { answer9 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "J:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                modifier = Modifier.padding(bottom = 70.dp),
                value = answer10,
                onValueChange = { answer10 = it },)

            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = (answer1 == correctAns[0] && answer2 == correctAns[1] && answer3 == correctAns[2] && answer4 == correctAns[3] && answer5 == correctAns[4] && answer6 == correctAns[5] && answer7 == correctAns[6] && answer8 == correctAns[7] && answer9 == correctAns[8] && answer10 == correctAns[9])
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(35.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CpmFirstStepScreenPreview() {
    //CpmFirstStepScreen()
}
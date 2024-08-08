package pl.marbirch.boilapp.ui.screens.open_tasks.cpm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavController
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.roads.Roads
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.LightGray
import pl.marbirch.boilapp.ui.theme.Red
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun CpmFourthStep(navigationController: NavController, modifier: Modifier = Modifier) {
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
    val correctAns = listOf("0", "0", "1", "0", "1", "0", "0", "0", "0")
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 40.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.cpmfourthstep),
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
                text = "Etap 4: Oblicz zapasy czasu: "
            )
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 1:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer1,
                onValueChange = { answer1 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 2:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer2,
                onValueChange = { answer2 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 3:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer3,
                onValueChange = { answer3 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 4:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer4,
                onValueChange = { answer4 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 5:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer5,
                onValueChange = { answer5 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 6:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer6,
                onValueChange = { answer6 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 7:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer7,
                onValueChange = { answer7 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 8:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer8,
                onValueChange = { answer8 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Zdarzenie 9:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                modifier = Modifier.padding(bottom = 70.dp),
                value = answer9,
                onValueChange = { answer9 = it },)
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                if (answer1 == correctAns[0] && answer2 == correctAns[1] && answer3 == correctAns[2] && answer4 == correctAns[3] && answer5 == correctAns[4] && answer6 == correctAns[5] && answer7 == correctAns[6] && answer8 == correctAns[7] && answer9 == correctAns[8]){
                    navigationController.navigate(Roads.cpmFifthStep)
                }else{
                    navigationController.navigate(Roads.IncorrectCpmFourthAnswer)
                }
            })
            Spacer(modifier = Modifier.padding(35.dp))
        }
    }
}

@Composable
fun IncorrectCpmFourthAnswer(navigationController: NavController, modifier: Modifier = Modifier) {
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.padding(100.dp))
            Text(style = Typography.headlineLarge, textAlign = TextAlign.Center, text = "Niepoprawna", color = Red)
            Text(style = Typography.headlineLarge, textAlign = TextAlign.Center, text = "odpowiedz!", color = Red)
            Spacer(modifier = Modifier.padding(120.dp))
            AppButton(
                modifier = Modifier.size(290.dp, 73.dp),
                text = "Wróc do czwartego etapu!",
                textColor = LightGray,
                textStyle = Typography.headlineLarge.copy(fontSize = 20.sp),
                onClick = { navigationController.navigate(Roads.cpmFourthStep) }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AnsweredCpmScreenPreview() {
    //CpmFourthStep()
}
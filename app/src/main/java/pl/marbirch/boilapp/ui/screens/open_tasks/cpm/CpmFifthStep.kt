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
fun CpmFifthStep (navigationController: NavController, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    val correctAns = listOf("acghij", "19")
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 40.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.cpmfifthstep),
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
                text = "Etap 5: Podaj ścieżkę krytyczną jako ciąg liter oraz finalny czas trwania całego procesu: "
            )
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Ścieżka krytyczna:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer1,
                onValueChange = { answer1 = it },)
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "Czas trwania całego procesu:", textAlign = TextAlign.Center, style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer2,
                onValueChange = { answer2 = it },)
            Spacer(modifier = Modifier.padding(35.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                if (answer1.lowercase() == correctAns[0] && answer2 == correctAns[1]){
                    navigationController.navigate(Roads.FinishedOpenTaskScreen)
                }else{
                   navigationController.navigate(Roads.IncorrectCpmFifthAnswer)
                }
            })
            Spacer(modifier = Modifier.padding(35.dp))
        }
    }
}

@Composable
fun IncorrectCpmFifthAnswer(navigationController: NavController, modifier: Modifier = Modifier) {
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
                text = "Wróc do piątego etapu!",
                textColor = LightGray,
                textStyle = Typography.headlineLarge.copy(fontSize = 20.sp),
                onClick = { navigationController.navigate(Roads.cpmFifthStep) }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AnsweredCpmScreenPreview() {
    //CpmFifthStep()
}
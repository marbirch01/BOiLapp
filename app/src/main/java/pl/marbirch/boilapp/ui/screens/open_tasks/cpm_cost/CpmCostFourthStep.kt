package pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
fun CpmCostFourthStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    var answer3 by remember { mutableStateOf("") }
    val correctAns = listOf("-", "50", "20")
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
                painter = painterResource(id = R.drawable.cpmcost5),
                contentDescription = "cpmcost5",
                modifier = Modifier
                    .padding(start = 25.dp)
                    .size(350.dp, 200.dp)
            )
            Text(
                modifier = Modifier.padding(vertical = 15.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Po obliczeniu nowego czasu realizacji przedsięwzięcia pojawiła się nowa ścieżka krytyczna."
            )
            Image(
                painter = painterResource(id = R.drawable.cpmcosttab),
                contentDescription = "cpmcosttab",
                modifier = Modifier
                    .size(320.dp, 140.dp)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Etap 4: Używając poniższego wzoru oblicz średnie gradienty kosztów dla wszystkich kroków nowej ścieżki krytycznej (Jeżeli obliczenie wartości jest niemożliwe w miejsce odpowiedzi wpisz ' - ' ) : "
            )
            Image(painter = painterResource(id = R.drawable.cost1), contentDescription = "cpm2", modifier = Modifier
                .size(250.dp, 140.dp)
                .padding(top = 20.dp) )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "1 - 2 :", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer1,
                onValueChange = { answer1 = it })
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "2 - 3 :", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer2,
                onValueChange = { answer2 = it })
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, text = "3 - 6 :", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            TextField(
                value = answer3,
                onValueChange = { answer3 = it })
            Spacer(modifier = Modifier.padding(20.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = (answer1 == correctAns[0] && answer2 == correctAns[1] && answer3 == correctAns[2])
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(35.dp))
        }
    }
}

@Preview
@Composable
private fun CpmCostFourthStepPreview() {
    CpmCostFourthStep(onCheckAns = {})
}
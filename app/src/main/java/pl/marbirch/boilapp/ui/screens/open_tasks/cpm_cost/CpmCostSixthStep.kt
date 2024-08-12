package pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun CpmCostSixthStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    var answer3 by remember { mutableStateOf("") }
    var answer4 by remember { mutableStateOf("") }
    var answer5 by remember { mutableStateOf("") }
    var answer6 by remember { mutableStateOf("") }
    val correctAns = listOf("5-6", "2-3", "2", "22", "40", "100")
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
                    .padding(start = 10.dp)
                    .size(350.dp, 210.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.cpmcosttab),
                contentDescription = "cpmcosttab",
                modifier = Modifier
                    .size(320.dp, 140.dp)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Row {
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        style = Typography.bodyMedium,
                        text = "Pierwsza ścieżka:")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        style = TextStyle(textDecoration = TextDecoration.LineThrough),
                        text = "1 - 4 : K = 10")
                    Text(color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        style = Typography.bodyMedium,
                        text = "5 - 6 : K = 20")
                }
                Text(text = "      ")
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        style = Typography.bodyMedium,
                        text = "Druga ścieżka:")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        style = Typography.bodyMedium,
                        text = "2 - 3 : K = 50")
                    Text(color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        style = TextStyle(textDecoration = TextDecoration.LineThrough),
                        text = "3 - 6 : K = 20")
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Text(color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Etap 6: Wybierz czynności o najmniejszym gradiencie kosztów oraz oblicz: o ile dni będziemy skracać czas, wyznacz nowy czas oraz koszty przyspieszenia realizacji przedsięwzięcia"
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, textAlign = TextAlign.Center, text = "Czynności o najmniejszym gradiencie kosztów:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            Text(modifier = Modifier.padding(bottom = 10 .dp), color = Color.Black, textAlign = TextAlign.Center, text = "(Wybierz po jednej czyności z każdej ścieżki krytycznej)", style = Typography.bodyMedium.copy(fontSize = 15.sp))
            TextField(
                value = answer1,
                onValueChange = { answer1 = it },
                placeholder = { Text(modifier = Modifier.size(250.dp, 25.dp),text = "pierwsza ścieżka", textAlign = TextAlign.Center, color = Color.Gray)})
            Spacer(modifier = Modifier.padding(15.dp))
            TextField(
                value = answer2,
                onValueChange = { answer2 = it },
                placeholder = { Text(modifier = Modifier.size(250.dp, 25.dp),text = "druga ścieżka", textAlign = TextAlign.Center, color = Color.Gray)})
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, textAlign = TextAlign.Center, text = "Ilość dni o którą skracamy czas realizacji przedsięwzięcia Δt:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            Text(modifier = Modifier.padding(bottom = 10 .dp), color = Color.Black, textAlign = TextAlign.Center, text = "(Wybierz mniejszą wartość)", style = Typography.bodyMedium.copy(fontSize = 15.sp))
            Image(
                painter = painterResource(id = R.drawable.cpmcost2),
                contentDescription = "cpmcpst2",
                modifier = Modifier
                    .size(100.dp, 50.dp)
            )
            TextField(
                value = answer3,
                onValueChange = { answer3 = it })
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, textAlign = TextAlign.Center, text = "Nowy czas realizacji przedsięwzięcia:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            Image(
                painter = painterResource(id = R.drawable.cpmcost3),
                contentDescription = "cpmcpst3",
                modifier = Modifier
                    .size(85.dp, 60.dp)
            )
            TextField(
                value = answer4,
                onValueChange = { answer4 = it })
            Text(modifier = Modifier.padding(vertical = 15.dp), color = Color.Black, textAlign = TextAlign.Center, text = "Koszty przyspieszenia realizacji przedsięwzięcia dla każdej czynnosci:", style = Typography.headlineLarge.copy(fontSize = 28.sp))
            Image(
                painter = painterResource(id = R.drawable.cpmcost4),
                contentDescription = "cpmcpst3",
                modifier = Modifier
                    .size(85.dp, 50.dp)
            )
            TextField(
                value = answer5,
                onValueChange = { answer5 = it },
                placeholder = { Text(modifier = Modifier.size(250.dp, 25.dp),text = "pierwsza czynność", textAlign = TextAlign.Center, color = Color.Gray)})
            Spacer(modifier = Modifier.padding(15.dp))
            TextField(
                value = answer6,
                onValueChange = { answer6 = it },
                placeholder = { Text(modifier = Modifier.size(250.dp, 25.dp),text = "druga czynność", textAlign = TextAlign.Center, color = Color.Gray)})
            Spacer(modifier = Modifier.padding(20.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = (answer1 == correctAns[0] && answer2 == correctAns[1] && answer3 == correctAns[2] && answer4 == correctAns[3] && answer5 == correctAns[4] && answer6 == correctAns[5])
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(35.dp))
        }
    }
}

@Preview
@Composable
private fun CpmCostSixthStepPreview() {
    CpmCostSixthStep(onCheckAns = {})
}
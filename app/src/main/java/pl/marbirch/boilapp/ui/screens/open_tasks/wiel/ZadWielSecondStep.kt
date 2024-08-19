package pl.marbirch.boilapp.ui.screens.open_tasks.wiel

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun ZadWielSecondStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    var answer3 by remember { mutableStateOf("") }
    var answer4 by remember { mutableStateOf("") }
    val correctAns = listOf("400", "1200", "300")
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 25.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(vertical = 15.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Pewna firma zaplanowała produkcję dwóch rodzajów wyrobów oznaczonych M oraz N, podczas której zużywane będzie 12kg surowca S. Aby wyprodukować jeden wyrób M firma musi wykorzystać 1kg surowca S oraz wymaga to 3 roboczogodzin, natomiast do wyprodukowania jednego wyrobu N firma wykorzystuje 1,5kg surowca S oraz czas 4 roboczogodzin. Koszt jednej roboczogodziny to 100zł. Łączna produkcja M oraz N musi wynosić co najmniej 4 jednostki natomiast produkcja wyrobu N nie może być większa niż 4 jednostki. Przychód ze sprzedaży wyrobu M wynosi 400zł, a wyrobu N 1200zł. Głównym celem firmy jest zmaksymalizowanie przychodów przy jednoczesnym zminimalizowaniu kosztów, natomiast minimalizacja kosztów jest 1,5 raza ważniejsza dla firmy. ")
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Określone w poprzednim etapie ograniczenia:")
            Text(modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                style = Typography.headlineLarge,
                text = "N + M ≥ 4")
            Text(modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                style = Typography.headlineLarge,
                text = "N ≤ 4")
            Text(modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
                style = Typography.headlineLarge,
                text = "M + 1,5 N ≥ 12")
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Etap 2: Wyznacz funkcję celu:"
            )
            Spacer(modifier = Modifier.padding(15.dp))
            Text(modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Funkcja celu będzie miała postać:")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                style = Typography.headlineLarge,
                text = "F(M, N) = MAX - 1,5 MIN")
            Spacer(modifier = Modifier.padding(15.dp))
            Text(color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Funkcja maksymalizowana (przychody):")
            Spacer(modifier = Modifier.padding(10.dp))
            Row (){
                Text(modifier = Modifier.padding(top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "MAX: "
                )
                TextField(modifier = Modifier.size(65.dp ,53.dp), value = answer1, onValueChange = {answer1 = it})
                Text(modifier = Modifier.padding(start = 7.dp, end = 7.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "M +"
                )
                TextField(modifier = Modifier.size(72.dp, 53.dp), value = answer2, onValueChange = {answer2 = it})
                Text(modifier = Modifier.padding(start = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "N"
                )
            }
            Spacer(modifier = Modifier.padding(15.dp))
            Text(color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Funkcja minimalizowana (koszty):")
            Spacer(modifier = Modifier.padding(10.dp))
            Row (){
                Text(modifier = Modifier.padding(top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "MIN: "
                )
                TextField(modifier = Modifier.size(65.dp ,53.dp), value = answer3, onValueChange = {answer3 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "M +"
                )
                TextField(modifier = Modifier.size(65.dp, 53.dp), value = answer4, onValueChange = {answer4 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "N"
                )
            }
            Spacer(modifier = Modifier.padding(25.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = (answer1 == correctAns[0] && answer2 == correctAns[1] && answer3 == correctAns[2] && answer4 == correctAns[0])
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(25.dp))
        }
    }
}

@Preview
@Composable
private fun ZadWielSecondStepPreview() {
    ZadWielSecondStep(onCheckAns = {})
}
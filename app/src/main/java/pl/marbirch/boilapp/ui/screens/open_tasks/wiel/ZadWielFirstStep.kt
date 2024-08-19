package pl.marbirch.boilapp.ui.screens.open_tasks.wiel

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.screens.open_tasks.doap.AnnotatedStrDoap
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun ZadWielFirstStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    var answer3 by remember { mutableStateOf("") }
    var answer4 by remember { mutableStateOf("") }
    var answer5 by remember { mutableStateOf("") }
    var answer6 by remember { mutableStateOf("") }
    var answer7 by remember { mutableStateOf("") }
    var answer8 by remember { mutableStateOf("") }
    val correctAns = listOf("n", "m","4", "12")
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 25.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.padding(15.dp))
            Text(color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Pewna firma zaplanowała produkcję dwóch rodzajów wyrobów oznaczonych M oraz N, podczas której zużywane będzie 12kg surowca S. Aby wyprodukować jeden wyrób M firma musi wykorzystać 1kg surowca S oraz wymaga to 3 roboczogodzin, natomiast do wyprodukowania jednego wyrobu N firma wykorzystuje 1,5kg surowca S oraz czas 4 roboczogodzin. Koszt jednej roboczogodziny to 100zł. Łączna produkcja M oraz N musi wynosić co najmniej 4 jednostki natomiast produkcja wyrobu N nie może być większa niż 4 jednostki. Przychód ze sprzedaży wyrobu M wynosi 400zł, a wyrobu N 1200zł. Głównym celem firmy jest zmaksymalizowanie przychodów przy jednoczesnym zminimalizowaniu kosztów, natomiast minimalizacja kosztów jest 1,5 raza ważniejsza dla firmy. ")
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                modifier = Modifier.padding(top = 5.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodySmall,
                text = "M - Liczba wyprodukowanych sztuk wyrobu pierwszego"
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodySmall,
                text = "N - Liczba wyprodukowanych sztuk wyrobu drugiego"
            )
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Etap 1: Określ ograniczenia zadania:"
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                color = Color.Black,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodySmall,
                text = "(Pola uzupełnij symbolami podanymi powyżej)"
            )
            Spacer(modifier = Modifier.padding(15.dp))
            Text(modifier = Modifier.padding(top = 15.dp, bottom = 25.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Ograniczenie minimalnej ilości wyprodukowanych wyrobów:")
            Row (){
                TextField(modifier = Modifier.size(65.dp ,53.dp), value = answer1, onValueChange = {answer1 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "+"
                )
                TextField(modifier = Modifier.size(65.dp, 53.dp), value = answer2, onValueChange = {answer2 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "≥"
                )
                TextField(modifier = Modifier.size(53.dp, 53.dp), value = answer3, onValueChange = {answer3 = it})
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.padding(top = 15.dp, bottom = 25.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Ograniczenie maksymalnej ilości wyprodukowanych wyrobów N :")
            Row (){
                TextField(modifier = Modifier.size(65.dp, 53.dp), value = answer4, onValueChange = {answer4 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "≤"
                )
                TextField(modifier = Modifier.size(53.dp, 53.dp), value = answer5, onValueChange = {answer5 = it})
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.padding(top = 15.dp, bottom = 25.dp),
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Ograniczenie związane z wagą dostępnego surowca:")
            Row (){
                TextField(modifier = Modifier.size(65.dp ,53.dp), value = answer6, onValueChange = {answer6 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "+ 1,5"
                )
                TextField(modifier = Modifier.size(65.dp, 53.dp), value = answer7, onValueChange = {answer7 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = "≤"
                )
                TextField(modifier = Modifier.size(53.dp, 53.dp), value = answer8, onValueChange = {answer8 = it})
            }
            Spacer(modifier = Modifier.padding(25.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = ((answer1.lowercase() == correctAns[0] && answer2.lowercase() == correctAns[1]) || (answer1.lowercase() == correctAns[1] && answer2.lowercase() == correctAns[0])) && (answer3 == correctAns[2]) && (answer4.lowercase() == correctAns[0]) && (answer5 == correctAns[2]) && (answer6.lowercase() == correctAns[1]) && (answer7.lowercase() == correctAns[0]) && (answer8 == correctAns[3])
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(25.dp))
        }
    }
}

@Preview
@Composable
private fun ZadWielFirstStepPreview() {
    ZadWielFirstStep(onCheckAns = {})
}
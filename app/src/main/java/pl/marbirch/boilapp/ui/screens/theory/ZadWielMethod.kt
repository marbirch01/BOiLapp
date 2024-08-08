package pl.marbirch.boilapp.ui.screens.theory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Gray
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun ZadWielMethod(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 30.dp, vertical = 30.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(modifier = Modifier.padding(top = 50.dp), color = Color.Black, text = "Zagadnienie Wielokryterialne w Optymalizacji", style = Typography.headlineLarge.copy(shadow = Shadow(color = Gray, offset = Offset(x= 8f, y= 8f), blurRadius = 6f)), fontSize = 25.sp, textAlign = TextAlign.Center)
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Zadania opierające się na zagadnieniach wielokryterialnych opisują sytuacje, w których musimy jednocześnie optymalizować kilka kryteriów w jednym momencie. Z praktycznego punktu widzenia oznacza to, że dążymy do sytuacji, w której rozwiązanie w najlepszy możliwy sposób zaspokaja wszystkie określone w zadaniu cele, które bardzo często bywają w konflikcie ze sobą.")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Zagadnienie to również składa się z takich pojęć jak:")
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "1. Funkcja celu – jest to matematyczny zapis kryterium optymalizacyjnego. Funkcję tę chcemy maksymalizować lub minimalizować.")
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "2. Zmienne decyzyjne – są nimi zmienne, które określamy w celu optymalizacji funkcji celu.")
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "3. Ograniczenia – są nimi warunki, które musimy spełnić podczas wykonywania optymalizacji zadania.")
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Kompromisowy plan – w przypadku, w którym jedno z kryteriów jest ważniejsze od drugiego możemy zastosować wagi, aby zbalansować różnice między nimi. Przykładowo, jeśli uzyskanie maksymalnej wartości przychodu jest 2 razy większe od minimalizacji kosztów wytworzenia jakiegoś produktu, tworzymy zadanie pomocnicze, które uwzględnia ustalone wagi.")
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Przykładem zadnia, które wykorzystuje zagadnienie wielokryterialne może być rozwiązanie problemu rolnika, który musi podzielić daną ilość hektarów ziemi pod uprawę różnego rodzaju zbóż w taki sposób, aby przyniosło to jak największy zysk oraz aby zminimalizować koszty uprawy. Rozwiązanie polega na wyznaczeniu takich wartości x1 oraz x2, aby zminimalizować koszty oraz zmaksymalizować przychód uwzględniając przy tym wszystkie wymienione ograniczenia. ")
            Spacer(modifier = Modifier.padding(15.dp))
        }

    }

}

@Preview
@Composable
private fun ZadWielMethodPreview() {
    ZadWielMethod()
}
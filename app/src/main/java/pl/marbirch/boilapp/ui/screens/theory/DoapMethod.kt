package pl.marbirch.boilapp.ui.screens.theory

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Gray
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun DoapMethod(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 30.dp, vertical = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(top = 50.dp), color = Color.Black, text = "Dobór optymalnego asortymentu produkcji", style = Typography.headlineLarge.copy(shadow = Shadow(color = Gray, offset = Offset(x= 8f, y= 8f), blurRadius = 6f)), fontSize = 25.sp, textAlign = TextAlign.Center)
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Możemy wyznaczyć trzy podstawowe rodzaje zadań optymalizacyjnych:")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "1. Optymalizacja statyczna – jest to sytuacja, w której podczas ciągłego procesu technologicznego, warunki nie zmieniają się w czasie.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "2. Optymalizacja quasistatyczna – jest to sytuacja, w której zmiana parametrów jest bardzo wolna i uznajemy, że nie następuje ich zmiana.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "3. Optymalizacja dynamiczna – jest to sytuacja, w której procesy zachodzą w reżimie dynamicznym. Przykładem może być rozruch instalacji.")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Programowanie matematyczne:")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Programowanie liniowe – jest to metoda optymalizacji, w której funkcja celu i funkcje ograniczeń są liniowe.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Programowanie nieliniowe – jest to metoda optymalizacji, w której funkcja celu i funkcje ograniczeń są nieliniowe.")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Model matematyczny składa się z kilku elementów: ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "1. Funkcja celu – jest to matematyczny zapis kryterium optymalizacyjnego.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "2. Zbiór zmiennych decydujących – są to parametry opisujące proces, które można kontrolować. ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "3. Zbiór ograniczeń – są to warunki, które muszą być spełnione. Przykładem może być dostępność potrzebnych zasobów.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Dobór optymalnego asortymentu produkcji – dobór ten polega na rozwiązaniu problemu z wyborem właściwego rodzaju i ilości wyrobu, w taki sposób, aby przedsiębiorstwo mogło uzyskać największy zysk z produkcji przy jednoczesnym nieprzekraczaniu dostępnych materiałów oraz zasobów potrzebnych do produkcji określonego wyrobu.")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Przykładowe zadanie: ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Dane wejściowe: ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Przykładowy zakład produkuje trzy rodzaje odlewów (odlew 1, odlew 2, odlew 3)")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Do produkcji przygotowany jest wsad metalowy w dwóch piecach (P I, P II)")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Tabela przedstawiająca pozostałe parametry:")
            Image(painter = painterResource(id = R.drawable.tab1), contentDescription = "tab1", modifier = Modifier
                .size(400.dp, 150.dp)
                .padding(top = 20.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Warunki ograniczające: ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Zapotrzebowanie na odlew 1 nie może przekraczać 200 szt.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Rezerwa dla kooperanta ma wynosić 120 szt. odlewu 2")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Odlewnia musi wywiązać się z zaległego zamówienia i wyprodukować 60 szt. odlewu 3")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Model matematyczny:")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "W przytoczonym zadaniu funkcja celu przyjmuje postać:")
            Image(painter = painterResource(id = R.drawable.doap1), contentDescription = "doap1", modifier = Modifier
                .size(280.dp, 70.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Ograniczenia: ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Ograniczenie związane z czasem pracy pieca P I:")
            Image(painter = painterResource(id = R.drawable.doap2), contentDescription = "doap2", modifier = Modifier
                .size(250.dp, 70.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Ograniczenie związane z czasem pracy pieca P II:")
            Image(painter = painterResource(id = R.drawable.doap3), contentDescription = "doap3", modifier = Modifier
                .size(250.dp, 70.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Ograniczenie dla odlewu 1:")
            Image(painter = painterResource(id = R.drawable.doap4), contentDescription = "doap4", modifier = Modifier
                .size(100.dp, 70.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Ograniczenie dla odlewu 2:")
            Image(painter = painterResource(id = R.drawable.doap5), contentDescription = "doap5", modifier = Modifier
                .size(110.dp, 70.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "• Ograniczenie dla odlewu 3:")
            Image(painter = painterResource(id = R.drawable.doap6), contentDescription = "doap6", modifier = Modifier
                .size(100.dp, 70.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Rozwiązanie uzyskane za pomocą Arkusza Kalkulacyjnego Excel:")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "1. Zdefiniowanie funkcji celu:")
            Image(painter = painterResource(id = R.drawable.doap7), contentDescription = "doap7", modifier = Modifier
                .size(400.dp, 200.dp)
                .padding(top = 20.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "2. Warunki ograniczające:")
            Image(painter = painterResource(id = R.drawable.doap8), contentDescription = "doap8", modifier = Modifier
                .size(400.dp, 250.dp)
                .padding(top = 20.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "3. Ustawienie narzędzia Solver oraz użycie go:")
            Image(painter = painterResource(id = R.drawable.doap9), contentDescription = "doap9", modifier = Modifier
                .size(300.dp, 360.dp)
                .padding(top = 20.dp))
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "4. Wyniki uzyskane po obliczeniach:")
            Image(painter = painterResource(id = R.drawable.doap10), contentDescription = "doap10", modifier = Modifier
                .size(300.dp, 200.dp))
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DoapMethodPreview() {
    DoapMethod()
}

package pl.marbirch.boilapp.ui.screens.theory

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.selects.whileSelect
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Gray
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun CpmMethod(modifier: Modifier = Modifier) {
    val annotatedString1 = buildAnnotatedString {
        append("t")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript, 
                fontSize = 12.sp
            )
        ) {
            append("0")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("j")
        }
        append(" - najwcześniejszy możliwy moment zaistnienia zdarzenia poprzedzającego")
    }
    val annotatedString2 = buildAnnotatedString {
        append("t")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript,
                fontSize = 12.sp
            )
        ) {
            append("1")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("j")
        }
        append(" - najwcześniejszy możliwy moment zaistnienia zdarzenia następującego")
    }
    val annotatedString3 = buildAnnotatedString {
        append("L")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("j")
        }
        append(" - zapas czasowy")
    }
    val annotatedString4 = buildAnnotatedString {
        append("t")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript,
                fontSize = 12.sp
            )
        ) {
            append("0")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("i")
        }
        append(" - najwcześniejszy możliwy moment zaistnienia zdarzenia, które jest poprzednikiem")
    }
    val annotatedString5 = buildAnnotatedString {
        append("t")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("i -")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("j")
        }
        append(" - czas trwania czynności między dwoma zdarzeniami i-tym oraz j-tym.")
    }
    val annotatedString6 = buildAnnotatedString {
        append("t")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript,
                fontSize = 12.sp
            )
        ) {
            append("1")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("i")
        }
        append(" - najpóźniejszy możliwy moment zaistnienia zdarzenia, które jest następnikiem")
    }
    val scrollState = rememberScrollState()
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 40.dp, vertical = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(top = 50.dp), color = Color.Black, text = "Metoda ścieżki krytycznej - CPM", style = Typography.headlineLarge.copy(shadow = Shadow(color = Gray, offset = Offset(x= 8f, y= 8f), blurRadius = 6f)), fontSize = 25.sp, textAlign = TextAlign.Center)
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Jest to metoda umożliwiająca analizę oraz przedstawienie w formie graficznej przedsięwzięcia składającego się z wielu czynności, które są określone i zorganizowane w jasny i ustalony wcześniej sposób. Przedsięwzięcie to dąży do osiągnięcia określonego wcześniej celu. Graficzne przedstawienie działalności polega na określeniu zbioru pojedynczych czynności oraz zdarzeń przedstawionych w formie wykresu składającego się ze strzałek (czynności) oraz kółek (zdarzeń).")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Zdarzenie – jest to moment, w którym rozpoczyna się lub kończy jedna, lub większa ilość czynności (na wykresie przedstawiona w formie kółka)")
            Image(painter = painterResource(id = R.drawable.cpm1), contentDescription = "cpm1", modifier = Modifier
                .size(250.dp)
                .padding(top = 25.dp))
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "j – numer zdarzenia ")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString1)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString2)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString3)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Czynność – jest to dowolny element całego projektu, który określony jest konkretnym czasem trwania oraz środkami, które zużywane są podczas realizacji (na wykresie przedstawiony w formie strzałki)")
            Image(painter = painterResource(id = R.drawable.cpm2), contentDescription = "cpm2", modifier = Modifier
                .size(250.dp, 120.dp)
                .padding(bottom = 0.dp) )
            Text(modifier = Modifier.padding(bottom = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Kierunek strzałki określa również kierunek czynności")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 20.sp, textAlign = TextAlign.Center, style = Typography.headlineMedium, text = "Reguły tworzenia sieci:")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "1. Zdarzenie, które określamy jako początkowe nie posiada czynności poprzedzających ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "2. Zdarzenie, które określamy jako końcowe nie posiada czynności następujących ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "3. Dwa kolejno przedstawione zdarzenia nie mogą być połączone więcej niż jedną czynnością ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "4. Jeżeli czynność pierwsza jest bezpośrednim poprzednikiem czynności drugiej to końcowe zdarzenie czynności pierwszej automatycznie staje się początkowym zdarzeniem czynności drugiej.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "5. W przypadku, w którym przykładowa czynność ma kilku poprzedników, końcowe zdarzenia tych czynności reprezentowane są przez tylko jedno zdarzenie, które staje się zdarzeniem początkowym wymienionej wyżej czynności przykładowej.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "6. W przypadku, w którym przykładowa czynność jest poprzednikiem dla kilku czynności to zdarzenie końcowej tej czynności automatycznie staje się zdarzeniem początkowym dla tych czynności ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 20.sp, textAlign = TextAlign.Center, style = Typography.headlineMedium, text = "Charakterystyczne cechy sieci: " )
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Obliczanie najwcześniejszych i najpóźniejszych możliwych momentów zdarzeń:")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.labelMedium, text = "1. Najwcześniejszy możliwy moment zaistnienia zdarzenia: ")
            Image(painter = painterResource(id = R.drawable.cpm3), contentDescription = "cpm3", modifier = Modifier
                .size(250.dp, 80.dp)
                .padding(top = 25.dp))
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString4)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString5)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "2. Najpóźniejszy możliwy moment zaistnienia zdarzenia:")
            Image(painter = painterResource(id = R.drawable.cpm4), contentDescription = "cpm4", modifier = Modifier
                .size(250.dp, 80.dp)
                .padding(top = 25.dp))
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.labelMedium, text = annotatedString6)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Wyznaczanie najpóźniejszych możliwych momentów zdarzeń następuje od końcowego zdarzenia do tego występującego na początku sieci.")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Ścieżka krytyczna – jest to droga określająca najdłuższy czas przejścia przez całą sieć. Czynności, które znajdują się na ścieżce krytycznej posiadają zerowy zapas czasu, w praktyce oznacza to, że opóźnienie tych czynności bezpośrednio wpływa na termin zakończenia przedsięwzięcia. ")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Zapas czasowy – jest to wartość określająca jak bardzo możliwe jest opóźnienie zaistnienia danego zdarzenia bez jakiegokolwiek wpływu na finalny termin zakończenia przedsięwzięcia. Określa się go wzorem:")
            Image(painter = painterResource(id = R.drawable.cpm4), contentDescription = "cpm4", modifier = Modifier
                .size(250.dp, 150.dp)
                .padding(top = 25.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CPMmethodPreview() {
    CpmMethod()
}

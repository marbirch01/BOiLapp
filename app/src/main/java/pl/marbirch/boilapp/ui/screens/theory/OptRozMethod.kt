package pl.marbirch.boilapp.ui.screens.theory

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
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
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Gray
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun OptRozMethod(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val annotatedString1 = buildAnnotatedString {
        append("x = {x")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("1")
        }
        append(", ..., x")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("n")
        }
        append("}")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript,
                fontSize = 12.sp
            )
        ) {
            append("T")
        }
        append(" - jest to zbiór wszystkich zmiennych decyzyjnych w zadaniu optymalizacyjnym")
    }
    val annotatedString2 = buildAnnotatedString {
        append("h")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("j")
        }
        append("(x) = 0 - są to warunki, które muszą zostać spełnione w formie równości")
    }
    val annotatedString3 = buildAnnotatedString {
        append("g")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("g")
        }
        append("(x) \u2264 0 - są to warunki, które muszą zostać spełnione w formie nierówności ")
    }
    val annotatedString4 = buildAnnotatedString {
        append("a")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("ij")
        }
        append(" - jest to ilość i-tego wyrobu, który uzyskany został przy zastosowaniu j-tego procesu technologicznego z jednostkową intensywnością                 (i = 1, 2, …, M; j = 1, 2, …, N)")
    }
    val annotatedString5 = buildAnnotatedString {
        append("b")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("i")
        }
        append(" - jest to planowana wielkość produkcji i-tego wyrobu")
    }
    val annotatedString6 = buildAnnotatedString {
        append("c")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("j")
        }
        append(" - jest to koszt, który ponosimy przy zastosowaniu j-tego procesu technologicznego z jednostkową intensywnością")
    }
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 30.dp, vertical = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(top = 50.dp), color = Color.Black, text = "Problem wyboru procesu technologicznego w hutnictwie (np. rozkroju)", style = Typography.headlineLarge.copy(shadow = Shadow(color = Gray, offset = Offset(x= 8f, y= 8f), blurRadius = 6f)), fontSize = 25.sp, textAlign = TextAlign.Center)
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Problem ten możemy wyjaśnić na prostym przykładzie. Pewien zakład musi wyprodukować określoną ilość różnego rodzaju produktów, używając do tego dostępnych procesów technologicznych. Każdy z dostępnych procesów posiada określoną z góry wydajność oraz koszt. Celem rozwiązania tego problemu jest znalezienie najlepszego możliwego sposobu na wykorzystanie tych procesów w taki sposób, aby było możliwe wyprodukowanie wymaganej ilości produktów przy najniższych możliwych kosztach. Zmienne decyzyjne definiują jak bardzo intensywne powinny być używane procesy technologiczne. ")
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Problem rozkroju – jest to problem opisujący optymalny sposób cięcia materiałów takich jak rury, blachy czy wstęgi umożliwiający minimalizację odpadów jednocześnie spełniając wymagane zapotrzebowanie na produkt. Optymalizacja problemu rozkroju jest kluczowym aspektem w przemyśle, ponieważ pomaga ona na wykorzystanie maksymalnej możliwej ilości zasobów redukując przy tym koszty produkcji.")
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Zadania oparte na problemie rozkroju wykonujemy poprzez definicję występującego problemu (wypisanie wszystkich danych, które posiadamy takich jak wielkość materiału, z którego będziemy tworzyć produkt, ilość oraz wielkość potrzebnych produktów), analizy możliwych sposobów cięcia oraz finalnych obliczeń na podstawie wybranego sposobu cięcia.")
            Text(modifier = Modifier.padding(top = 35.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "W różnych działach przemysłu takich jak hutnictwo problemy wyboru procesu technologicznego są przykładem zastosowania programowania liniowego w praktyce. Dzięki odpowiedniemu modelowaniu matematycznemu oraz analizie dostępnych rozwiązań jesteśmy w stanie wyłonić najbardziej efektywną strategie produkcji. ")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Zadanie optymalizacji liniowej:")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString1)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "n = 1, … , N – jest to liczba zmiennych w zadaniu optymalizacyjnym ")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "f(x) – jest to funkcja celu, funkcja, którą chcemy zoptymalizować ")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString2)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString3)
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Model matematyczny:")
            Image(painter = painterResource(id = R.drawable.roz1), contentDescription = "roz1", modifier = Modifier
                .size(300.dp, 270.dp)
                .padding(top = 20.dp))
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString4)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString5)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = annotatedString6)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OptRozMethodPreview() {
    OptRozMethod()
}
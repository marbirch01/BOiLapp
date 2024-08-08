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
fun CpmCostMethod(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val annotatedString1 = buildAnnotatedString {
        append("K")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("n")
        }
        append(" - Najniższe koszty potrzebne do wykonania czynności ")
    }
    val annotatedString2 = buildAnnotatedString {
        append("K")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("gr")
        }
        append(" - Koszty graniczne")
    }
    val annotatedString3 = buildAnnotatedString {
        append("t")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("n")
        }
        append(" - Normalny czas trwania czynności")
    }
    val annotatedString4 = buildAnnotatedString {
        append("t")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = 12.sp
            )
        ) {
            append("gr")
        }
        append(" - Graniczny czas trwania czynności ")
    }
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 40.dp, vertical = 30.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(modifier = Modifier.padding(top = 50.dp), color = Color.Black, text = "Metoda rozszerzona o analizę kosztową  - CPM-COST", style = Typography.headlineLarge.copy(shadow = Shadow(color = Gray, offset = Offset(x= 8f, y= 8f), blurRadius = 6f)), fontSize = 23.sp, textAlign = TextAlign.Center)
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Metoda CPM-COST jest rozszerzeniem metody CPM wzbogaconej o analizę kosztów przedsięwzięcia. Umożliwia ona przeprowadzenie analizy kosztowo-czasowej danego projektu uwzględniając aspekty ekonomiczne wiążące się z realizacją tego projektu.")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Wykorzystanie metody CMP-COST rozpoczynamy od określenia dwóch niezbędnych czynników:")
            Text(modifier = Modifier.padding(top = 25.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "1. Normalny czas trwania czynności – jest to czas trwania konkretnej czynności, dla którego koszty są najniższe")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "2. Graniczny czas trwania czynności – z technicznego punktu widzenia jest to najniższy możliwy czas trwania czynności, dla którego koszty są wyższe")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Następnie obliczamy średni gradient kosztów:")
            Image(painter = painterResource(id = R.drawable.cost1), contentDescription = "cpm2", modifier = Modifier
                .size(250.dp, 140.dp)
                .padding(top = 20.dp) )
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = annotatedString1)
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = annotatedString2)
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = annotatedString3)
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = annotatedString4)
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Algorytm kompresji sieci:")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = "1. Na podstawie normalnych czasów trwania czynności wyznaczamy ścieżkę krytyczną.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = "2. Wyznaczenie czynności krytycznych oraz obliczenie dla nich gradientów kosztów.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = "3. Przeanalizowanie czynności krytycznych i wyeliminowanie tych z nich dla których normalny czas trwania czynności równa się granicznemu czasu trwania czynności.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = "4. Wyznaczamy czynność krytyczną o najniższym gradiencie kosztów i od niej rozpoczynamy proces skracania czynności projektu.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = "5. W przypadku występowania równoległych ścieżek krytycznych w sieci skracamy czas o taką samą wielkość na wszystkich z nich.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = "6. Proces ten powtarzamy do momentu, w którym wszystkie czynności znajdujące się na którejkolwiek ze ścieżek krytycznych osiągną czasy graniczne.")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text = "7. Koszty przyspieszenia na każdym z etapów równają się iloczynowi gradientu kosztów dla danej czynności i liczby jednostek czasu, o jaką dana czynność została skrócona.")
            Image(painter = painterResource(id = R.drawable.cost2), contentDescription = "cpm2", modifier = Modifier
                .size(250.dp, 140.dp)
                .padding(top = 20.dp) )
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium,text ="8. Łączne koszty przyspieszenia obliczamy za pomocą sumy kosztów, które ponosimy na poszczególnych etapach ")
            Text(modifier = Modifier.padding(top = 30.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.titleMedium, text = "Koszt całkowity = koszty bezpośrednie + koszty pośrednie")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Koszty bezpośrednie – są to koszty, które mogą być przypisane do konkretnego produktu, wyrobu lub określonej fazy przedsięwzięcia. Nie wymagają one dodatkowych obliczeń, aby ich wartość była znana. ")
            Text(modifier = Modifier.padding(top = 20.dp), color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center, style = Typography.bodyMedium, text = "Koszty pośrednie – są to koszty, które nie mogą być przypisane do konkretnego produktu, wyrobu lub określonej fazy przedsięwzięcia bazując na dokumentacji źródłowej projektu. Aby je wyznaczyć używa się tzw. kluczy podziałowych.")
            Spacer(modifier = Modifier.padding(40.dp))


        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CpmCostMethodPreview() {
    CpmCostMethod()
}
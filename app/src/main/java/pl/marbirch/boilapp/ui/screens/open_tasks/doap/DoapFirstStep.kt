package pl.marbirch.boilapp.ui.screens.open_tasks.doap

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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun DoapFirstStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    var answer3 by remember { mutableStateOf("") }
    var answer4 by remember { mutableStateOf("") }
    var answer5 by remember { mutableStateOf("") }
    var answer6 by remember { mutableStateOf("") }
    var answer7 by remember { mutableStateOf("") }
    var answer8 by remember { mutableStateOf("") }
    var answer9 by remember { mutableStateOf("") }
    var answer10 by remember { mutableStateOf("") }
    var answer11 by remember { mutableStateOf("") }
    val correctAns = listOf("16", "24", "96000", "16", "10", "80000", "3000", "4000", "2", "3", "0")
   Surface(modifier = Modifier
       .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
       .fillMaxSize(), color = Cream) {
       Column (modifier = Modifier
           .fillMaxSize()
           .verticalScroll(scrollState)
           .padding(horizontal = 25.dp, vertical = 30.dp),
           horizontalAlignment = Alignment.CenterHorizontally) {
           Spacer(modifier = Modifier.padding(10.dp))
           Text(modifier = Modifier.padding(vertical = 20.dp),
               color = Color.Black,
               fontSize = 17.sp,
               textAlign = TextAlign.Center,
               style = Typography.titleMedium,
               text = "Pewna kuźnia produkuję dwa rodzaje wyrobów oznaczonych: W1 oraz W2. Podczas procesu produkowania wyrobów wykorzystuję się dwa surowce: rurę oraz blachę stalową. Limit pierwszego surowca wynosi 96 000 cm natomist drugiego 80 000 cm. Zdolności produkcyjne zakładu wprowadzają ograniczenia dotyczące maksymalnej ilości wyprodukowanych wyrobów określonych jako 3000 sztuk wyrobu pierwszego oraz 4000 sztuk wyrobu drugiego. Zespół odpowiedzialny za analizę produkcji ustalił optymalną proporcję produkcji, która wynosi 3:2. Określono rónież cenę sprzedaży jednostki wyrobu i wynosi ona 30zł dla wyrobu pierwszego oraz 40 zł dla wyrobu drugiego. W tabeli znajdującej się poniżej przedstawiono nakłady surowców, które potrzebne są do wyprodukowania jednej sztuki każdego wyrobu: ")
           Image(
               painter = painterResource(id = R.drawable.doaptab),
               contentDescription = "doaptab",
               modifier = Modifier
                   .padding(start = 5.dp)
                   .size(350.dp, 120.dp)
           )
           Spacer(modifier = Modifier.padding(10.dp))
           Row (modifier = Modifier.padding(start = 35.dp)) {
               Text(color = Color.Black,
                   fontSize = 19.sp,
                   style = Typography.titleMedium,
                   text = AnnotatedStrDoap("1", 12.sp))
               Text(color = Color.Black,
                   fontSize = 17.sp,
                   style = Typography.bodyMedium,
                   text = "- liczba wyprodukowanych sztuk wyrobu pierwszego")
           }
           Spacer(modifier = Modifier.padding(10.dp))
           Row (modifier = Modifier.padding(start = 35.dp)) {
               Text(color = Color.Black,
                   fontSize = 19.sp,
                   style = Typography.titleMedium,
                   text = AnnotatedStrDoap("2", 12.sp))
               Text(color = Color.Black,
                   fontSize = 17.sp,
                   style = Typography.bodyMedium,
                   text = "- liczba wyprodukowanych sztuk wyrobu drugiego")
           }
           Spacer(modifier = Modifier.padding(20.dp))
           Text(
               modifier = Modifier.padding(top = 15.dp),
               color = Color.Black,
               fontSize = 21.sp,
               textAlign = TextAlign.Center,
               style = Typography.headlineMedium,
               text = "Etap 1: Określ ograniczenia zadania:"
           )
           Spacer(modifier = Modifier.padding(15.dp))
           Text(modifier = Modifier.padding(top = 15.dp, bottom = 25.dp),
               color = Color.Black,
               fontSize = 18.sp,
               textAlign = TextAlign.Center,
               style = Typography.bodyMedium,
               text = "Ograniczenie rur stalowych:")
           Row {
               TextField(modifier = Modifier.size(53.dp ,53.dp), value = answer1, onValueChange = {answer1 = it})
               Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 7.dp),
                   color = Color.Black,
                   fontSize = 20.sp,
                   textAlign = TextAlign.Center,
                   style = Typography.headlineLarge,
                   text = buildAnnotatedString {
                       append(AnnotatedStrDoap("1", 12.sp))
                       append("+")
                   })
               TextField(modifier = Modifier.size(53.dp, 53.dp), value = answer2, onValueChange = {answer2 = it})
               Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 7.dp),
                   color = Color.Black,
                   fontSize = 20.sp,
                   textAlign = TextAlign.Center,
                   style = Typography.headlineLarge,
                   text = buildAnnotatedString {
                       append(AnnotatedStrDoap("2", 12.sp))
                       append(" ≤")
                   })
               TextField(modifier = Modifier.size(120.dp, 53.dp), value = answer3, onValueChange = {answer3 = it})
           }
           Spacer(modifier = Modifier.padding(15.dp))
           Text(modifier = Modifier.padding(top = 15.dp, bottom = 25.dp),
               color = Color.Black,
               fontSize = 18.sp,
               textAlign = TextAlign.Center,
               style = Typography.bodyMedium,
               text = "Ograniczenie blach stalowych:")
           Row {
               TextField(modifier = Modifier.size(53.dp ,53.dp), value = answer4, onValueChange = {answer4 = it})
               Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 7.dp),
                   color = Color.Black,
                   fontSize = 20.sp,
                   textAlign = TextAlign.Center,
                   style = Typography.headlineLarge,
                   text = buildAnnotatedString {
                       append(AnnotatedStrDoap("1", 12.sp))
                       append("+")
                   })
               TextField(modifier = Modifier.size(53.dp, 53.dp), value = answer5, onValueChange = {answer5 = it})
               Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 7.dp),
                   color = Color.Black,
                   fontSize = 20.sp,
                   textAlign = TextAlign.Center,
                   style = Typography.headlineLarge,
                   text = buildAnnotatedString {
                       append(AnnotatedStrDoap("2", 12.sp))
                       append(" ≤")
                   })
               TextField(modifier = Modifier.size(120.dp, 53.dp), value = answer6, onValueChange = {answer6 = it})
           }
           Spacer(modifier = Modifier.padding(15.dp))
           Text(modifier = Modifier.padding(top = 15.dp, bottom = 25.dp),
               color = Color.Black,
               fontSize = 18.sp,
               textAlign = TextAlign.Center,
               style = Typography.bodyMedium,
               text = "Ograniczenia związane z możliwościami produkcji:")
           Row {
               Text(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 13.dp),
                   color = Color.Black,
                   fontSize = 22.sp,
                   textAlign = TextAlign.Center,
                   style = Typography.headlineLarge,
                   text = buildAnnotatedString {
                       append(AnnotatedStrDoap("1", 12.sp))
                       append(" ≤")
                   })
               TextField(modifier = Modifier.size(90.dp, 53.dp), value = answer7, onValueChange = {answer7 = it}, placeholder = { Text(modifier = Modifier.size(250.dp, 25.dp),text = "rury", textAlign = TextAlign.Center, color = Color.Gray)})
           }
           Spacer(modifier = Modifier.padding(10.dp))
           Row {
               Text(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 13.dp),
                   color = Color.Black,
                   fontSize = 22.sp,
                   textAlign = TextAlign.Center,
                   style = Typography.headlineLarge,
                   text = buildAnnotatedString {
                       append(AnnotatedStrDoap("2", 12.sp))
                       append(" ≤")
                   })
               TextField(modifier = Modifier.size(90.dp, 53.dp), value = answer8, onValueChange = {answer8 = it},placeholder = { Text(modifier = Modifier.size(250.dp, 25.dp),text = "blachy", textAlign = TextAlign.Center, color = Color.Gray)})
           }
           Spacer(modifier = Modifier.padding(15.dp))
           Text(modifier = Modifier.padding(top = 15.dp, bottom = 25.dp),
               color = Color.Black,
               fontSize = 18.sp,
               textAlign = TextAlign.Center,
               style = Typography.bodyMedium,
               text = "Ograniczenia związane ze stosunkiem produkcji (wzór przedstawiający proporcję przekształć do postaci liniowej):")
           Row {
               TextField(modifier = Modifier.size(53.dp ,53.dp), value = answer9, onValueChange = {answer9 = it})
               Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 7.dp),
                   color = Color.Black,
                   fontSize = 20.sp,
                   textAlign = TextAlign.Center,
                   style = Typography.headlineLarge,
                   text = buildAnnotatedString {
                       append(AnnotatedStrDoap("1", 12.sp))
                       append("-")
                   })
               TextField(modifier = Modifier.size(53.dp, 53.dp), value = answer10, onValueChange = {answer10 = it})
               Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 7.dp),
                   color = Color.Black,
                   fontSize = 20.sp,
                   textAlign = TextAlign.Center,
                   style = Typography.headlineLarge,
                   text = buildAnnotatedString {
                       append(AnnotatedStrDoap("2", 12.sp))
                       append("=")
                   })
               TextField(modifier = Modifier.size(70.dp, 53.dp), value = answer11, onValueChange = {answer11 = it})
           }
           Spacer(modifier = Modifier.padding(25.dp))
           AppButton(
               modifier = Modifier.size(290.dp, 73.dp),
               text = "Sprawdź odpowiedź!",
               textColor = Color.LightGray,
               textStyle = Typography.headlineLarge.copy(fontSize = 20.sp),
               onClick = {
                   val isCorrect =
                       (answer1 == correctAns[0] && answer2 == correctAns[1] && answer3 == correctAns[2] && answer4 == correctAns[3] && answer5 == correctAns[4] && answer6 == correctAns[5] && answer7 == correctAns[6] && answer8 == correctAns[7] && answer9 == correctAns[8] && answer10 == correctAns[9] && answer11 == correctAns[10])
                   onCheckAns(isCorrect)
               },
           )
           Spacer(modifier = Modifier.padding(25.dp))
       }
   }
}

fun AnnotatedStrDoap(value1: String, value2: TextUnit): AnnotatedString {
    val annotatedString1 = buildAnnotatedString {
        append("x")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Subscript,
                fontSize = value2
            )
        ) {
            append(value1)
        }
    }
    return annotatedString1
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DoapFirstStepPreview() {
    DoapFirstStep(onCheckAns = {})
}
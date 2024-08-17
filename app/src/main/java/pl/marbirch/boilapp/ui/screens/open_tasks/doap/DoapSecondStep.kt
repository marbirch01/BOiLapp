package pl.marbirch.boilapp.ui.screens.open_tasks.doap

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun DoapSecondStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    val correctAns = listOf("30", "40")
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream
    ) {
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
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Określone w poprzednim etapie ograniczenia:")
            Image(
                painter = painterResource(id = R.drawable.doap1op),
                contentDescription = "doap1op",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .size(300.dp, 220.dp)
            )
            Text(
                modifier = Modifier.padding(top = 15.dp),
                color = Color.Black,
                fontSize = 21.sp,
                textAlign = TextAlign.Center,
                style = Typography.headlineMedium,
                text = "Etap 2: Wyznacz funkcję celu:"
            )
            Spacer(modifier = Modifier.padding(30.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,text = buildAnnotatedString {
                        append("F( ")
                        append(AnnotatedStrDoap("1", 12.sp))
                        append(" , ")
                        append(AnnotatedStrDoap("2", 12.sp))
                        append(" ) =")
                    })
                TextField(modifier = Modifier.size(45.dp, 53.dp), value = answer1, onValueChange = {answer1 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,text = buildAnnotatedString {
                        append(AnnotatedStrDoap("1", 12.sp))
                        append(" +")
                    })
                TextField(modifier = Modifier.size(45.dp, 53.dp), value = answer2, onValueChange = {answer2 = it})
                Text(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 12.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    style = Typography.headlineLarge,
                    text = AnnotatedStrDoap("2", 12.sp))
            }
            Spacer(modifier = Modifier.padding(25.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = (answer1 == correctAns[0] && answer2 == correctAns[1])
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(25.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DoapSecondStepPreview() {
    DoapSecondStep(onCheckAns = {})
}
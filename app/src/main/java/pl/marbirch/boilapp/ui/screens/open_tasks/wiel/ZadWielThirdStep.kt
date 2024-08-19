package pl.marbirch.boilapp.ui.screens.open_tasks.wiel

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.R
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun ZadWielThirdStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
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
                text = "Ostateczny wzór funkcji ma postać:")
            Image(
                painter = painterResource(id = R.drawable.zadwiel1),
                contentDescription = "zadwiel3",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(410.dp, 40.dp)
            )
            Text(modifier = Modifier.padding(vertical = 15.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Po przekształceniu wzoru otrzymujemy:")
            Image(
                painter = painterResource(id = R.drawable.zadwiel3),
                contentDescription = "zadwiel3",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(260.dp, 40.dp)
            )
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Do wykonania następnych kroków zadania niezbędny będzie arkusz kalkulacyjny Exel. Otwórz aplikację oraz utwórz nowy plik Exel. Poszczególne komórki ustaw według schematu, widocznego na poniższej grafice: ")
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.zadwiel2),
                contentDescription = "zadwiel1",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(400.dp, 150.dp)
            )
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Wprowadz dane związane z ograniczeniami w zadaniu. Uzupełnij komórkę związaną z funkcją celu zgodnie z przykładem powyżej używając sumy iloczynów.")
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Jeżeli uzupełniłeś swój plik zgodnie ze wzorem przejć do następnego etapu.")
            Spacer(modifier = Modifier.padding(20.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Następny etap!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = true
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(25.dp))
        }
    }
}

@Preview
@Composable
private fun ZadWielThirdStepPreview() {
    ZadWielThirdStep(onCheckAns = {})
}
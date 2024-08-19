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
fun ZadWielFourthStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
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
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Następnym etapem jest ustawienie danych, które znajdują się po \"Lewej stronie\" i związane są z ograniczeniami. Uzupełnij komórki zgonie z ustalonymi wcześniej ograniczeniami, które znajdują się poniżej")
            Spacer(modifier = Modifier.padding(10.dp))
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
            Image(
                painter = painterResource(id = R.drawable.zadwiel4),
                contentDescription = "doap2ot",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(400.dp, 280.dp)
            )
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Ustaw wszystkie dane znajdujące się po \"Lewej stronie\" zgodnie z przykładem pokazującym przykładowe uzupełnienie jednej z komórek. Każda z komórek odpowiada wzorowi konkretnego ograniczenia.")
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Jeżeli uzupełniłeś swój plik zgodnie ze wzorem przejć do następnego etapu.")
            Spacer(modifier = Modifier.padding(15.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Natępny etap!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = true
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(25.dp))
        }
    }
}

@Preview
@Composable
private fun ZadWielFourthStepPreview() {
    ZadWielFourthStep(onCheckAns = {})
}
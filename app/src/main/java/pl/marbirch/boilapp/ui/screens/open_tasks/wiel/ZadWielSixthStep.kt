package pl.marbirch.boilapp.ui.screens.open_tasks.wiel

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import pl.marbirch.boilapp.ui.screens.open_tasks.doap.AnnotatedStrDoapSec
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun ZadWielSixthStep(onCheckAns: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var answer1 by remember { mutableStateOf("") }
    var answer2 by remember { mutableStateOf("") }
    var answer3 by remember { mutableStateOf("") }
    val correctAns = listOf("2400", "4", "0")
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
                text = "Po uzupełnieniu danych w oknie narzędzia \"Solver\" klikamy przycisk \"Rozwiąż\": ")
            Image(
                painter = painterResource(id = R.drawable.zadwiel7),
                contentDescription = "zadwiel7",
                modifier = Modifier
                    .size(390.dp, 400.dp)
            )
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.titleMedium,
                text = "Wyniki uzyskane za pomocą obliczeń: ")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Funkcja celu: ")
            TextField(value = answer1, onValueChange = {answer1 = it})
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.padding(vertical = 20.dp),
                color = Color.Black,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                style = Typography.bodyMedium,
                text = "Komórki zmienne N oraz M")
            Row {
                TextField(modifier = Modifier.size(80.dp, 57.dp),value = answer2, onValueChange = {answer2 = it}, placeholder = { Text(modifier = Modifier.size(250.dp, 25.dp),text = "N", textAlign = TextAlign.Center, color = Color.Gray)})
                Spacer(modifier = modifier.padding(horizontal = 30.dp))
                TextField(modifier = Modifier.size(80.dp, 57.dp),value = answer3, onValueChange = {answer3 = it}, placeholder = { Text(modifier = Modifier.size(250.dp, 25.dp),text = "M", textAlign = TextAlign.Center, color = Color.Gray)})
            }
            Spacer(modifier = Modifier.padding(15.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp), text = "Sprawdź odpowiedź!", textColor = Color.LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp), onClick = {
                val isCorrect = (answer1 == correctAns[0] && answer2 == correctAns[1] && answer3 == correctAns[2])
                onCheckAns(isCorrect)
            })
            Spacer(modifier = Modifier.padding(25.dp))
        }
    }
}

@Preview
@Composable
private fun ZadWielSixthStepPreview() {
    ZadWielSixthStep(onCheckAns = {})
}
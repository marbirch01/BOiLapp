package pl.marbirch.boilapp.ui.screens.theory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.DarkGray
import pl.marbirch.boilapp.ui.theme.Gray
import pl.marbirch.boilapp.ui.theme.Green
import pl.marbirch.boilapp.ui.theme.LightGray
import pl.marbirch.boilapp.ui.theme.Typography

@Composable
fun SelectTheoryScreen(
    modifier: Modifier = Modifier,
    onCpm: () -> Unit = {},
    onCpmCost: () -> Unit = {},
    onDoap: () -> Unit = {},
    onOptRoz: () -> Unit = {},
    onOptPrzy: () -> Unit = {},
) {
    Surface(modifier = Modifier
        .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
        .fillMaxSize(), color = Cream) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(modifier = Modifier.padding(bottom = 50.dp), text = "Wybierz metodę, której chcesz się nauczyć!",
                textAlign = TextAlign.Center,
                color = DarkGray,
                style = Typography.headlineLarge.copy(fontSize = 32.sp, shadow = Shadow(color = Gray, offset = Offset(9f, 9f), blurRadius = 10f)
            ))
            AppButton(modifier = Modifier.size(290.dp, 73.dp) ,text = "Metoda CPM", onClick = onCpm, textColor = LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp))
            Spacer(modifier = Modifier.padding(17.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp) ,text = "Metoda CPM-COST", onClick = onCpmCost, textColor = LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp))
            Spacer(modifier = Modifier.padding(17.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp) ,text = "Dobór optymalnego asortymentu produkcji", onClick = onDoap, textColor = LightGray, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp))
            Spacer(modifier = Modifier.padding(17.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp) ,text = "Optymalizacja rozkroju", textColor = LightGray, onClick = onOptRoz, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp))
            Spacer(modifier = Modifier.padding(17.dp))
            AppButton(modifier = Modifier.size(290.dp, 73.dp) ,text = "Optymalizacja przychodów", textColor = LightGray, onClick = onOptPrzy, textStyle = Typography.headlineLarge.copy(fontSize = 20.sp))
        }
        
    }
}

@Preview
@Composable
private fun SelectTheoryScreenPreview() {
    SelectTheoryScreen()
}

//Metoda CPM,
//Metoda CPM-COST,
//Dobór optymalnego asortymentu produkcji,
//Optymalizacja rozkroju,
//Optymalizacja przychodów.

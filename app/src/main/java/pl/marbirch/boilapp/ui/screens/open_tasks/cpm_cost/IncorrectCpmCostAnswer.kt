package pl.marbirch.boilapp.ui.screens.open_tasks.cpm_cost

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.marbirch.boilapp.ui.default_component.AppButton
import pl.marbirch.boilapp.ui.roads.Roads
import pl.marbirch.boilapp.ui.theme.Cream
import pl.marbirch.boilapp.ui.theme.LightGray
import pl.marbirch.boilapp.ui.theme.Red
import pl.marbirch.boilapp.ui.theme.Typography


@Composable
fun IncorrectCpmCostAnswer(onRetry: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
            .fillMaxSize(), color = Cream
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(100.dp))
            Text(
                style = Typography.headlineLarge,
                textAlign = TextAlign.Center,
                text = "Niepoprawna",
                color = Red
            )
            Text(
                style = Typography.headlineLarge,
                textAlign = TextAlign.Center,
                text = "odpowiedz!",
                color = Red
            )
            Spacer(modifier = Modifier.padding(120.dp))
            AppButton(
                modifier = Modifier.size(290.dp, 73.dp),
                text = "Wróc do poprzedniego etapu!",
                textColor = LightGray,
                onClick = onRetry,
                textStyle = Typography.headlineLarge.copy(fontSize = 20.sp)
            )
        }
    }
}


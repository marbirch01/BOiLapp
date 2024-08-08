package pl.marbirch.boilapp.ui.default_component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.marbirch.boilapp.ui.theme.AppButtonColor
import pl.marbirch.boilapp.ui.theme.Brown
import pl.marbirch.boilapp.ui.theme.NavyBlue

@Composable
fun AppButton(text: String, modifier: Modifier = Modifier, textStyle: TextStyle = TextStyle(), onClick: () -> Unit = {}, textColor: Color) {
    ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(14.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 30.dp),
        colors = ButtonDefaults.buttonColors(containerColor = AppButtonColor)
    ) {
       Text(text = text, style = textStyle, color = textColor, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ButtonPreview() {
     AppButton(text = "Quiz", textColor = Color.White)
}
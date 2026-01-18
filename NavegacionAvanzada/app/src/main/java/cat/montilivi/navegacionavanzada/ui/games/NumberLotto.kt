package cat.montilivi.navegacionavanzada.ui.games

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.absoluteValue
import kotlin.random.Random

@Composable
fun RangeSelectionScreen(
    placeholderMinValue: Int,
    placeholderMaxValue: Int,
    onDrawClick: (Int, Int) -> Unit
) {
    var minNumber = remember{ mutableStateOf<Int?>(null) }
    var maxNumber = remember{ mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Sorteig Nombre",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = if(minNumber.value == null) "" else minNumber.value.toString(),
            onValueChange = {
                minNumber.value = it.toIntOrNull()?.absoluteValue;
            },
            label = { Text("Valor mínim") },
            placeholder = { Text(placeholderMinValue.toString()) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = if(maxNumber.value == null) "" else maxNumber.value.toString(),
            onValueChange = {
                maxNumber.value = it.toIntOrNull()?.absoluteValue;
            },
            label = { Text("Valor máxin") },
            placeholder = { Text(placeholderMaxValue.toString()) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                onDrawClick(minNumber.value ?: placeholderMinValue, maxNumber.value ?: placeholderMaxValue) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Triar Nombre")
        }
    }
}

@Composable
fun NumberLottoResultScreen(
    minValue: Int,
    maxValue: Int,
    onChangeRange: () -> Unit
) {
    var drawnNumber = remember { mutableStateOf(Random.nextInt(minValue, maxValue)) };

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "El nombre es:",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = drawnNumber.value.toString(),
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                drawnNumber.value = Random.nextInt(minValue, maxValue);
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Triar Altra Vegada")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onChangeRange,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Canviar Rang")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RangeSelectionPreview() {
    RangeSelectionScreen(
        2,
        100,
        { min, max -> },
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NumberLottoResultScreenPreview() {
    NumberLottoResultScreen(
        2,
        100,
        {}
    )
}

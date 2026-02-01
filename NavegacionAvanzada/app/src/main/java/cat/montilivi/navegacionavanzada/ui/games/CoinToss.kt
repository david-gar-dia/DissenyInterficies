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
import kotlin.random.Random

@Composable
fun CoinTossStartScreen(
    onTossClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Llançament de Moneda",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onTossClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Llançar Moneda")
        }
    }
}

@Composable
fun CoinTossResultScreen(
    onBackClick: () -> Unit
) {
    val isHead = remember { mutableStateOf(Random.nextBoolean()) }

    val numHeads = remember { mutableStateOf(if(isHead.value) 1 else 0) }
    val numTails = remember { mutableStateOf(if(!isHead.value) 1 else 0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Resultat",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = if(isHead.value) "Cara" else "Creu",
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Cara: ${numHeads.value} vegadas; Creu: ${numTails.value} vegadas",
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                isHead.value = Random.nextBoolean();

                if(isHead.value) {
                    numHeads.value++;
                }
                else {
                    numTails.value++;
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Llançar Altre Vegada")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sortir")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoinTossStartPreview() {
    CoinTossStartScreen(
        {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoinTossResultPreview() {
    CoinTossResultScreen(
        {}
    )
}
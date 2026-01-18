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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun OracleQuestionScreen(
    placeholderQuestionText: String,
    onAskClick: (String) -> Unit
) {
    val questionText = remember { mutableStateOf(placeholderQuestionText) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Pregunta a l'oracle",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = questionText.value,
            onValueChange = {
                questionText.value = it;
            },
            label = { Text("Escriu la teva pregunta") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onAskClick(questionText.value) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pregunta")
        }
    }
}

@Composable
fun OracleAnswerScreen(
    questionText: String,
    onAskAgainClick: () -> Unit,
    onBackClick: () -> Unit
) {
    val answersArray = listOf<String>(
        "És segur",
        "La resposta no és clara, torna-ho a intentar",
        "No hi comptis",
        "És decididament així",
        "Torna-ho a preguntar més tard",
        "La meva resposta és no",
        "Sense cap dubte",
        "Millor no dir-t’ho ara",
        "Les meves fonts diuen que no",
        "Sí, definitivament",
        "Ara no es pot predir",
        "Les perspectives no són bones",
        "Hi pots confiar",
        "Concentra’t i torna-ho a preguntar",
        "Molt dubtós",
        "Tal com ho veig, sí",
        "El més probable",
        "Les perspectives són bones",
        "Sí",
        "Els indicis apunten que sí"
    )

    val answerText = answersArray.get(Random.nextInt(0, answersArray.size));

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "La teva pregunta:",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = questionText,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "L'oracle diu:",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = answerText,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onAskAgainClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pregunta una Altra Pregunta")
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
fun OracleQuestionPreview() {
    OracleQuestionScreen(
        "Is this preview working?",
        {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OracleAnswerPreview() {
    OracleAnswerScreen(
        "Is this preview working?",
        {},
        {}
    )
}

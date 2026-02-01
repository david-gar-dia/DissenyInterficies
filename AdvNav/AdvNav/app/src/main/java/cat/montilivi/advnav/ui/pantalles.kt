package cat.montilivi.advnav.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaJoc(
    titol: String,
    dificil: Boolean = false,
    onAbandonar: () -> Unit,
    onPartidaAcabada: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // InformaciÃ³ del joc
        Text(
            text = titol + " JUGANT",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        var dificultat = "FÃ cil"
        if (dificil)
            dificultat = "DifÃ­cil"

        Text(
            text = "Dificultat: $dificultat",
            fontSize = 18.sp,
            color = if (dificultat.lowercase() == "difÃ­cil") Color.Red else Color.Green
        )

        Spacer(modifier = Modifier.height(40.dp))

        // SimulaciÃ³ de joc
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.LightGray.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center
        ) {
            Text("ðŸŽ®", fontSize = 40.sp)
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Botons
        Button(
            onClick = { onPartidaAcabada((100..1000).random()) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simular Fi de Partida")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onAbandonar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Abandonar Joc")
        }
    }
}

@Composable
fun PantallaJocResultats(
    titol:String,
    puntuacio: Int,
    dificultat: String,
    onTornarAJugar: () -> Unit,
    onMenu: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(titol + " PARTIDA ACABADA", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        Text("PuntuaciÃ³:", fontSize = 16.sp)
        Text("$puntuacio", fontSize = 48.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Dificultat: $dificultat")

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = onTornarAJugar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Tornar a Jugar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onMenu,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("MenÃº Principal")
        }
    }
}

@Composable
fun PantallaJocSeleccioDificultat(
    titol: String,
    onSeleccionarFacil: () -> Unit,
    onSeleccionarDificil: () -> Unit,
    onTornar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TÃ­tol
        Text(
            text = titol + " TRIAR DIFICULTAT",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // BotÃ³ FÃ€CIL
        Button(
            onClick = onSeleccionarFacil,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50)
            )
        ) {
            Text(
                text = "FÃ€CIL",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // DescripciÃ³ fÃ cil
        Text(
            text = "â€¢ PuntuaciÃ³ rÃ pida\nâ€¢ Menys enemics\nâ€¢ MÃ©s vides",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(40.dp))

        // BotÃ³ DIFÃCIL
        Button(
            onClick = onSeleccionarDificil,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF44336)
            )
        ) {
            Text(
                text = "DIFÃCIL",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // DescripciÃ³ difÃ­cil
        Text(
            text = "â€¢ Doble puntuaciÃ³\nâ€¢ MÃ©s enemics\nâ€¢ Una vida",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(60.dp))

        // BotÃ³ per tornar
        OutlinedButton(
            onClick = onTornar,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("TORNAR")
        }
    }
}

@Composable
fun PantallaLogin(onMostrarRegistre:()-> Unit,
                  onFerLogin:()-> Unit) {
    var usuari by remember { mutableStateOf("") }
    var contrasenya by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TÃ­tol
        Text(
            text = "Inici de SessiÃ³",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Camp d'usuari
        OutlinedTextField(
            value = usuari,
            onValueChange = { usuari = it },
            label = { Text("Usuari") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Camp de contrasenya
        OutlinedTextField(
            value = contrasenya,
            onValueChange = { contrasenya = it },
            label = { Text("Contrasenya") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // BotÃ³ d'iniciar sessiÃ³
        Button(
            onClick = {
                // AquÃ­ aniria la lÃ²gica d'inici de sessiÃ³
                println("Usuari: $usuari, Contrasenya: $contrasenya")
                onFerLogin()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Link per registrar-se
        TextButton(
            onClick = { onMostrarRegistre() }
        ) {
            Text("No tens compte? Registra't")
        }
    }
}

@Composable
fun PantallaRegistre(onTornar: () -> Unit, onRegistreCorrecte:()->Unit, titol: String="Registre") {
    var nom by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var usuari by rememberSaveable { mutableStateOf("") }
    var contrasenya by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TÃ­tol
        Text(
            text = titol,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Camp de nom
        OutlinedTextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Camp d'email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Camp d'usuari
        OutlinedTextField(
            value = usuari,
            onValueChange = { usuari = it },
            label = { Text("Usuari") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Camp de contrasenya
        OutlinedTextField(
            value = contrasenya,
            onValueChange = { contrasenya = it },
            label = { Text("Contrasenya") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // BotÃ³ de registrar
        Button(
            onClick = {
                // AquÃ­ aniria la lÃ²gica de registre
                println("Registre: Nom: $nom, Email: $email, Usuari: $usuari")
                onRegistreCorrecte()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar-me")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // BotÃ³ per tornar
        TextButton(
            onClick = onTornar
        ) {
            Text("Tornar a l'inici de sessiÃ³")
        }
    }
}

@Composable
fun PantallaRegistreExitos(onContinuar: () -> Unit,
                           onBack:()-> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        BackHandler() {
            onBack()
        }

        // Icona de check (podries posar una imatge real aquÃ­)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = Color(0xFF4CAF50).copy(alpha = 0.2f),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "âœ“",
                fontSize = 48.sp,
                color = Color(0xFF4CAF50)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Missatge d'Ã¨xit
        Text(
            text = "Registre completat!",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "El teu compte s'ha creat correctament.\nJa pots comenÃ§ar a jugar!",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(48.dp))

        // BotÃ³ per continuar
        Button(
            onClick = onContinuar,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Continuar")
        }
    }
}

@Composable
fun PantallaNomCognom(
    onCompletat: (nom: String, cognom: String) -> Unit
) {
    var nom by rememberSaveable() { mutableStateOf("") }
    var cognom by rememberSaveable() { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Dades personals",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = cognom,
            onValueChange = { cognom = it },
            label = { Text("Cognom") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onCompletat(nom, cognom) },
            enabled = nom.isNotBlank() && cognom.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar")
        }
    }
}

@Composable
fun PantallaNivellAcademic(
    onSeleccionat: (nivell: String) -> Unit
) {
    val opcions = listOf(
        "PrimÃ ria",
        "ESO",
        "Batxillerat",
        "Cicle Formatiu",
        "Universitat",
        "Postgrau",
        "Doctorat"
    )

    var seleccio by rememberSaveable() { mutableStateOf<String?>(null) }

    /*BackHandler {
        onBack()
    }*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Selecciona el teu nivell acadÃ¨mic",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = { seleccio?.let { onSeleccionat(it) } },
            enabled = seleccio != null,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar selecciÃ³")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            opcions.forEach { opcio ->
                Card(
                    onClick = { seleccio = opcio },
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = if (seleccio == opcio) {
                            MaterialTheme.colorScheme.primaryContainer
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        }
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = seleccio == opcio,
                            onClick = { seleccio = opcio }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = opcio,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PantallaFiFormulari(
    onNouFormulari:()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hem acabat el formulari",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onNouFormulari() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Nou formulari")
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun PantallaBenvingut(
    onComencar: () -> Unit
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TÃ­tol amb animaciÃ³ de desplaÃ§ament
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically() + fadeIn()
        ) {
            Text(
                "ðŸ‘‹ Benvingut!",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Missatge amb retard
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(
                initialOffsetY = { it / 2 }
            ) + fadeIn(animationSpec = tween(delayMillis = 1000))
        ) {
            Text(
                "EstÃ s a punt per comenÃ§ar",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 40.dp)
            )
        }

        // BotÃ³ amb mÃ©s retard
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(delayMillis = 1500))
        ) {
            Text("Selecciona un botÃ³ dels de la barra inferior")
        }
    }
}

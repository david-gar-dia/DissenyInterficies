package cat.montilivi.advnav.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import cat.montilivi.advnav.navegacio.DestiPantallaFiRegistre
import cat.montilivi.advnav.navegacio.DestiPantallaJocSeleccioDificultat
import cat.montilivi.advnav.navegacio.DestiPantallaLogin
import cat.montilivi.advnav.navegacio.DestiPantallaRegistre
import cat.montilivi.advnav.navegacio.HelperNavegacio
import cat.montilivi.advnav.navegacio.HostNavegacio

@Composable
fun ElMeuScaffold(controladorDeNavegacio: NavHostController, modifier: Modifier = Modifier){
    val ruta = controladorDeNavegacio.currentBackStackEntryAsState().value
    var esticALogin = HelperNavegacio.esticAlDesti(ruta, DestiPantallaLogin::class)
    var esticARegistre = HelperNavegacio.esticAlDesti(ruta, DestiPantallaRegistre::class)
    var esticAFiRegistre = HelperNavegacio.esticAlDesti(ruta, DestiPantallaFiRegistre::class)
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (!(esticARegistre || esticALogin || esticAFiRegistre))
            BottomBar(controladorDeNavegacio, ruta)
        }
    ) { padding ->
        HostNavegacio(modifier = modifier.padding(padding),
            controladorNav = controladorDeNavegacio)
    }
}

@Composable
fun BottomBar(controladorDeNavegacio: NavHostController, ruta: NavBackStackEntry?){
    var esPantallaJoc = HelperNavegacio.esticADestiJoc(ruta)
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = {controladorDeNavegacio.navigate(
                route = DestiPantallaJocSeleccioDificultat,
                builder = {launchSingleTop = true}
            )},
            icon = {Icon(Icons.Outlined.PlayArrow, "Joc1")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {controladorDeNavegacio.navigate(
                route = DestiPantallaJocSeleccioDificultat,
                builder = {launchSingleTop = true}
            )},
            icon = {Icon(Icons.Outlined.PlayArrow, "Joc2")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {controladorDeNavegacio.navigate(
                route = DestiPantallaJocSeleccioDificultat,
                builder = {launchSingleTop = true}
            )},
            icon = {Icon(Icons.Outlined.PlayArrow, "Joc3")
            }
        )
    }
}
package cat.montilivi.advnav.navegacio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import cat.montilivi.advnav.ui.PantallaBenvingut
import cat.montilivi.advnav.ui.PantallaJoc
import cat.montilivi.advnav.ui.PantallaJocResultats
import cat.montilivi.advnav.ui.PantallaJocSeleccioDificultat
import cat.montilivi.advnav.ui.PantallaLogin
import cat.montilivi.advnav.ui.PantallaRegistre
import cat.montilivi.advnav.ui.PantallaRegistreExitos
import kotlinx.serialization.Serializable

@Serializable
object DestiPantallaLogin
@Serializable
object DestiPantallaRegistre
@Serializable
object DestiPantallaFiRegistre
@Serializable
object DestiPantallaBenvingut
@Serializable
class DestiPantallaJoc(val dificil: Boolean)
@Serializable
object DestiPantallaJocResultats
@Serializable
object DestiPantallaJocSeleccioDificultat

@Composable
fun HostNavegacio(
    modifier: Modifier = Modifier,
    controladorNav: NavHostController
){
  NavHost(
      modifier = modifier,
      navController = controladorNav,
      startDestination = DestiPantallaLogin
  )  {
      composable<DestiPantallaLogin>{
          PantallaLogin(
              onMostrarRegistre = {controladorNav.navigate(DestiPantallaRegistre)},
              onFerLogin = {controladorNav.navigate(DestiPantallaBenvingut)}
          )
      }
      composable<DestiPantallaRegistre>{
          PantallaRegistre(
              onTornar = {controladorNav.popBackStack()},
              onRegistreCorrecte = { controladorNav.navigate(
                  route = DestiPantallaFiRegistre,
                  builder = {
                      popUpTo(DestiPantallaLogin) {
                          //Inclusive indica que passa si
                          inclusive = false
                      }
                  }
              )}
          )
      }
      composable<DestiPantallaFiRegistre>{
          PantallaRegistreExitos(
              onContinuar = {controladorNav.navigate(
                  route = DestiPantallaLogin,
                  builder = {
                      popUpTo(DestiPantallaLogin) {
                          //Inclusive indica que passa si
                          inclusive = false
                      }
                      launchSingleTop = true
                  }
              )}
          )
      }
      composable<DestiPantallaBenvingut>{
          PantallaBenvingut(
              onComencar = {}
          )
      }
      /*Nav Jocs*/
      composable<DestiPantallaJocSeleccioDificultat>{
          PantallaJocSeleccioDificultat(
              titol = "Joc1",
              onSeleccionarFacil = {controladorNav.navigate(DestiPantallaJoc(false))},
              onSeleccionarDificil = {controladorNav.navigate(DestiPantallaJoc(true))},
              onTornar = {}
          )
      }

      composable<DestiPantallaJoc>{
          var destiPantallaJoc: DestiPantallaJoc = it.toRoute()
          PantallaJoc(
              titol = "Joc1",
              dificil = destiPantallaJoc.dificil,
              onAbandonar = {},
              onPartidaAcabada = {controladorNav.navigate(
                  route = DestiPantallaJocResultats,
                      builder = {
                          popUpTo(DestiPantallaJocSeleccioDificultat) {
                              inclusive = false
                          }
                          launchSingleTop = true
                      }
                  )
              }
          )
      }
      composable<DestiPantallaJocResultats>{
          PantallaJocResultats(
              titol = "Joc1",
              puntuacio = 10,
              dificultat = "Facil",
              onTornarAJugar = {},
              onMenu = {}
          )
      }
  }
}

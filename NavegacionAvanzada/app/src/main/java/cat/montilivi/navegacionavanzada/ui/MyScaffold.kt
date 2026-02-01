package cat.montilivi.navegacionavanzada.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import cat.montilivi.navegacionavanzada.navigation.CoinTossResultScreenDestination
import cat.montilivi.navegacionavanzada.navigation.CoinTossStartScreenDestination
import cat.montilivi.navegacionavanzada.navigation.HostNavegacio
import cat.montilivi.navegacionavanzada.navigation.LoginScreenDestination
import cat.montilivi.navegacionavanzada.navigation.NavigationHelper
import cat.montilivi.navegacionavanzada.navigation.NumberLottoResultScreenDestination
import cat.montilivi.navegacionavanzada.navigation.OracleAnswerScreenDestination
import cat.montilivi.navegacionavanzada.navigation.OracleQuestionScreenDestination
import cat.montilivi.navegacionavanzada.navigation.RangeSelectionScreenDestination
import cat.montilivi.navegacionavanzada.navigation.RegisterScreenDestination
import cat.montilivi.navegacionavanzada.navigation.SuccessfulRegisterScreenDestination
import cat.montilivi.navegacionavanzada.navigation.WelcomeScreenDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(navigationController: NavHostController, modifier: Modifier = Modifier){
    val route = navigationController.currentBackStackEntryAsState().value

    val isAtLogin = NavigationHelper.isAtDestination(route, LoginScreenDestination::class)
    val isAtRegister = NavigationHelper.isAtDestination(route, RegisterScreenDestination::class)
    val isAtPostRegister = NavigationHelper.isAtDestination(route,
        SuccessfulRegisterScreenDestination::class)
    val isAtGame = NavigationHelper.isAtDestinationGame(route)

    val isAtNumberLotto = NavigationHelper.isInDestinations(route,
        listOf(RangeSelectionScreenDestination::class,
            NumberLottoResultScreenDestination::class));
    val isAtCoinToss = NavigationHelper.isInDestinations(route,
        listOf(CoinTossStartScreenDestination::class,
            CoinTossResultScreenDestination::class))
    val isAtOracle = NavigationHelper.isInDestinations(route,
        listOf(OracleQuestionScreenDestination::class,
            OracleAnswerScreenDestination::class))

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if(isAtGame) {
                TopAppBar(
                    title = { Text(
                        if(isAtNumberLotto) {
                            "Sorteig Nombre"
                        }
                        else if(isAtCoinToss) {
                            "Cara o Creu"
                        }
                        else if(isAtOracle) {
                            "Oracle"
                        }
                        else {
                            "Undefined"
                        }
                    )},
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navigationController.popBackStack()
                            },
                            enabled = true,
                        )
                        {
                            Icon(
                                Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
                                "Back"
                            )
                        }
                    },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
            }
        },
        bottomBar = {
            if (!(isAtRegister || isAtLogin || isAtPostRegister))
                BottomBar(navigationController)
        }
    ) { padding ->
        HostNavegacio(modifier = modifier.padding(padding),
            navController = navigationController)
    }
}

@Composable
fun BottomBar(navigationController: NavHostController){
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = {navigationController.navigate(
                route = RangeSelectionScreenDestination,
                builder = {
                    popUpTo(WelcomeScreenDestination) {
                        inclusive = false;
                    }
                    launchSingleTop = true;
                }
            )},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Icon(Icons.Outlined.PlayArrow, "Sorteig Nombre")
                    Text(
                        text = "Sorteig Nombre",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {navigationController.navigate(
                route = CoinTossStartScreenDestination,
                builder = {
                    popUpTo(WelcomeScreenDestination) {
                        inclusive = false;
                    }
                    launchSingleTop = true
                }
            )},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Icon(Icons.Outlined.PlayArrow, "Cara o Creu")
                    Text(
                        text = "Cara o Creu",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {navigationController.navigate(
                route = OracleQuestionScreenDestination,
                builder = {
                    popUpTo(WelcomeScreenDestination) {
                        inclusive = false;
                    }
                    launchSingleTop = true
                }
            )},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Icon(Icons.Outlined.PlayArrow, "Oracle")
                    Text(
                        text = "Oracle",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
    }
}

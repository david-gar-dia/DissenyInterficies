package cat.montilivi.navegacionavanzada.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import cat.montilivi.navegacionavanzada.ui.LoginScreen
import cat.montilivi.navegacionavanzada.ui.RegisterScreen
import cat.montilivi.navegacionavanzada.ui.SuccessfulRegisterScreen
import cat.montilivi.navegacionavanzada.ui.WelcomeScreen
import cat.montilivi.navegacionavanzada.ui.games.CoinTossResultScreen
import cat.montilivi.navegacionavanzada.ui.games.CoinTossStartScreen
import cat.montilivi.navegacionavanzada.ui.games.NumberLottoResultScreen
import cat.montilivi.navegacionavanzada.ui.games.OracleAnswerScreen
import cat.montilivi.navegacionavanzada.ui.games.OracleQuestionScreen
import cat.montilivi.navegacionavanzada.ui.games.RangeSelectionScreen
import kotlinx.serialization.Serializable

@Serializable
object LoginScreenDestination
@Serializable
object RegisterScreenDestination
@Serializable
object SuccessfulRegisterScreenDestination
@Serializable
object WelcomeScreenDestination
@Serializable
object RangeSelectionScreenDestination
@Serializable
class NumberLottoResultScreenDestination(val minValue: Int, val maxValue: Int)
@Serializable
object CoinTossStartScreenDestination
@Serializable
object CoinTossResultScreenDestination
@Serializable
object OracleQuestionScreenDestination
@Serializable
class OracleAnswerScreenDestination(val question: String)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HostNavegacio(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = LoginScreenDestination
    )  {
        composable<LoginScreenDestination>{
            LoginScreen(
                onShowRegistre = {navController.navigate(RegisterScreenDestination)},
                onLogin = {navController.navigate(WelcomeScreenDestination)}
            )
        }

        composable<RegisterScreenDestination>{
            RegisterScreen(
                onReturn = {navController.popBackStack()},
                onSuccessfulRegister = { navController.navigate(
                    route = SuccessfulRegisterScreenDestination,
                    builder = {
                        popUpTo(LoginScreenDestination) {
                            inclusive = false
                        }
                    }
                )}
            )
        }

        composable<SuccessfulRegisterScreenDestination>{
            SuccessfulRegisterScreen(
                onContinue = {navController.navigate(
                    route = LoginScreenDestination,
                    builder = {
                        popUpTo(LoginScreenDestination) {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                )}
            )
        }

        composable<WelcomeScreenDestination>{
            WelcomeScreen()
        }

        composable<RangeSelectionScreenDestination>{
            RangeSelectionScreen(
                placeholderMinValue = 1,
                placeholderMaxValue = 100,
                onDrawClick = { min, max ->
                    navController.navigate(
                        route = NumberLottoResultScreenDestination(min, max),
                        builder = {
                            popUpTo(WelcomeScreenDestination) {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    )
                }
            )
        }

        composable<NumberLottoResultScreenDestination>{
            val args = it.toRoute<NumberLottoResultScreenDestination>();
            NumberLottoResultScreen(
                minValue = args.minValue,
                maxValue = args.maxValue,
                onChangeRange = {
                    navController.navigate(RangeSelectionScreenDestination) {
                        popUpTo(WelcomeScreenDestination) {
                            inclusive = false;
                        }
                        launchSingleTop = true;
                    };
                }
            )
        }

        composable<CoinTossStartScreenDestination>{
            CoinTossStartScreen(
                onTossClick = {
                    navController.navigate(
                        route = CoinTossResultScreenDestination,
                        builder = {
                            popUpTo(WelcomeScreenDestination) {
                                inclusive = false;
                            }
                            launchSingleTop = true;
                        }
                    )
                }
            )
        }

        composable<CoinTossResultScreenDestination>{
            CoinTossResultScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable<OracleQuestionScreenDestination>{
            OracleQuestionScreen(
                placeholderQuestionText = "Això funciona?",
                onAskClick = { question ->
                    navController.navigate(
                        route = OracleAnswerScreenDestination(question),
                        builder = {
                            popUpTo(WelcomeScreenDestination) {
                                inclusive = false;
                            }
                            launchSingleTop = true;
                        }
                    )
                }
            )
        }

        composable<OracleAnswerScreenDestination>{
            val args = it.toRoute<OracleAnswerScreenDestination>();
            OracleAnswerScreen(
                questionText = args.question,
                onAskAgainClick = {
                    navController.navigate(
                        route = OracleQuestionScreenDestination,
                        builder = {
                            popUpTo(WelcomeScreenDestination) {
                                inclusive = false;
                            }
                            launchSingleTop = true;
                        }
                    )
                },
                onBackClick = {
                    navController.popBackStack();
                }
            )
        }
    }
}
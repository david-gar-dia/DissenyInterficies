package cat.montilivi.navegacionavanzada.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import kotlin.reflect.KClass


class NavigationHelper() {

    companion object {

        fun isAtDestination(navigationState: NavBackStackEntry?, destination: KClass<*>): Boolean{
            return (navigationState?.destination?.hasRoute(
                destination) ?: false)
        }
        fun isInDestinations(navigationState: NavBackStackEntry?,
                             destinationsList:List<KClass<*>>):Boolean{
            var destination = navigationState?.destination
            val foundDestination = destinationsList.find({
                destination?.hasRoute(it)?:false
            })
            return(foundDestination != null)
        }
        fun isAtDestinationGame(navigationState: NavBackStackEntry?): Boolean{
            return isInDestinations(navigationState, listOf(
                RangeSelectionScreenDestination::class,
                NumberLottoResultScreenDestination::class,
                CoinTossStartScreenDestination::class,
                CoinTossResultScreenDestination::class,
                OracleQuestionScreenDestination::class,
                OracleAnswerScreenDestination::class))
        }
    }
}
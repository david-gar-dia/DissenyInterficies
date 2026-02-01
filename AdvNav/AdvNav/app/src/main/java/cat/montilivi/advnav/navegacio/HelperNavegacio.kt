package cat.montilivi.advnav.navegacio

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import kotlin.reflect.KClass

/***
 *  Classe que ajuda en la navegació.
 */
class HelperNavegacio() {

    //Objecte static (companion en kotlin)
    companion object {

        fun esticAlDesti(estatNavegacio: NavBackStackEntry?, desti: KClass<*>): Boolean{
            return (estatNavegacio?.destination?.hasRoute(
                desti) ?: false)
        }
        fun esticAUnDelDestins(estatNavegacio: NavBackStackEntry?,
                               llistatDestinacions:List<KClass<*>>):Boolean{
            var desti = estatNavegacio?.destination
            val destiTrobat = llistatDestinacions.find({
                desti?.hasRoute(it)?:false
            })
            return(destiTrobat != null)
        }
        fun esticADestiJoc(estatNavegacio: NavBackStackEntry?){
            esticAUnDelDestins(estatNavegacio, listOf(
                DestiPantallaJoc::class,
                DestiPantallaJocSeleccioDificultat::class,
                DestiPantallaJocResultats::class))
        }
    }
}
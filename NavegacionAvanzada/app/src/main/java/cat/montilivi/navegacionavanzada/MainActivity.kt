package cat.montilivi.navegacionavanzada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import cat.montilivi.navegacionavanzada.ui.MyScaffold
import cat.montilivi.navegacionavanzada.ui.theme.NavegacionAvanzadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacionAvanzadaTheme() {
                var navController = rememberNavController()
                MyScaffold(navController)
            }
        }
    }
}
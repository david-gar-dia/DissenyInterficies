package cat.montilivi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import cat.montilivi.ui.MissionsApp
import cat.montilivi.ui.theme.MissionScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MissionScreenTheme {
                MissionsApp()
            }
        }
    }
}

@Composable
fun Previsualize(content: @Composable () -> Unit = {}) {
    MissionScreenTheme {
         content()
    }
}
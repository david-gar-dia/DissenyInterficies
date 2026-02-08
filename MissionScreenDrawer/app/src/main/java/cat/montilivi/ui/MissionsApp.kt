package cat.montilivi.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MissionsApp() {
    val navigationController = rememberNavController();
    AppDrawer(navigationController);
}
package cat.montilivi.ui

import androidx.compose.runtime.Composable
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import cat.montilivi.model.enums.NavigationType

@Composable
fun MissionsApp() {
    val navigationController = rememberNavController();
    val navigationType: NavigationType = NavigationType.TABS;

    when(navigationType) {
        NavigationType.DRAWER -> AppDrawer(navigationController);
        NavigationType.TABS -> AppTabs();
    }
}
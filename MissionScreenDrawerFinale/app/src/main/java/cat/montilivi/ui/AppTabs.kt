package cat.montilivi.ui

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppTabs(navigationController: NavHostController) {
    val navigationState = navigationController.currentBackStackEntryAsState();
    val currentDestination = navigationState.value?.destination;
    val selectedTab = rememberSaveable{ mutableIntStateOf(0) }

    MyTabsScaffold(
        navigationController,
        currentDestination,
        selectedTab
    )
}
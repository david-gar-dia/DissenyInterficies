package cat.montilivi.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.window.core.layout.WindowSizeClass
import cat.montilivi.ui.navigation.NavigateZoneListScreen
import cat.montilivi.ui.navigation.NavigationGraphNavigationBar
import cat.montilivi.ui.navigation.navigationSubGraphButtons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(navigationController: NavHostController) {
    val navigationState = navigationController.currentBackStackEntryAsState();
    val currentDestination = navigationState.value?.destination;

    val windowInfo = currentWindowAdaptiveInfo()
    val isWiderThanMedium = windowInfo.windowSizeClass
        .isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.primaryContainer
                ),
                navigationIcon = {
                    val mainScreen =
                        navigationState.value?.destination?.hasRoute(NavigateZoneListScreen::class)
                            ?: false
                    IconButton(onClick = {
                        if (!mainScreen)
                            navigationController.navigateUp()
                    }) {
                        Icon(
                            imageVector = if (mainScreen)
                                Icons.Default.Home
                            else
                                Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Home"
                        )
                    }
                },
                title = {
                    Text(
                        text = "Missions App",
                        modifier = Modifier
                            .clickable(
                                enabled = true,
                                onClick = {
                                    navigationController.navigate(NavigateZoneListScreen)
                                }
                            ))
                }
            )
        },
        bottomBar = {
            if(!isWiderThanMedium)
            {
                NavigationBar {
                    navigationSubGraphButtons.forEach { button ->
                        var selected = currentDestination?.hierarchy?.any { navDestination ->
                            navDestination.hasRoute(button.route::class)
                        } == true

                        NavigationBarItem(
                            selected = selected,
                            icon = {
                                Icon(
                                    imageVector = if (selected) button.selectedIcon else button.unselectedIcon,
                                    contentDescription = button.title
                                )

                            },
                            onClick = {
                                navigationController.navigate(button.route) {
                                    popUpTo(navigationController.graph.findStartDestination().id) {
                                        inclusive = false
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        if(isWiderThanMedium)
        {
            Row(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                NavigationRail() {
                    navigationSubGraphButtons.forEach { button ->
                        var selected = currentDestination?.hierarchy?.any{ navDestination ->
                            navDestination.hasRoute(button.route::class)} == true

                        NavigationRailItem(
                            selected = selected,
                            icon = {
                                Icon(
                                    imageVector = if(selected) button.selectedIcon else button.unselectedIcon,
                                    contentDescription = button.title
                                )

                            },
                            onClick = {
                                navigationController.navigate(button.route) {
                                    popUpTo(navigationController.graph.findStartDestination().id){
                                        inclusive = false
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
                NavigationGraphNavigationBar(
                    navController = navigationController
                )
            }
        }
        else
        {
            NavigationGraphNavigationBar(
                navController = navigationController
            )
        }
    }
}
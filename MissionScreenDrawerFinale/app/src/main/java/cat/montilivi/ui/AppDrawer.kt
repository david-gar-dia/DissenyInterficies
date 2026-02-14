package cat.montilivi.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import cat.montilivi.R
import cat.montilivi.ui.navigation.EntityListDestination
import cat.montilivi.ui.navigation.MissionListDestination
import cat.montilivi.ui.navigation.ZoneListDestination
import cat.montilivi.ui.navigation.drawerTags
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(navigationController: NavHostController) {
    val navigationState = navigationController.currentBackStackEntryAsState();
    val currentDestination = navigationState.value?.destination;

    val drawerState = rememberDrawerState(DrawerValue.Closed);
    val coroutineAmbit = rememberCoroutineScope();

    CompleteNavigationDrawer(
        navigationController,
        navigationState.value,
        currentDestination,
        drawerState,
        coroutineAmbit
    )
}

@Composable
fun CompleteNavigationDrawer(
    navigationController: NavHostController,
    currentRoute: NavBackStackEntry?,
    currentDestination: NavDestination?,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope
) {
    ModalNavigationDrawer(
        gesturesEnabled = listOf(
                ZoneListDestination::class,
                EntityListDestination::class,
                MissionListDestination::class
            ).any {
                currentDestination?.hasRoute(it) ?: false;
            },
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = ShapeDefaults.Small,
                drawerContainerColor = MaterialTheme.colorScheme.background,
                drawerContentColor = MaterialTheme.colorScheme.onBackground,
                drawerTonalElevation = 8.dp,
                windowInsets = WindowInsets(
                    left = 24.dp,
                    right = 24.dp,
                    top = 48.dp,
                    bottom = 48.dp
                )
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.logomontilivi),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3F)
                )
                Spacer(modifier  = Modifier.height(48.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(modifier  = Modifier.height(48.dp))

                drawerTags.forEach { tag ->
                    val selected = currentDestination?.hierarchy?.any{ navDestination ->
                        navDestination.hasRoute(tag.route::class)} == true
                    NavigationDrawerItem(
                        label = { Text(
                            text = tag.title,
                            fontWeight = if(selected) FontWeight.Bold else FontWeight.Normal
                        ) },
                        selected = selected,
                        icon = {
                            Icon(
                                imageVector = if(selected) tag.selectedIcon else tag.unselectedIcon,
                                contentDescription = tag.title
                            )
                        },
                        onClick = {
                            navigationController.navigate(tag.route) {
                                popUpTo(navigationController.graph.findStartDestination().id){
                                    inclusive = false
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedIconColor = colorScheme.onTertiaryContainer,
                            selectedTextColor = colorScheme.onTertiaryContainer,
                            selectedContainerColor = colorScheme.tertiaryContainer,
                            unselectedIconColor = colorScheme.onSecondaryContainer,
                            unselectedTextColor = colorScheme.onSecondaryContainer,
                            unselectedContainerColor = colorScheme.secondaryContainer,
                            unselectedBadgeColor = tag.badgeTint,
                            selectedBadgeColor = tag.badgeTint
                        ),
                        badge = {
                            if (tag.hasBadge)
                                Icon(imageVector = tag.badgeIcon, contentDescription = "badge")
                        },
                        shape = ShapeDefaults.Medium
                    )
                }
            }
        }
    ) {
        MyDrawerScaffold(
            navigationController,
            currentDestination,
            drawerState,
            coroutineScope,
            false
        )
    }
}


package cat.montilivi.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.model.Mission
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.navigation.CoverScreenDestination
import cat.montilivi.ui.navigation.NavigationGraphComplete
import cat.montilivi.ui.navigation.tabTags
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawerScaffold(navigationController: NavHostController,
                     currentDestination: NavDestination?,
                     drawerState: DrawerState,
                     coroutineScope: CoroutineScope,
                     tabEnabled: Boolean) {
    val navigationState = navigationController.currentBackStackEntryAsState();
    val currentDestination = navigationState.value?.destination;

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.primaryContainer
                ),
                navigationIcon = {
                    val mainScreen =
                        navigationState.value?.destination?.hasRoute(CoverScreenDestination::class)
                            ?: false
                    IconButton(onClick = {
                        coroutineScope.launch {
                            if(drawerState.isOpen)
                                drawerState.close();
                            else
                                drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Open Drawer"
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
                                    navigationController.navigate(CoverScreenDestination) {
                                        popUpTo(navigationController.graph.findStartDestination().id){
                                            inclusive = false
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                    )
                }
            )
        }
    ) { innerPadding ->
        if(tabEnabled) {
            val tabSelected = rememberSaveable{ mutableIntStateOf(0) }
            PrimaryTabRow(
                selectedTabIndex = tabSelected.intValue,
                modifier = Modifier.padding(innerPadding)
            )
            {
                tabTags.forEachIndexed { index, tag ->
                    val selected = tabSelected.intValue == index;
                    Tab(
                        text = { Text(
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
                            tabSelected.intValue = index
                        },
                    )
                }
            }
        }
        NavigationGraphComplete(
            navController = navigationController,
            paddingValues = innerPadding
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTabsScaffold()
{
    val missions by remember {
        mutableStateOf(
            factoryDaoMissions.createDao(Origin.MEMORY)
                .obtenTots()
                .filterIndexed {index, mission ->
                    index < 6
                })
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.primaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Roots"
                        )
                    }
                },
                title = {
                    Text(text = "Missions App")
                }
            )
        }
    ) { innerPadding ->
        CompletePager(modifier = Modifier.padding(innerPadding), missions)
    }
}

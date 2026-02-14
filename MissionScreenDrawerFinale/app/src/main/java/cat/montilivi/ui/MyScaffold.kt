package cat.montilivi.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
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
fun MyTabsScaffold(
    navigationController: NavHostController,
    currentDestination: NavDestination?,
    tabSelected: MutableIntState,
                   ) {
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
                        if(!mainScreen)
                            navigationController.popBackStack()
                    }) {
                        Icon(
                            imageVector = if(mainScreen) Icons.Default.Home else Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = if(mainScreen) "" else "Go back"
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
        Column(modifier = Modifier.padding(innerPadding))
        {
            ScrollableTabRow(
                selectedTabIndex = tabSelected.intValue,
                edgePadding = 0.dp
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
            NavigationGraphComplete(
                navController = navigationController
            )
        }
    }
}

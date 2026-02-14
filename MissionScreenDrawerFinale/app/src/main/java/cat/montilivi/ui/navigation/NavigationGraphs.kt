package cat.montilivi.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.montilivi.data.factoryDaoEntities
import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.data.factoryDaoZones
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.pantalles.CoverScreen
import cat.montilivi.ui.pantalles.EntityDetailsScreen
import cat.montilivi.ui.pantalles.EntityListScreen
import cat.montilivi.ui.pantalles.IntructionsScreen
import cat.montilivi.ui.pantalles.MissionDetailsScreen
import cat.montilivi.ui.pantalles.MissionListScreen
import cat.montilivi.ui.pantalles.PreferencesScreen
import cat.montilivi.ui.pantalles.WhenAtScreen
import cat.montilivi.ui.pantalles.ZoneDetailsScreen
import cat.montilivi.ui.pantalles.ZoneListScreen


//region Drawer's Navigation Graph
@Composable
fun NavigationGraphComplete(
    navController: NavHostController = rememberNavController(),
    paddingValues: PaddingValues = PaddingValues(0.dp)
)
{
    NavHost(
        navController = navController,
        startDestination = CoverScreenDestination,
        modifier = Modifier
            .padding(paddingValues)
    )
    {
        navigation<SubGraphZoneList>(startDestination = ZoneListDestination) {
            ZonesSubGraph(navController);
        }
        navigation<SubGraphEntityList>(startDestination = EntityListDestination)
        {
            EntitiesSubGraph(navController);
        }
        navigation<SubGraphMissionList>(startDestination = MissionListDestination)
        {
            MissionsSubGraph(navController);
        }
        composable<CoverScreenDestination>{
            CoverScreen(onClick = {})
        }
        composable<InstructionsScreenDestination>{
            IntructionsScreen()
        }
        composable<PreferencesScreenDestination>{
            PreferencesScreen()
        }
        composable<WhenAtScreenDestination>{
            WhenAtScreen()
        }
    }
}
//endregion

//region Navigation Graphs

fun NavGraphBuilder.ZonesSubGraph(navController: NavHostController) {

    composable<ZoneListDestination>{
        val zoneList = factoryDaoZones.createDao(Origin.MEMORY).obtenTots()
        ZoneListScreen(
            zoneList = zoneList,
            onZoneClick = {
                navController.navigate(
                    ZoneDetailsScreenDestination(it.id.toString())
                )
            }
        )
    }
    composable<ZoneDetailsScreenDestination>{
        val args = it.toRoute<ZoneDetailsScreenDestination>();
        ZoneDetailsScreen(
            zoneId = args.zone,
            onNavigateToEntity = {
                navController.navigate(
                    EntityDetailsScreenDestination(it.id.toString())
                )
            }
        )
    }
}

fun NavGraphBuilder.EntitiesSubGraph(navController: NavHostController) {

    composable<EntityListDestination>{
        val entityList = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()
        val zonesMap = entityList.associate{it.id to it.name}
        EntityListScreen(
            entityList = entityList,
            zonesMap = zonesMap,
            onEntityClick = {
                navController.navigate(
                    EntityDetailsScreenDestination(it.id.toString())
                )
            }
        )
    }
    composable<EntityDetailsScreenDestination>{
        val args = it.toRoute<EntityDetailsScreenDestination>();
        EntityDetailsScreen(
            entityId = args.entity,
            onNavigateToMission = {
                navController.navigate(
                    MissionDetailsScreenDestination(it.id.toString())
                )
            }
        )
    }
}

fun NavGraphBuilder.MissionsSubGraph(navController: NavHostController) {

    composable<MissionListDestination>{
        val missionList = factoryDaoMissions.createDao(Origin.MEMORY).obtenTots()
        val entityMap = missionList.associate{it.id to it.solicitant}
        MissionListScreen(
            missionList = missionList,
            entityMap = entityMap,
            onMissionClick = {
                navController.navigate(
                    MissionDetailsScreenDestination(it.id.toString())
                )
            }
        )
    }
    composable<MissionDetailsScreenDestination>{
        val args = it.toRoute<MissionDetailsScreenDestination>();
        MissionDetailsScreen(
            missionId = args.mission
        )
    }
}

//endregion

//endregion
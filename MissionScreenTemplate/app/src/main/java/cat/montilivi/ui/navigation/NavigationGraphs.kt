package cat.montilivi.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cat.montilivi.data.factoryDaoEntities
import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.data.factoryDaoZones
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.pantalles.EntityDetailsScreen
import cat.montilivi.ui.pantalles.EntityListScreen
import cat.montilivi.ui.pantalles.MissionDetailsScreen
import cat.montilivi.ui.pantalles.MissionListScreen
import cat.montilivi.ui.pantalles.ZoneDetailsScreen
import cat.montilivi.ui.pantalles.ZoneListScreen

//region Navigation Graphs

//endregion

//region Navigation Bar

@Composable
fun NavigationGraphNavigationBar(
    navController: NavHostController = rememberNavController(),
    paddingValues: PaddingValues = PaddingValues(0.dp)
)
{
    NavHost(
        navController = navController,
        startDestination = SubGraphZoneList,
        modifier = Modifier
            .padding(paddingValues)
    )
    {
        ZonesSubGraph(navController);
        EntitiesSubGraph(navController);
        MissionsSubGraph(navController);
    }
}

fun NavGraphBuilder.ZonesSubGraph(navController: NavHostController) {
    navigation<SubGraphZoneList>(
        startDestination = ZoneListDestination
    )
    {
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
}

fun NavGraphBuilder.EntitiesSubGraph(navController: NavHostController) {
    navigation<SubGraphEntityList>(
        startDestination = EntityListDestination
    )
    {
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
}

fun NavGraphBuilder.MissionsSubGraph(navController: NavHostController) {
    navigation<SubGraphMissionList>(
        startDestination = MissionListDestination
    )
    {
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
}

//endregion
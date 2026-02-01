package cat.montilivi.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Terrain
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
import kotlinx.serialization.Serializable


@Serializable
object NavigateZoneListScreen
@Serializable
object NavigateEntityListScreen
@Serializable
object NavigateMissionListScreen
@Serializable
data class NavigateZoneDetailsScreen(val zone: String)
@Serializable
data class NavigateEntityDetailsScreen(val entity: String)
@Serializable
data class NavigateMissionDetailsScreen(val mission: String)

//region Navigation Bar

//region Subgraph Definitions

@Serializable
object SubGraphZoneList
@Serializable
object SubGraphEntityList
@Serializable
object SubGraphMissionList

//endregion

//region Graphs Screens Destinations

@Serializable
object ZoneListDestination
@Serializable
object EntityListDestination
@Serializable
object MissionListDestination

@Serializable
data class ZoneDetailsScreenDestination(val zone: String)
@Serializable
data class EntityDetailsScreenDestination(val entity: String)
@Serializable
data class MissionDetailsScreenDestination(val mission: String)

//endregion

data class NavigationSubGraphButton<T:Any>(
    val route:T,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

val navigationSubGraphButtons = listOf(
    NavigationSubGraphButton(
        SubGraphZoneList,
        "Zones",
        Icons.Filled.Terrain,
        Icons.Outlined.Terrain
    ),
    NavigationSubGraphButton(
        SubGraphEntityList,
        "Entities",
        Icons.Filled.Person,
        Icons.Outlined.Person
    ),
    NavigationSubGraphButton(
        SubGraphMissionList,
        "Missions",
        Icons.Filled.CheckCircle,
        Icons.Outlined.CheckCircle
    )
)

//endregion

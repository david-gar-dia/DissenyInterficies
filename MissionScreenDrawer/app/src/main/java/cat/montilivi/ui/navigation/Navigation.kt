package cat.montilivi.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.material.icons.outlined.Adb
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Terrain
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.toColorLong
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

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

@Serializable
object PreferencesScreenDestination
@Serializable
object InstructionsScreenDestination
@Serializable
object WhenAtScreenDestination
@Serializable
object CoverScreenDestination

//endregion

data class NavigationDrawerTags<T: Any> (
    val route: T,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean = false,
    val badgeIcon: ImageVector = Icons.Default.Badge,
    val badgeTint: Color = Color.Red
)

val drawerTags = listOf(
    NavigationDrawerTags(CoverScreenDestination,"Cover",Icons.Filled.Home,Icons.Outlined.Home),
    NavigationDrawerTags(SubGraphZoneList,"Zones",Icons.Filled.Terrain,Icons.Outlined.Terrain),
    NavigationDrawerTags(SubGraphEntityList,"Entities",Icons.Filled.Person,Icons.Outlined.Person),
    NavigationDrawerTags(SubGraphMissionList,"Missions",Icons.Filled.CheckCircle,Icons.Outlined.Check,
        true, Icons.Default.AutoAwesome, Color(0, 255, 0)),
    NavigationDrawerTags(InstructionsScreenDestination,"Instructions",Icons.Filled.Info,Icons.Outlined.Info),
    NavigationDrawerTags(WhenAtScreenDestination,"When at...",Icons.Filled.Adb,Icons.Outlined.Adb),
    NavigationDrawerTags(PreferencesScreenDestination,"Preferences",Icons.Filled.Build,Icons.Outlined.Build)
)

//endregion

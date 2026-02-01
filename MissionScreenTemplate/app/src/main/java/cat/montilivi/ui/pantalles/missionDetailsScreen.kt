package cat.montilivi.ui.pantalles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import cat.montilivi.Previsualize
import cat.montilivi.data.factoryDaoEntities
import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.model.Entity
import cat.montilivi.model.Mission
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.componibles.MissionHeader
import cat.montilivi.ui.componibles.MissionInformationBlock
import cat.montilivi.ui.componibles.MissionSpecificationsBlock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MissionDetailsScreen(
    missionId: String,
    modifier: Modifier = Modifier,
) {
    var currentMission by remember { mutableStateOf<Mission?>(null) }
    var acceptedBy by remember { mutableStateOf<Entity?>(null) }
    var loadingError by remember { mutableStateOf(false) }

    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Information", "Specifications")

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val mission = factoryDaoMissions.createDao(Origin.MEMORY).obtenPerID(missionId.toInt());

            if (mission == null) {
                loadingError = true
            } else {
                val entity = factoryDaoEntities.createDao(Origin.MEMORY)
                    .obtenPerID(mission.acceptedBy);
                acceptedBy = entity;

                currentMission = mission;
            }
        }
    }

    if (loadingError) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Error 404: Mission not Found.", color = MaterialTheme.colorScheme.error)
        }
    } else {
        val mission = currentMission;
        if (mission == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Loading...",
                    fontWeight = FontWeight.ExtraBold)
            }
        } else {
            Column(modifier = modifier.fillMaxSize()) {

                MissionHeader(mission = mission, acceptedBy)

                TabRow(selectedTabIndex = tabIndex) {
                    tabs.forEachIndexed { index, titol ->
                        Tab(
                            text = { Text(titol) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index }
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    when (tabIndex) {
                        0 -> MissionInformationBlock(mission)
                        1 -> MissionSpecificationsBlock(mission)
                    }
                    Spacer(Modifier.height(32.dp))
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true,
    wallpaper = Wallpapers.NONE
)
@Composable
fun PreviewScreenMission() {
    val mission =
        factoryDaoMissions.createDao(Origin.MEMORY).obtenTots()[69]

    Previsualize {
        MissionDetailsScreen(
            missionId = mission.id.toString(),
        )
    }
}
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
import cat.montilivi.data.factoryDaoZones
import cat.montilivi.model.Entity
import cat.montilivi.model.Mission
import cat.montilivi.model.Zone
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.componibles.EntityHeader
import cat.montilivi.ui.componibles.EntityRelationsBlock
import cat.montilivi.ui.componibles.EntityStatisticsBlock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntityDetailsScreen(
    entityId: String,
    onNavigateToMission: (Mission) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentEntity by remember { mutableStateOf<Entity?>(null) }
    var currentLocation by remember { mutableStateOf<Zone?>(null) }
    var loadingError by remember { mutableStateOf(false) }

    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Statistics", "Relations")

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenPerID(entityId.toInt());

            if (entity == null) {
                loadingError = true
            } else {
                val zone = factoryDaoZones.createDao(Origin.MEMORY)
                    .obtenPerID(entity.currentZoneLocation);
                currentLocation = zone;

                currentEntity = entity;
            }
        }
    }

    if (loadingError) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Error 404: Entity not Found.", color = MaterialTheme.colorScheme.error)
        }
    } else {
        val entity = currentEntity;
        if (entity == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Loading...",
                    fontWeight = FontWeight.ExtraBold)
            }
        } else {
            Column(modifier = modifier.fillMaxSize()) {

                EntityHeader(entity = entity)

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
                        0 -> EntityStatisticsBlock(entity)
                        1 -> EntityRelationsBlock(entity, currentLocation, onNavigateToMission)
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
fun PreviewScreenEntity() {
    val entity =
        factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[9]

    Previsualize {
        EntityDetailsScreen(
            entityId = entity.id.toString(),
            onNavigateToMission = {}
        )
    }
}
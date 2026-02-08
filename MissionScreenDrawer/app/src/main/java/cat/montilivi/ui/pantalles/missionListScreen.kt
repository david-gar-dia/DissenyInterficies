package cat.montilivi.ui.pantalles

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cat.montilivi.data.factoryDaoEntities
import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.model.Mission
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.componibles.HighlightedMission

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MissionListScreen(
    missionList: List<Mission>,
    entityMap: Map<Int, String>,
    onMissionClick: (Mission) -> Unit
) {
    LazyColumn()
    {
        items(missionList)
        {
            HighlightedMission(
                mission = it,
                acceptedBy = entityMap.get(it.acceptedBy)!!,
                onClick = { onMissionClick(it) }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MissionListPreview()
{
    val missions =
        factoryDaoMissions.createDao(Origin.MEMORY).obtenTots()
    val entities =
        factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()

    MissionListScreen(
        missionList = missions,
        entityMap = entities.associateBy({it.id}, {it.name}),
        onMissionClick = {}
    )
}
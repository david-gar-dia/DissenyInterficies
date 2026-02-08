package cat.montilivi.ui.pantalles

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cat.montilivi.data.factoryDaoEntities
import cat.montilivi.data.factoryDaoZones
import cat.montilivi.model.Entity
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.componibles.HighlightedEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntityListScreen(
    entityList: List<Entity>,
    zonesMap: Map<Int, String>,
    onEntityClick: (Entity) -> Unit
) {
    LazyColumn()
    {
        items(entityList)
        {
            HighlightedEntity(
                entity = it,
                currentLocation = zonesMap.get(it.currentZoneLocation)!!,
                onClick = { onEntityClick(it) }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EntityListPreview()
{
    val entities =
        factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()
    val zones =
        factoryDaoZones.createDao(Origin.MEMORY).obtenTots()

    EntityListScreen(
        entityList = entities,
        zonesMap = zones.associateBy({it.id}, {it.name}),
        onEntityClick = {}
    )
}
package cat.montilivi.ui.pantalles

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cat.montilivi.data.factoryDaoZones
import cat.montilivi.model.Zone
import cat.montilivi.model.enums.Origin
import cat.montilivi.ui.componibles.HighlightedZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZoneListScreen(
    zoneList: List<Zone>,
    onZoneClick: (Zone) -> Unit
) {
    LazyColumn()
    {
        items(zoneList)
        {
            HighlightedZone(
                zone = it,
                onClick = { onZoneClick(it) }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ZoneListPreview()
{
    val zones =
        factoryDaoZones.createDao(Origin.MEMORY).obtenTots()

    ZoneListScreen(
        zoneList = zones,
        onZoneClick = {}
    )
}
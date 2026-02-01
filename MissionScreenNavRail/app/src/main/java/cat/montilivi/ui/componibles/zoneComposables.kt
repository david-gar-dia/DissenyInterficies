package cat.montilivi.ui.componibles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.montilivi.Previsualize
import cat.montilivi.R
import cat.montilivi.data.factoryDaoEntities
import cat.montilivi.data.factoryDaoZones
import cat.montilivi.model.Entity
import cat.montilivi.model.Zone
import cat.montilivi.model.enums.Origin
import cat.montilivi.model.toAndroidColor
import cat.montilivi.ui.common.GenericBadge
import cat.montilivi.ui.common.ZoneImageShape
import cat.montilivi.ui.common.entityType2drawable
import coil.compose.AsyncImage

//region ZoneScreen Composables

@Composable
fun ZoneHeader(zone: Zone)
{
    val mainColor = zone.color.toAndroidColor()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(mainColor.copy(alpha = 0.2F))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            Surface(
                shape = ZoneImageShape,
                modifier = Modifier
                    .size(90.dp)
                    .border(2.dp, mainColor, ZoneImageShape)
            )
            {
                AsyncImage(
                    model = zone.image,
                    contentDescription = "zoneImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    placeholder = painterResource(android.R.drawable.star_on)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = zone.name,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = zone.description,
            style = MaterialTheme.typography.bodyLarge,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        ZoneQualities(zone)
    }
}

@Composable
fun ZoneSpecifications(zone: Zone)
{
    val mainColor = zone.color.toAndroidColor()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(mainColor.copy(alpha = 0.2F))
                .padding(16.dp)
        )
        {
            Text(
                text = "Biome: ${zone.biome}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Danger Level: ${zone.dangerLevel}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            BooleanBadge("Combat", zone.isCombatEnabled)
            Spacer(modifier = Modifier.height(10.dp))
            BooleanBadge("Item Loss", zone.willItemsBeLost)
            Spacer(modifier = Modifier.height(10.dp))
            BooleanBadge("Respawn", zone.isRespawnAvailable)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Max Entities: ${zone.maxEntities}",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun BooleanBadge(label: String, value: Boolean)
{
    val color = if(value) Color(46, 125, 50) else Color(183, 28, 28)
    Surface(
        color = color.copy(alpha = 0.2F),
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.dp, color)
    )
    {
        Text(
            text = "$label: ${if(value) "YES" else "NO"}",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}

@Composable
fun ZoneEntities(
    zone: Zone,
    onNavigateToEntity: (Entity) -> Unit
)
{
    val allEntities: List<Entity> = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots();
    val entitiesById: Map<Int, Entity>  = allEntities.associateBy({it.id}, {it});
    val mainColor = zone.color.toAndroidColor()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(mainColor.copy(alpha = 0.2F))
            .padding(16.dp)
    )
    {
        Text(
            text = "ENTITIES",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = rememberScrollState())
                .clip(RoundedCornerShape(6.dp))
                .background(Color(255F, 255F, 255F, 0.5F))
                .padding(12.dp)
        )
        {
            for(entity in zone.entities)
            {
                val currentEntity = entitiesById.get(entity)!!;
                HighlightedEntity(
                    entity = currentEntity,
                    currentLocation = zone.name,
                    onClick = { onNavigateToEntity(currentEntity) },
                    reduced = true);
            }
        }
    }
}

@Composable
fun EntityRow(entity: Entity)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Image(
            painter = painterResource(entityType2drawable(entity.type)),
            contentDescription = entity.name,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = entity.name,
            fontWeight = FontWeight.Medium
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ZoneQualities(zone: Zone)
{
    FlowRow(modifier = Modifier.fillMaxWidth())
    {
        if(zone.isCombatEnabled)
        {
            GenericBadge(
                text = "COMBAT",
                icon = painterResource(R.drawable.ally),
                color = Color(255, 143, 0),
                modifier = Modifier.padding(4.dp)
            )
        }
        if(zone.willItemsBeLost)
        {
            GenericBadge(
                text = "ITEM LOSS",
                icon = painterResource(R.drawable.enemy),
                color = Color(183, 28, 28),
                modifier = Modifier.padding(4.dp)
            )
        }
        if(zone.isRespawnAvailable)
        {
            GenericBadge(
                text = "RESPAWN",
                icon = painterResource(R.drawable.ulterior),
                color = Color(46, 125, 50),
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
//endregion

//region ZoneListScreen Composables
@Composable
fun HighlightedZone(
    zone: Zone,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
)
{
    val mainColor = zone.color.toAndroidColor()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(16.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
    {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .border(5.dp, mainColor, RoundedCornerShape(12.dp))
                .background(mainColor.copy(0.2F)),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 20.dp)
            )
            {
                Text(
                    text = zone.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Danger Level: ${zone.dangerLevel}",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Biome: ${zone.biome}",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp, end = 16.dp)
            )
            {
                Surface(
                    shape = ZoneImageShape,
                    modifier = Modifier
                        .size(70.dp)
                        .border(width = 2.dp, color = mainColor, shape = ZoneImageShape)
                        .aspectRatio(1F)
                )
                {
                    AsyncImage(
                        model = zone.image,
                        contentDescription = "zoneImage",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                        placeholder = painterResource(android.R.drawable.star_on)
                    )
                }
            }
        }
    }
}
//endregion

//region Previews
@Preview(showBackground = true)
@Composable
fun ZoneHeaderPreview()
{
    val zone = factoryDaoZones.createDao(Origin.MEMORY).obtenTots()[2]
    Previsualize { ZoneHeader(zone) }
}

@Preview(showBackground = true)
@Composable
fun ZoneSpecsPreview()
{
    val zone = factoryDaoZones.createDao(Origin.MEMORY).obtenTots()[2]
    Previsualize { ZoneSpecifications(zone) }
}

@Preview(showBackground = true)
@Composable
fun ZoneEntitiesPreview()
{
    val zone = factoryDaoZones.createDao(Origin.MEMORY).obtenTots()[2]
    Previsualize { ZoneEntities(zone, {}) }
}

@Preview(showBackground = true)
@Composable
fun HighligtedZonePreview()
{
    val zone = factoryDaoZones.createDao(Origin.MEMORY).obtenTots()[2]
    Previsualize { HighlightedZone(zone, onClick = {}) }
}
//endregion

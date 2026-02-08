package cat.montilivi.ui.componibles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.montilivi.data.factoryDaoEntities
import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.model.DecomposedColor
import cat.montilivi.model.Entity
import cat.montilivi.model.Mission
import cat.montilivi.model.Zone
import cat.montilivi.model.enums.Origin
import cat.montilivi.model.toAndroidColor
import cat.montilivi.ui.common.TenPointStarShape
import cat.montilivi.ui.common.entityType2color
import cat.montilivi.ui.common.entityType2drawable
import coil.compose.AsyncImage

//COMPOSABLES
//region EntityInformationBlocks Composables
@Composable
fun EntityStatisticsBlock(entity: Entity)
{
    EntitySpecifics(entity);
    EntityTalents(entity);
    EntityWeaknesses(entity);
}

@Composable
fun EntityRelationsBlock(entity: Entity, currentLocation: Zone?, onNavigateToMission: (Mission) -> Unit)
{
    EntityAcceptedMissions(entity, onNavigateToMission);
    EntityCurrentLocation(entity, currentLocation);
}
//endregion

//region EntityScreen Composables
@Composable
fun EntityHeader(entity: Entity)
{
    val mainColor = entity.color.toAndroidColor();

    Box()
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(mainColor.copy(alpha = 0.2F))
                .padding(16.dp)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically
            )
            {
                AsyncImage(
                    model = entity.image,
                    contentDescription = "entityImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = mainColor, shape = CircleShape),
                    placeholder = painterResource(android.R.drawable.star_on)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .weight(1F),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(
                        text = entity.name,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = entity.description,
                        style = MaterialTheme.typography.labelSmall,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Row()
        {
            Box(
                modifier = Modifier
                    .weight(1F)
            )
            EntityTypeBadge(entity);
        }
    }
}

@Composable
fun EntitySpecifics(entity: Entity)
{
    val mainColor = entity.color.toAndroidColor();

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    )
    {
        Column(
            modifier = Modifier
                .background(mainColor.copy(0.2F))
                .padding(16.dp)
        )
        {
            EntityProperties(entity);
            Spacer(modifier = Modifier.height(10.dp));
            EntityStatistics(entity);
        }
    }
}

@Composable
fun EntityProperties(entity: Entity)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White.copy(alpha = 0.6F))
            .padding(16.dp)
    )
    {
        Text(
            text = "Power Level: ${entity.powerLevel}",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.ExtraBold
        );
        Spacer(modifier = Modifier.height(5.dp));
        Row(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Column(
                modifier = Modifier
                    .weight(1F)
            )
            {
                Text(
                    text = "Variant:",
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                );
                Text(
                    text = entity.variant
                );
            }
            Column(
                modifier = Modifier
                    .weight(1F)
            )
            {
                Text(
                    text = "Weapon:",
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                );
                Text(
                    text = entity.weapon
                );
            }
        }
    }
}

@Composable
fun EntityStatistics(entity: Entity)
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White.copy(0.6F))
            .padding(16.dp)
    )
    {
        Text(
            text = "Statistics:",
            style = MaterialTheme.typography.headlineSmall
        )
        EntityStat("Life: ", entity.life);
        Spacer(modifier = Modifier.height(5.dp))
        EntityStat("Attack: ", entity.attack);
        Spacer(modifier = Modifier.height(5.dp))
        EntityStat("Defense: ", entity.defense);
        Spacer(modifier = Modifier.height(5.dp))
        EntityStat("Speed: ", entity.speed);
        Spacer(modifier = Modifier.height(5.dp))
        EntityStat("Magic: ", entity.magic);
    }
}

@Composable
fun EntityStat(text: String, value: Int, maxValue: Int = 20)
{
    Row(
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            text = text,
            modifier = Modifier
                .weight(2F),
            fontWeight = FontWeight.Bold
        )
        EntityQualityGraded(
            value = value,
            maxValue = maxValue,
            modifier = Modifier
                .weight(8F)
        );
    }
}

@Composable
fun EntityQualityGraded(value: Int, maxValue: Int = 20, modifier: Modifier = Modifier)
{
    val percentage: Double = value/maxValue.toDouble();
    val rankColor: DecomposedColor;
    val letter: String;

    if(percentage <= 0.25)
    {
        rankColor = DecomposedColor(150, 150, 150);
        letter = "D";
    }
    else if(percentage <= 0.5)
    {
        rankColor = DecomposedColor(190, 255, 0);
        letter = "C";
    }
    else if(percentage <= 0.75)
    {
        rankColor = DecomposedColor(135, 206, 250);
        letter = "B";
    }
    else if(percentage <= 1)
    {
        rankColor = DecomposedColor(255, 40, 40);
        letter = "A";
    }
    else
    {
        rankColor = DecomposedColor(255, 215, 0);
        letter = "S";
    }

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
        )
        {
            LinearProgressIndicator(
                progress = {
                    percentage.toFloat();
                },
                modifier = Modifier
                    .padding(2.dp),
                trackColor = Color(88, 88, 88),
                color = rankColor.toAndroidColor(),
                gapSize = -(5.dp)
            )
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
        )
        {
            Text(
                text = letter,
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold,
                color = rankColor.toAndroidColor()
            )
        }
    }
}

@Composable
fun EntityTalents(entity: Entity)
{
    val talentEmoji = "\u2696\uFE0F";
    EntityStringList("Talents", talentEmoji, entity.talents, entity.color)
}

@Composable
fun EntityWeaknesses(entity: Entity)
{
    val weaknessEmoji = "\u26A0\uFE0F";
    EntityStringList("Weaknesses", weaknessEmoji, entity.weaknesses, entity.color)
}

@Composable
fun EntityStringList(title: String, emoji: String, list: List<String>, color: DecomposedColor)
{
    val mainColor: Color = color.toAndroidColor();

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(mainColor.copy(alpha = 0.2F))
            .padding(16.dp)
    )
    {
        Text(
            text = "$emoji ${title.uppercase()}",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .background(Color(255F, 255F, 255F, 0.5F))
                .padding(15.dp)
        )
        {
            for (item in list) {
                Text(
                    text = "- $item",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun EntityCurrentLocation(entity: Entity, currentZone: Zone?)
{
    val mainColor: Color = entity.color.toAndroidColor();

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(mainColor.copy(alpha = 0.2F))
            .padding(16.dp)
    )
    {
        Text(
            text = "Location:",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = currentZone?.name ?: "Unknown Zone...",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = currentZone?.description ?: "Unknown Zone...",
            style = MaterialTheme.typography.bodyLarge,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .border(2.dp, mainColor, RoundedCornerShape(6.dp))
        )
        {
            AsyncImage(
                model = currentZone?.image,
                contentDescription = currentZone?.name ?: "Agartha",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1F),
                placeholder = painterResource(android.R.drawable.ic_menu_camera),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun EntityAcceptedMissions(
    entity: Entity,
    onNavigateToMission: (Mission) -> Unit
)
{
    val allMissions: List<Mission> = factoryDaoMissions.createDao(Origin.MEMORY).obtenTots();
    val missionsById: Map<Int, Mission>  = allMissions.associateBy({it.id}, {it});
    val mainColor: Color = entity.color.toAndroidColor();

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(mainColor.copy(alpha = 0.2F))
            .padding(8.dp)
    )
    {
        Text(
            text = "MISSIONS:",
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold,
            textDecoration = TextDecoration.Underline
        )
        for (mission in entity.missionsAccepted) {
            val currentMission = missionsById.get(mission)!!;
            HighlightedMission(
                mission = currentMission,
                acceptedBy = entity.name,
                onClick = { onNavigateToMission(currentMission) },
                reduced = true);
        }

    }
}

@Composable
fun EntityTypeBadge(entity: Entity)
{
    val badgeColor: Color = entityType2color(entity.type);

    Box()
    {
        Surface(
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.CenterEnd),
            shape = TenPointStarShape,
            color = badgeColor
        )
        {
            Icon(
                modifier = Modifier
                    .padding(20.dp),
                painter = painterResource(entityType2drawable(entity.type)),
                contentDescription = entity.type.name.replace("_", " "),
                tint = Color.Black
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(end = 45.dp)
                .clip(RoundedCornerShape(topStart = 50F, bottomStart = 50F))
                .background(badgeColor)
        )
        {
            Text(
                text = entity.type.name.replace("_", " "),
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 3.dp),
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}
//endregion

@Composable
fun HighlightedEntity(
    entity: Entity,
    currentLocation: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    reduced: Boolean = false)
{
    val mainColor = entity.color.toAndroidColor();

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(16.dp)
            .clickable{onClick()},
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
                    text = entity.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Position: ${entity.variant} ${entity.powerLevel}",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
                if(!reduced)
                {
                    Text(
                        text = "Location: $currentLocation",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp, end = 16.dp)
            )
            {
                Surface(
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.Bottom),
                    shape = CircleShape,
                    color = Color.White,
                    border = BorderStroke(
                        width = 2.dp,
                        color = mainColor.copy(alpha = 0.5F)
                    )
                )
                {
                    Image(
                        painter = painterResource(entityType2drawable(entity.type)),
                        contentDescription = entity.type.toString(),
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                AsyncImage(
                    model = entity.image,
                    contentDescription = "entityImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = mainColor, shape = CircleShape)
                        .aspectRatio(1F),
                    placeholder = painterResource(android.R.drawable.star_on)
                )
            }
        }
    }
}

//PREVIEWS
//region EntityScreen Composables
@Preview(showBackground = true)
@Composable
fun EntityHeaderPreview() {
    val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[6];

    EntityHeader(entity);
}

@Preview(showBackground = true)
@Composable
fun EntityStatisticsPreview() {
    val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[6];

    EntitySpecifics(entity);
}

@Preview(showBackground = true)
@Composable
fun EntityTalentsPreview() {
    val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[6];

    EntityTalents(entity);
}

@Preview(showBackground = true)
@Composable
fun EntityWeaknessesPreview() {
    val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[6];

    EntityWeaknesses(entity);
}

@Preview(showBackground = true)
@Composable
fun EntityCurrentLocationPreview() {
    val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[6];

    EntityCurrentLocation(entity, null);
}

@Preview(showBackground = true)
@Composable
fun EntityAcceptedMissionsPreview() {
    val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[6];

    EntityAcceptedMissions(entity, {});
}

@Preview(showBackground = true)
@Composable
fun EntityTypeBadgePreview()
{
    val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[6];

    EntityTypeBadge(entity);
}
//endregion

@Preview(showBackground = true)
@Composable
fun HighlightedEntityPreview()
{
    val entity = factoryDaoEntities.createDao(Origin.MEMORY).obtenTots()[6];

    HighlightedEntity(
        entity,
        "Narnia",
        {}
    );
}
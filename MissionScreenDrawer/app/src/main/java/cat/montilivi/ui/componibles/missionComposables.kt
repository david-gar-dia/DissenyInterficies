package cat.montilivi.ui.componibles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import cat.montilivi.Previsualize
import cat.montilivi.R
import cat.montilivi.data.factoryDaoMissions
import cat.montilivi.model.DecomposedColor
import cat.montilivi.model.Entity
import cat.montilivi.model.Mission
import cat.montilivi.model.enums.ElementalType
import cat.montilivi.model.enums.MedalType
import cat.montilivi.model.enums.Origin
import cat.montilivi.model.toAndroidColor
import cat.montilivi.ui.common.GenericBadge
import cat.montilivi.ui.common.MedalRibbon
import cat.montilivi.ui.common.MedalStrength
import cat.montilivi.ui.common.MedalWeakness
import cat.montilivi.ui.common.elementalType2Color
import cat.montilivi.ui.common.elementalType2drawable
import cat.montilivi.ui.common.missionStatus2ColorScheme
import cat.montilivi.ui.common.missionType2Drawable
import cat.montilivi.ui.common.numParticipants2Drawable
import coil.compose.AsyncImage

//COMPOSABLES

//region MissionInformationBlocks Composables
@Composable
fun MissionInformationBlock(mission: Mission) {
    MissionStory(mission);
    MissionRewards(mission);
}

@Composable
fun MissionSpecificationsBlock(mission: Mission) {
    MissionSpecifications(mission);
    MissionAdvantageTypes(mission);
}
//endregion

//region MissionScreen Composables
@Composable
fun MissionHeader(mission: Mission, acceptedBy: Entity?)
{
    val mainColor = mission.color.toAndroidColor();

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
                    model = mission.image,
                    contentDescription = "missionImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(width = 2.dp, color = mainColor, shape = RoundedCornerShape(8.dp)),
                    placeholder = painterResource(android.R.drawable.star_on)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = mission.description,
                    modifier = Modifier
                        .weight(1F),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            Text(
                text = "Accepted By: ${acceptedBy?.name ?: "Unknown"}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            MissionQualities(mission);
        }
        Row()
        {
            Box(
                modifier = Modifier
                    .weight(1F)
            )
            MissionCompletion(mission)
        }
    }
}

@Composable
fun MissionSpecifications(mission: Mission)
{
    val mainColor = mission.color.toAndroidColor();

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(mainColor.copy(alpha = 0.2F))
                .padding(16.dp)
        )
        {
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Solicitant: ${mission.solicitant}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            )
            {
                IconTextBadge("Mission Type", painterResource(missionType2Drawable(mission.missionType)), "${mission.missionType}", "${mission.missionType}")
                IconTextBadge("Max Participants", painterResource(numParticipants2Drawable(mission.maxParticipants)), "${mission.missionType}", "${mission.maxParticipants} MEMBERS")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.Center
            )
            {
                MissionProgression("Goal", mission.goal, mission.getMaxGoal(), mission.item.uppercase())
            }
            StarMeterField("Difficulty", mission.difficulty)
        }
    }
}

@Composable
fun IconTextBadge(topText: String, icon: Painter, description: String, bottomText: String)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = topText
        )
        Icon(
            painter = icon,
            contentDescription = description,
            modifier = Modifier
                .padding(5.dp)
                .size(80.dp),
        )
        Text(
            text = bottomText
        )
    }
}

@Composable
fun StarMeterField(text: String, numStars: Int, maxStars: Int = 5)
{
    Row()
    {
        Text("$text:")
        Spacer(modifier = Modifier.width(10.dp))
        Row()
        {
            for(i in 1..maxStars)
                if(i <= numStars)
                    Icon(
                        painter = painterResource(android.R.drawable.star_big_on),
                        contentDescription = "Star_On"
                    )
                else
                    Icon(
                        painter = painterResource(android.R.drawable.star_off),
                        contentDescription = "Star_Off"
                    )
        }
    }
}

@Composable
fun MissionProgression(text: String, progression: Int, maxValue: Int = 100, bottomText: String = "")
{


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = text);
        ColoredProgressionWheel(progression, maxValue)
        if(bottomText != "")
            Text(text = bottomText)
    }
}

@Composable
fun ColoredProgressionWheel(progression: Int, maxValue: Int)
{
    val percentage = progression/maxValue.toDouble();
    val lineColor =
        if(percentage <= 0.2)
            DecomposedColor(167, 227, 255)
        else if(percentage <= 0.4)
            DecomposedColor(0, 200, 255)
        else if(percentage <= 0.6)
            DecomposedColor(127, 255, 0)
        else if(percentage <= 0.8)
            DecomposedColor(255, 140, 0)
        else
            DecomposedColor(255, 0, 0)

    Box(
        modifier = Modifier
            .padding(5.dp),
        contentAlignment = Alignment.Center
    )
    {
        CircularProgressIndicator(
            progress = { percentage.toFloat() },
            modifier = Modifier
                .size(80.dp),
            color = lineColor.toAndroidColor(),
            trackColor = lineColor.toAndroidColor().copy(alpha = 0.2F)
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(lineColor.toAndroidColor()),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = progression.toString(),
                fontSize = 5.em,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Composable
fun MissionStory(mission: Mission)
{
    val isReadMore = remember { mutableStateOf( false ) }
    val mainColor = mission.color.toAndroidColor();

    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(mainColor.copy(alpha = 0.2F))
            .padding(16.dp)
    )
    {
        Text(
            if(isReadMore.value)
                mission.story
            else
                "${mission.story.take(100)}..."
        )
        if(!isReadMore.value)
        {
            Text(
                text = "Expand",
                modifier = Modifier
                    .clickable(
                        enabled = true,
                        onClick = { isReadMore.value = true }
                    ),
                color = Color(88, 88, 88)
            )
        }
    }
}

@Composable
fun MissionRewards(mission: Mission)
{
    val giftEmoji = "\uD83C\uDF81";
    val mainColor: Color = mission.color.toAndroidColor();

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
            text = "$giftEmoji REWARDS",
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
            for ((reward, amount) in mission.reward) {
                RewardListing(reward, amount)
            }
        }
    }
}

@Composable
fun RewardListing(reward: String, amount: Int = 1)
{
    val qualityColor =
        if(amount <= 1)
            DecomposedColor(74, 74, 74)
        else if(amount <= 2)
            DecomposedColor(46, 125, 50)
        else
            DecomposedColor(21, 101, 192)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    )
    {
        Text(
            text = "$amount $reward",
            color = qualityColor.toAndroidColor()
        )
    }
}

@Composable
fun MissionCompletion(mission: Mission)
{
    val medalScheme: ColorScheme = missionStatus2ColorScheme(mission.status);

    Box()
    {
        Surface(
            color = medalScheme.primaryContainer,
            shape = MedalRibbon,
            modifier = Modifier
                .height(100.dp)
                .width(35.dp)
                .padding(top = 30.dp)
                .align(Alignment.TopCenter),
            border = BorderStroke(2.dp, Color.Black)
        )
        {

        }
        Surface(
            color = Color.Black.copy(alpha = 0.2F),
            shape = MedalRibbon,
            modifier = Modifier
                .height(90.dp)
                .width(25.dp)
                .padding(top = 30.dp)
                .align(Alignment.TopCenter),
            border = BorderStroke(1.dp, Color.Black)
        )
        {

        }
            Box(
                contentAlignment = Alignment.Center
            )
            {
                Box(
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                        .background(medalScheme.primaryContainer)
                        .border(2.dp, Color.Black, CircleShape)
                ) {}
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(medalScheme.secondaryContainer)
                        .border(1.dp, Color.Black, CircleShape),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(
                        text = mission.status.name.replace("_", " "),
                        fontSize = 2.em,
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
    }
}

@Composable
fun MissionAdvantageTypes(mission: Mission)
{
    val mainColor: Color = mission.color.toAndroidColor();

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(mainColor.copy(alpha = 0.2F))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    )
    {
        ListMedals("Advantageous\nTypes", mission.favorableElementalTypes, MedalType.STRENGTH)
        ListMedals("Disadvantageous\nTypes", mission.unfavorableElementalTypes, MedalType.WEAKNESS)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ListMedals(header: String, medalValues: List<ElementalType>, medalsTypes: MedalType = MedalType.STRENGTH)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = header,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(Color(255F, 255F, 255F, 0.5F))
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            when(medalsTypes) {
                MedalType.STRENGTH -> {
                    for (type in medalValues) {
                        StrengthMedal(
                            text = type.toString(),
                            icon = painterResource(elementalType2drawable(type)),
                            medalColor = elementalType2Color(type)
                        )
                    }
                }
                MedalType.WEAKNESS -> {
                    for (type in medalValues) {
                        WeaknessMedal(
                            text = type.toString(),
                            icon = painterResource(elementalType2drawable(type)),
                            medalColor = elementalType2Color(type)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StrengthMedal(text: String, icon: Painter, medalColor: Color, borderColor: Color = Color.Black)
{
    Surface(
        color = medalColor,
        shape = MedalStrength,
        modifier = Modifier
            .padding(vertical = 10.dp)
            .border(1.dp, borderColor, MedalStrength)
    )
    {
        Row(
            modifier = Modifier
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = text,
                fontWeight = FontWeight.ExtraBold
            );
            Icon(
                painter = icon,
                contentDescription = text,
                modifier = Modifier
                    .size(30.dp),
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun WeaknessMedal(text: String, icon: Painter, medalColor: Color, borderColor: Color = Color.Black)
{
    Surface(
        color = medalColor,
        shape = MedalWeakness,
        modifier = Modifier
            .padding(vertical = 10.dp)
            .border(1.dp, borderColor, MedalWeakness)
    )
    {
        Row(
            modifier = Modifier
                .padding(horizontal = 25.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = text,
                fontWeight = FontWeight.ExtraBold
            );
            Icon(
                painter = icon,
                contentDescription = text,
                modifier = Modifier
                    .size(30.dp),
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun MissionQualities(mission: Mission)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        if(mission.isStoryMission)
        {
            GenericBadge(
                text = "STORY",
                icon = painterResource(R.drawable.story_icon),
                color = Color(128, 49, 0)
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
        if(mission.isOfferedByGuild)
        {
            GenericBadge(
                text = "GUILD",
                icon = painterResource(R.drawable.guild_icon),
                color = Color(158, 133, 39)
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
        if(mission.isEventMission)
            GenericBadge(
                text = "EVENT",
                icon = painterResource(R.drawable.event_icon),
                color = Color(175, 143, 255)
            )
    }
}
//endregion
//region MissionListScreen Composables
@Composable
fun HighlightedMission (
    mission: Mission,
    acceptedBy: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    reduced: Boolean = false
)
{
    val mainColor = mission.color.toAndroidColor();

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
                    text = mission.description,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                if(!reduced)
                {
                    StarMeterField("Difficulty", mission.difficulty);
                    Text(
                        text = "Accepted by: $acceptedBy",
                        style = MaterialTheme.typography.labelMedium
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
                        painter = painterResource(missionType2Drawable(mission.missionType)),
                        contentDescription = mission.solicitant
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                AsyncImage(
                    model = mission.image,
                    contentDescription = "missionImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(width = 2.dp, color = mainColor, shape = RoundedCornerShape(8.dp))
                        .aspectRatio(1F),
                    placeholder = painterResource(android.R.drawable.star_on)
                )
            }
        }
    }
}
//endregion

//PREVIEWS
//region MissionScreen Previews
@Preview(showBackground = true)
@Composable
fun MissionHeaderPreview()
{
    val mission =
        factoryDaoMissions
            .createDao(Origin.MEMORY)
            .obtenTots()[15]
    Previsualize {
        MissionHeader(mission = mission, null)
    }
}

@Preview(showBackground = true)
@Composable
fun SpecificationsPreview()
{
    val mission =
        factoryDaoMissions
            .createDao(Origin.MEMORY)
            .obtenTots()[15]
    Previsualize {
        MissionSpecifications(mission = mission)
    }
}

@Preview(showBackground = true)
@Composable
fun StoryPreview()
{
    val mission =
        factoryDaoMissions
            .createDao(Origin.MEMORY)
            .obtenTots()[15]
    Previsualize {
        MissionStory(mission = mission)
    }
}

@Preview(showBackground = true)
@Composable
fun StrengthPreview()
{
    val mission =
        factoryDaoMissions
            .createDao(Origin.MEMORY)
            .obtenTots()[15]
    Previsualize {
        MissionAdvantageTypes(mission)
    }
}

@Preview(showBackground = true)
@Composable
fun RewardsPreview()
{
    val mission = factoryDaoMissions.createDao(Origin.MEMORY).obtenTots()[15]
    Previsualize{
        MissionRewards(mission);
    }
}

@Preview(showBackground = true)
@Composable
fun CompletionPreview()
{
    val mission =
        factoryDaoMissions
            .createDao(Origin.MEMORY)
            .obtenTots()[15]
    Previsualize {
        MissionCompletion(mission = mission)
    }
}

@Preview(showBackground = true)
@Composable
fun QualititesPreview()
{
    val mission = factoryDaoMissions.createDao(Origin.MEMORY).obtenTots()[15]
    Previsualize {
        MissionQualities(mission)
    }
}
//endregion
//region MissionListScreen Composables
@Preview(showBackground = true)
@Composable
fun HighlightedPreview()
{
    val mission = factoryDaoMissions.createDao(Origin.MEMORY).obtenTots()[15]
    Previsualize {
        HighlightedMission(
            mission = mission,
            acceptedBy = "Naruto",
            onClick = {}
        )
    }
}
//endregion
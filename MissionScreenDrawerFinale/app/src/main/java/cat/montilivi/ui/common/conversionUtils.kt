package cat.montilivi.ui.common

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import cat.montilivi.R
import cat.montilivi.model.enums.ElementalType
import cat.montilivi.model.enums.EntityType
import cat.montilivi.model.enums.MissionStatus
import cat.montilivi.model.enums.MissionType

//region MissionClass Convertibles
fun missionType2Drawable(missionType: MissionType): Int =
    when(missionType) {
        MissionType.RECOLLECTION -> R.drawable.recollection_icon
        MissionType.HUNTING -> R.drawable.hunting_icon
        MissionType.RESCUE -> R.drawable.rescue_icon
        MissionType.DELIVERY -> R.drawable.delivery_icon
    }

fun numParticipants2Drawable(maxParticipants: Int): Int =
    if(maxParticipants < 4)
        R.drawable.few_people_icon
    else
        R.drawable.many_people_icon

fun missionStatus2ColorScheme(missionStatus: MissionStatus): ColorScheme =
    when(missionStatus) {
        MissionStatus.DONE -> lightColorScheme(
            primaryContainer = Color(106, 168, 79),
            secondaryContainer = Color(255, 217, 102),
            onSecondaryContainer = Color(106, 168, 79)
        )
        MissionStatus.IN_COURSE -> lightColorScheme(
            primaryContainer = Color(111, 168, 220),
            secondaryContainer = Color(147, 207, 240),
            onSecondaryContainer = Color(111, 168, 220)
        )
        MissionStatus.FAILED -> lightColorScheme(
            primaryContainer = Color(224, 102, 102),
            secondaryContainer = Color(244, 177, 131),
            onSecondaryContainer = Color(224, 102, 102)
        )
    }

fun elementalType2drawable(type: ElementalType): Int =
    when(type) {
        ElementalType.FIRE -> R.drawable.fire_type
        ElementalType.AQUA -> R.drawable.water_type
        ElementalType.FOREST -> R.drawable.forest_type
        ElementalType.VOID -> R.drawable.void_type
        ElementalType.LIGHT -> R.drawable.light_type
        ElementalType.DARK -> R.drawable.dark_type
    }

fun elementalType2Color(type: ElementalType): Color =
    when(type) {
        ElementalType.FIRE -> Color(250, 213, 206)
        ElementalType.AQUA -> Color(210, 224, 245)
        ElementalType.FOREST -> Color(216, 242, 214)
        ElementalType.VOID -> Color(233, 228, 220)
        ElementalType.LIGHT -> Color(246, 210, 213)
        ElementalType.DARK -> Color(231, 224, 221)
    }
//endregion

//region EntityClass Convertibles
fun entityType2drawable(entityType: EntityType): Int =
    when(entityType) {
        EntityType.ALLY -> R.drawable.ally
        EntityType.ENEMY -> R.drawable.enemy
        EntityType.ULTERIOR_BEING -> R.drawable.ulterior
    }

fun entityType2color(entityType: EntityType): Color =
    when(entityType) {
        EntityType.ALLY -> Color(245, 192, 122)
        EntityType.ENEMY -> Color(139, 0, 0)
        EntityType.ULTERIOR_BEING -> Color(173, 216, 255)
    }
//endregion
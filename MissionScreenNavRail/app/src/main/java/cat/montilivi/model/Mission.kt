package cat.montilivi.model

import cat.montilivi.model.enums.ElementalType
import cat.montilivi.model.enums.MissionStatus
import cat.montilivi.model.enums.MissionType

data class Mission(
    val id: Int,
    val image: String,
    val color: DecomposedColor,
    val solicitant: String,
    val difficulty: Int,
    val description: String,
    val story: String,
    val missionType: MissionType,
    val goal: Int,
    val item: String,
    val favorableElementalTypes: List<ElementalType>,
    val unfavorableElementalTypes: List<ElementalType>,
    val reward: Map<String, Int>,
    val maxParticipants: Int,
    val status: MissionStatus,
    val isOfferedByGuild: Boolean,
    val isEventMission: Boolean,
    val isStoryMission: Boolean,
    val acceptedBy: Int,
    val MAX_DIFFICULTY: Int = 5
) {
    fun getMaxGoal(): Int {
        return when(missionType) {
            MissionType.RECOLLECTION -> 18 * MAX_DIFFICULTY
            MissionType.HUNTING -> 8 * MAX_DIFFICULTY
            MissionType.RESCUE -> 5 * MAX_DIFFICULTY
            MissionType.DELIVERY -> 6 * MAX_DIFFICULTY
        }
    }

    override fun toString(): String {
        val sb = StringBuilder();

        sb.append("Mission(")
        sb.append(id);
        sb.append(", \"$image\"");
        sb.append(", $color")
        sb.append(", \"$solicitant\"");
        sb.append(", $difficulty")
        sb.append(", \"$description\"");
        sb.append(", \"$story\"");
        sb.append(", MissionType.$missionType");
        sb.append(", $goal");
        sb.append(", \"$item\"");
        sb.append(", listOf(${favorableElementalTypes.joinToString(", ")})");
        sb.append(", listOf(${unfavorableElementalTypes.joinToString(", ")})");
        sb.append(", mapOf(");
        reward.forEach { reward ->
            sb.append("${reward.key} to ${reward.value}, ")
        }
        sb.append(")")
        sb.append(", $maxParticipants");
        sb.append(", MissionStatus.$status");
        sb.append(", $isOfferedByGuild");
        sb.append(", $isEventMission");
        sb.append(", $isStoryMission")
        sb.append(", $acceptedBy")
        sb.append(")")

        return sb.toString();
    }
}
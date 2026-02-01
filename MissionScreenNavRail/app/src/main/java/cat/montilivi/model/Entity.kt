package cat.montilivi.model

import cat.montilivi.model.enums.EntityType

data class Entity(
    val id: Int,
    val image: String,
    val color: DecomposedColor,
    val name: String,
    val description: String,
    val type: EntityType,
    val variant: String,
    val powerLevel: String,
    val weapon: String,
    val talents: List<String>,
    val weaknesses: List<String>,
    val life: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val magic: Int,
    val currentZoneLocation: Int,
    val missionsAccepted: MutableList<Int>,
    val MAX_MISSIONS: Int = 3
) {
    override fun toString(): String {
        val sb: StringBuilder = StringBuilder();

        sb.append("Entity(")
        sb.append(id);
        sb.append(", \"$image\"");
        sb.append(", $color")
        sb.append(", \"$name\"");
        sb.append(", \"$description\"")
        sb.append(", EntityType.$type");
        sb.append(", \"$variant\"");
        sb.append(", \"$powerLevel\"");
        sb.append(", \"$weapon\"");
        sb.append(", listOf(${talents.joinToString(", ")})");
        sb.append(", listOf(${weaknesses.joinToString(", ")})");
        sb.append(", $life");
        sb.append(", $attack");
        sb.append(", $defense");
        sb.append(", $speed");
        sb.append(", $magic");
        sb.append(", $currentZoneLocation")
        sb.append(", listOf(${missionsAccepted.joinToString(", ")})")
        sb.append(")")

        return sb.toString();
    }
}
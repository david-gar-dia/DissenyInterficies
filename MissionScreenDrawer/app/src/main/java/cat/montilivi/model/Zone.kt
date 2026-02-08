package cat.montilivi.model

import cat.montilivi.model.enums.BiomeType
import cat.montilivi.model.enums.DangerLevel

data class Zone(
    val id: Int,
    val image: String,
    val color: DecomposedColor,
    val name: String,
    val description: String,
    val biome: BiomeType,
    val dangerLevel: DangerLevel,
    val isCombatEnabled: Boolean,
    val willItemsBeLost: Boolean,
    val isRespawnAvailable: Boolean,
    val maxEntities: Int,
    val entities: MutableList<Int>
)
{
    override fun toString(): String {
        val sb: StringBuilder = StringBuilder();

        sb.append("Zone(")
        sb.append(id);
        sb.append(", \"$image\"");
        sb.append(", $color")
        sb.append(", \"$name\"")
        sb.append(", \"$description\"");
        sb.append(", BiomeType.$biome");
        sb.append(", DangerLevel.$dangerLevel");
        sb.append(", $isCombatEnabled");
        sb.append(", $willItemsBeLost");
        sb.append(", $isRespawnAvailable");
        sb.append(", $maxEntities");
        sb.append(", listOf(${entities.joinToString(", ")}})")
        sb.append(")");

        return sb.toString();
    }
}

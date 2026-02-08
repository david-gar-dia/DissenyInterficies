package cat.montilivi.model

import androidx.compose.ui.graphics.Color

data class DecomposedColor (
    val vermell: Int,
    val verd: Int,
    val blau: Int,
    val transparencia: Int = 255
)

fun DecomposedColor.toHexString(includeAlpha: Boolean = false): String {
    require(vermell in 0..255 && verd in 0..255 && blau in 0..255 && transparencia in 0..255) {
        "Els valors RGB i alpha han d'estar entre 0 i 255"
    }

    return if (includeAlpha) {
        String.format("#%02X%02X%02X%02X", vermell, verd, blau, transparencia)
    } else {
        String.format("#%02X%02X%02X", vermell, verd, blau)
    }
}

fun DecomposedColor.toAndroidColor(): Color {
    require(vermell in 0..255 && verd in 0..255 && blau in 0..255 && transparencia in 0..255) {
        "Els valors RGB i alpha han d'estar entre 0 i 255"
    }
    return  Color(
            red = vermell,
            green = verd,
            blue = blau,
            alpha = transparencia
        )
}

fun String.toColorDescomcomposat(): DecomposedColor {
    val senseSharp = this.trim().removePrefix("#")

    require(senseSharp.matches(Regex("^[0-9A-Fa-f]{6}$|^[0-9A-Fa-f]{8}$"))) {
        "El format HEX ha de ser #RRGGBB o #RRGGBBAA"
    }

    return when (senseSharp.length) {
        6 -> {
            val vermell = senseSharp.substring(0, 2).toInt(16)
            val verd = senseSharp.substring(2, 4).toInt(16)
            val blau = senseSharp.substring(4, 6).toInt(16)
            DecomposedColor(vermell, verd, blau)
        }
        8 -> {
            val vermell = senseSharp.substring(0, 2).toInt(16)
            val verd = senseSharp.substring(2, 4).toInt(16)
            val blau = senseSharp.substring(4, 6).toInt(16)
            val transparencia = senseSharp.substring(6, 8).toInt(16)
            DecomposedColor(vermell, verd, blau, transparencia)
        }
        else -> throw IllegalArgumentException("Format HEX no vàlid")
    }
}

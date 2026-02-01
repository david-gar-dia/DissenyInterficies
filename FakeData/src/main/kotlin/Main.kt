package org.example

import kotlin.random.Random

const val MASCULI = "Masculi"
const val FEMENI = "Femeni"

private val Noms = listOf(
    Pair("Tigre", MASCULI),
    Pair("Rei", MASCULI),
    Pair("Espadatxí", MASCULI),
    Pair("Princesa", FEMENI),
    Pair("Tortuga", FEMENI),
    Pair("Mag", MASCULI),
    Pair("Bruixa", FEMENI),
    Pair("Fetillera", FEMENI)
)

private val Adjectius = listOf(
    Pair("Caigut", "Caiguda"),
    Pair("Honorable", "Honorable"),
    Pair("Sensual", "Sensual"),
    Pair("Misteriòs", "Misteriosa"),
    Pair("Encantador", "Encantadora"),
    Pair("Vigorós", "Vigorosa"),
    Pair("Diligent", "Diligent"),
    Pair("Esglaiador", "Esglaiadora"),
    Pair("Bonic", "Bella"),
)

val dades: MutableList<Guerrer> =
    (1..300).map{
        CreaGuerrer(it)
    }.toMutableList()

fun CreaGuerrer (num: Int): Guerrer {
    val posNom = Random.nextInt(1, Noms.size);
    val posAdjectius = Random.nextInt(1, Adjectius.size);
    val nomGuerrer = Noms[posNom].first + " " +
            if (Noms[posNom].second == MASCULI)
                Adjectius[posAdjectius].first;
            else
                Adjectius[posAdjectius].second;

    return Guerrer(
        id = num,
        nom = nomGuerrer,
        foto = "",
        color = ColorDescomposable(
            vermell = Random.nextInt(0, 256),
            verd = Random.nextInt(0, 256),
            blau = Random.nextInt(0, 256)
        ),
        edat = Random.nextInt(5, 75),
        forsa = Random.nextInt(0, 101),
        resistencia = Random.nextInt(0, 101),
        atac = Random.nextInt(0, 101),
        defensa = Random.nextInt(0, 101)
    )
}

fun main() {
    dades.forEach {
        println(it)
    }
}
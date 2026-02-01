package org.example

data class Guerrer(
    val id: Int,
    val nom: String,
    val foto: String,
    val color: ColorDescomposable,
    val edat: Int,
    val forsa: Int,
    val resistencia: Int,
    val atac: Int,
    val defensa: Int
) {
}
class Cartografia (
    idBNE : String = "",
    autorPersones : List<String> = listOf(),
    autorEntitats : List<String> = listOf(),
    titol : String = "",
    descripcio : String = "",
    genere : String = "",
    dipositLegal : String = "",
    pais : String = "",
    idioma : String = "",
    versioDigital : String = "",
    tipus : TipusDocument = TipusDocument.Cartografia,
    textOCR : String = "",
    iSBN : String = "",
    tema : String = "",
    val tipusMaterialCartografico : String = "",
    val projeccioDelMapa : String = "",
    val escalaDelMapa : String = ""
) : Publicacio(idBNE, autorPersones, autorEntitats, titol, descripcio, genere, dipositLegal, pais, idioma, versioDigital, tipus, textOCR, iSBN, tema)
{
    override fun toString(): String {
        val sb : StringBuilder = StringBuilder(super.toString());

        sb.appendLine("\tTipus de material cartogràfic: $tipusMaterialCartografico");
        sb.appendLine("\tProjecció del mapa: $projeccioDelMapa");
        sb.appendLine("\tEscala del mapa: $escalaDelMapa");

        return sb.toString();
    }
}
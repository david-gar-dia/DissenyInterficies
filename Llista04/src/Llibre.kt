class Llibre (
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
    tipus : TipusDocument = TipusDocument.Llibre,
    textOCR : String = "",
    iSBN : String = "",
    tema : String = "",
    val editorial : String = "",
    val llocPublicacio : String = ""
) : Publicacio(idBNE, autorPersones, autorEntitats, titol, descripcio, genere, dipositLegal, pais, idioma, versioDigital, tipus, textOCR, iSBN, tema)
{
    override fun toString(): String {
        val sb : StringBuilder = StringBuilder(super.toString());

        sb.appendLine("\tEditorial: $editorial");
        sb.appendLine("\tLloc de publicació: $llocPublicacio");

        return sb.toString();
    }
}
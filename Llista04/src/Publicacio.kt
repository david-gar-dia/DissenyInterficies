abstract class Publicacio (
    idBNE : String = "",
    autorPersones : List<String> = listOf(),
    autorEntitats : List<String> = listOf(),
    titol : String = "",
    descripcio: List<String> = listOf(),
    genere : String = "",
    dipositLegal : String = "",
    pais : String = "",
    idioma : String = "",
    versioDigital : String = "",
    tipus : TipusDocument,
    textOCR : String = "",
    val tema : String = "",
    val iSBN : String = ""
) : Text(idBNE, autorPersones, autorEntitats, titol, descripcio, genere, dipositLegal, pais, idioma, versioDigital, tipus, textOCR)
{
    override fun toString(): String {
        val sb : StringBuilder = StringBuilder(super.toString());

        sb.appendLine("\tISBN: $iSBN");
        sb.appendLine("\tTema: $tema");
        sb.appendLine("------------------------------------------------------------------------------");

        return sb.toString();
    }
}
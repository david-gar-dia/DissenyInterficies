class Musica (
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
    tipus : TipusDocument = TipusDocument.Musica,
    val editorMusical : String = "",
    val interprets : String = "",
    val formaComposicio : String = ""

) : So(idBNE, autorPersones, autorEntitats, titol, descripcio, genere, dipositLegal, pais, idioma, versioDigital, tipus)
{
    override fun toString(): String {
        val sb : StringBuilder = StringBuilder(super.toString());

        sb.appendLine("\tEditor musical: $editorMusical");
        sb.appendLine("\tForma composició: $formaComposicio");
        sb.appendLine("\tInterprets: $interprets");
        sb.appendLine("------------------------------------------------------------------------------");


        return sb.toString();
    }
}
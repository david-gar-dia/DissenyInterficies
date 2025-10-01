class Musica (
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
    tipus : TipusDocument = TipusDocument.Musica,
    val editorMusical : String = "",
    val formaComposicio : String = "",
    val interprets : String = ""
) : So(idBNE, autorPersones, autorEntitats, titol, descripcio, genere, dipositLegal, pais, idioma, versioDigital, tipus)
{
    override fun toString(): String {
        val sb : StringBuilder = StringBuilder(super.toString());

        sb.appendLine("\tEditor musical: $editorMusical");
        sb.appendLine("\tForma composició: $formaComposicio");
        sb.appendLine("\tInterprets: $interprets");

        return sb.toString();
    }
}
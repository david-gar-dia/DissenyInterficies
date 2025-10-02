class Dibuix (
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
    tipus : TipusDocument = TipusDocument.Dibuix
) : Document(idBNE, autorPersones, autorEntitats, titol, descripcio, genere, dipositLegal, pais, idioma, versioDigital, tipus)
{
    override fun toString(): String {
        return super.toString();
    }
}
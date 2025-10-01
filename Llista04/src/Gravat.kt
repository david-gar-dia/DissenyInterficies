class Gravat (
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
    tipus : TipusDocument = TipusDocument.Gravat,
    textOCR : String = "",
    iSBN : String = "",
    tema : String = "",
) : Publicacio(idBNE, autorPersones, autorEntitats, titol, descripcio, genere, dipositLegal, pais, idioma, versioDigital, tipus, textOCR, iSBN, tema)
{
    override fun toString(): String {
        return super.toString();
    }
}
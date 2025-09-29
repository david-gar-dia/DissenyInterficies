abstract class Document(
    val idBNE : String = "",
    val autorPersones : List<String> = listOf(),
    val autorEntitats : List<String> = listOf(),
    val titol : String = "",
    val descripcio : String = "",
    val genere : String = "",
    val dipositLegal : String = "",
    val pais : String = "",
    val idioma : String = "",
    val versioDigital : String = "",
    val tipus : TipusDocument
)
{
}
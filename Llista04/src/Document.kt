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
    open val tipus : TipusDocument
)
{
    override fun equals(other : Any?) : Boolean {
        var result:Boolean = true;
        val otherAsDocument : Document;

        if(other == null || other !is Document)
            result = false;
        else
            if(other.idBNE != idBNE)
                result = false;

        return result;
    }

    override fun toString(): String {
        val sb : StringBuilder = StringBuilder();

        sb.appendLine("${tipus.name}:");
        sb.appendLine("\tidBNE: $idBNE");
        sb.appendLine("\tAutors (Persones):");
        autorPersones.forEach() {
            sb.appendLine("\t\t$it");
        }
        sb.appendLine("\tAutors (Entitats):");
        autorEntitats.forEach() {
            sb.appendLine("\t\t$it");
        }
        sb.appendLine("\tTítol: $titol");
        sb.appendLine("\tDescripció:");
        sb.appendLine("\t\t$descripcio");
        sb.appendLine("\tGènere: $genere");
        sb.appendLine("\tDipòsit Legal: $dipositLegal");
        sb.appendLine("\tPaís: $pais");
        sb.appendLine("\tIdioma: $idioma");
        sb.appendLine("\tVersió Digital: $versioDigital");

        return sb.toString();
    }
}
import java.io.File
import java.lang.IllegalArgumentException;
import java.util.Scanner;
import java.io.FileWriter
import javax.swing.DefaultListSelectionModel

fun main() {
    val scanner : Scanner = Scanner(System.`in`);
    val biblioteca : MutableList<Document> = mutableListOf();
    var optionChosen : Int;
    var incorrectOption : Boolean = false;

    do
    {
        netejarConsola();
        if(incorrectOption)
        {
            println("L'opció introduit no es válid.\n");
            incorrectOption = false;
        }
        mostrarMenu();
        optionChosen = scanner.nextInt();
        scanner.nextLine();

        netejarConsola();

        when(optionChosen) {
            1 -> {
                println("Introdueix el nom del fitxer: ");
                var curFilename = scanner.nextLine();
                println("Introdueix el tipus de document a dins del fitxer: ");
                var curTipusString = scanner.nextLine();
                var curDocTipus = TipusDocument.valueOf(curTipusString.substring(0,1).uppercase() + curTipusString.substring(1).lowercase())

                var curLlista = llegeix(curFilename, curDocTipus);
                curLlista.forEach {
                    biblioteca.add(it);
                };
                println("Operació completat, ${curLlista.count()} documents afegits.");
                println("Prem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            2 -> {
                println("Introdueix el nom del fitxer: ");
                var curFilename = scanner.nextLine();

                desa(curFilename, biblioteca);
                println("Operació completat, la biblioteca es troba al fitxer ${curFilename}.");
                println("Prem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            3 -> {
                var curDocument = ompleDocument();

                altaDocument(curDocument, biblioteca);
                println("Operació completat, el nou document es el nombre ${biblioteca.count() - 1}.")
                println("Prem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            4 -> {
                println("Introdueix el idBNE del document a eliminar: ");
                var curIdBNE = scanner.nextLine();

                if(eliminaDocument(curIdBNE, biblioteca))
                    println("El document ha segut eliminat amb éxit.");
                else
                    println("No existeix cap document amb aquest IdBNE.");

                println("Prem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            5 -> {
                println("Introdueix la posició del document a eliminar: ");
                var curPosicio = scanner.nextInt();
                scanner.nextLine();

                if(eliminaPosicio(curPosicio, biblioteca))
                    println("El document ha segut eliminat amb éxit.");
                else
                    println("No existeix cap document a aquesta posició.");

                println("Prem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            6 -> {
                println("Llista paisos: ")
                llistaPaisos(biblioteca);

                println("\nPrem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            7 -> {
                println("Introdueix el pais per al que vols comprovar: ");
                var curPais = scanner.nextLine();

                llistaPais(curPais.lowercase(), biblioteca);
                println("\nPrem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            8 -> {
                println("Llista idiomas: ");
                llistaIdiomes(biblioteca);

                println("\nPrem cualsevol botó per continuar: ");
                scanner.nextLine();
            }
            9 -> {
                println("Introdueix el idioma per al que vols comprovar: ");
                var curIdioma = scanner.nextLine();

                llistaIdioma(curIdioma,biblioteca);
                println("\nPrem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            10 -> {
                println("Introdueix el IdBNE per a buscar: ");
                var curIdBNE = scanner.nextLine();

                llistaLlibre(curIdBNE, biblioteca);
                println("\nPrem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            11 -> {
                println("Introdueix la posició per a buscar: ");
                var curPosicio = scanner.nextInt();
                scanner.nextLine();

                llistaPos(curPosicio, biblioteca);
                println("\nPrem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            12 -> {
                println("Introdueix la posició inicial per a buscar: ");
                var curPosicioInicial = scanner.nextInt();
                scanner.nextLine();

                println("Introdueix la posició final per a buscar: ");
                var curPosicioFinal = scanner.nextInt();
                scanner.nextLine();

                llistaRang(curPosicioInicial, curPosicioFinal, biblioteca);
                println("\nPrem cualsevol botó per continuar...");
                scanner.nextLine();
            }
            else -> incorrectOption = true;
        }

    } while(optionChosen != 13)
}
// Funciones de menu
fun netejarConsola() {
    for(i in 0..20)
        println("");
}
fun mostrarMenu() {
    println("1) Afegir fitxer de documents a la biblioteca");
    println("2) Afegir contenits de biblioteca a fitxer");
    println("3) Afegir un document nou a la biblioteca");
    println("4) Eliminar un document de la biblioteca per idBNE");
    println("5) Eliminar un document de la biblioteca per posició");
    println("6) Llistar tots els diferents paisos de proviniència de la biblioteca");
    println("7) Llistar tots els documents d'un pais determinat");
    println("8) Llistar tots els diferents idiomas dels documents a la biblioteca");
    println("9) Llistar tots els documents d'un idioma determinat");
    println("10) Llistar un document per idBNE");
    println("11) Llistar un llibre per posició");
    println("12) Llistar un llibre per rang de posicions");
    println("13) Sortir");
    println("Tria una opció: ");
}

// Funciones de modificació de la biblioteca
fun separa(sequenciaValors : String) : List<String> {
    val substringList : MutableList<String>;
    val result : List<String>;

    substringList = sequenciaValors.split("//").toMutableList();
    for(i in 0..<substringList.count())
        substringList[i] = substringList[i].trim();

    substringList.removeLast();
    result = substringList.toList();

    return result;
}
fun converteix(dadesDocument : String, tipus : TipusDocument) : Document {
    val result : Document;
    val splitResult : List<String>;
    val idBNE : String;
    val autorPersones : List<String>;
    val autorEntitats : List<String>;
    val titol : String;
    val descripcio : List<String>;
    val genere : String;
    val dipositLegal : String;
    val pais : String;
    val idioma : String;
    val versioDigital : String;

    splitResult = dadesDocument.split(";");
    idBNE = splitResult[0];
    autorPersones = separa(splitResult[1]);
    autorEntitats = separa(splitResult[2]);
    titol = splitResult[3];
    descripcio = separa(splitResult[4]);
    genere = splitResult[5];
    dipositLegal = splitResult[6];
    pais = splitResult[7];
    idioma = splitResult[8];
    versioDigital = splitResult[9];

    when (tipus) {
        TipusDocument.Manuscrit -> {
            result = Manuscrit(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                splitResult[10]
            )
        }
        TipusDocument.Musica -> {
            result = Musica(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                splitResult[10],
                splitResult[11],
                splitResult[12],
            )
        }
        TipusDocument.Cartografia -> {
            result = Cartografia(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                splitResult[10],
                splitResult[11],
                splitResult[12],
                splitResult[13],
                splitResult[14],
                splitResult[15]
            );
        }
        TipusDocument.Dibuix -> {
            result = Dibuix(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus
            )
        }
        TipusDocument.Llibre -> {
            result = Llibre(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                splitResult[10],
                splitResult[11],
                splitResult[12],
                splitResult[13],
                splitResult[14]
            );
        }
        TipusDocument.Gravat -> {
            result = Gravat(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                splitResult[10],
                splitResult[11],
                splitResult[12]
            );
        }
        TipusDocument.Partitura -> {
            result = Partitura(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                splitResult[10]
            );
        }
        else -> throw IllegalArgumentException("The enum given does not exist within the options");
    };

    return result;
}
fun llegeix(filename : String, tipus : TipusDocument) : List<Document> {
    val file : File = File("src/${filename}");
    val scanner : Scanner = Scanner(file);
    val documentsList : MutableList<Document> = mutableListOf();
    val result : List<Document>;
    var line : String;

    line = scanner.nextLine();
    line = scanner.nextLine();
    while(scanner.hasNextLine())
    {
        documentsList.add(converteix(line, tipus));
        line = scanner.nextLine();
    }

    result = documentsList.toList();

    return result;
}
fun desa(filename : String, biblioteca : MutableList<Document>) : Unit {
    val file : FileWriter = FileWriter(filename, true);

    biblioteca.forEach {
        val sb : StringBuilder = StringBuilder();
        sb.append(it.idBNE);
        sb.append(";");
        it.autorPersones.forEach { autor ->
            sb.append(autor);
            sb.append(" // ");
        }
        sb.append(";");
        it.autorEntitats.forEach { entitat ->
            sb.append(entitat);
            sb.append(" // ");
        }
        sb.append(";");
        sb.append(it.titol);
        sb.append(";");
        it.descripcio.forEach { linia ->
            sb.append(linia);
            sb.append(" // ");
        }
        sb.append(it.genere);
        sb.append(";");
        sb.append(it.dipositLegal);
        sb.append(";");
        sb.append(it.pais);
        sb.append(";");
        sb.append(it.idioma);
        sb.append(";");
        sb.append(it.versioDigital);
        sb.append(";");
        when (it.tipus) {
            TipusDocument.Manuscrit -> {
                val itAsManuscrit : Manuscrit = it as Manuscrit;
                sb.append(itAsManuscrit.textOCR);
                sb.append(";");
            }
            TipusDocument.Llibre -> {
                val itAsLlibre : Llibre = it as Llibre;
                sb.append(itAsLlibre.textOCR);
                sb.append(";");
                sb.append(itAsLlibre.tema);
                sb.append(";");
                sb.append(itAsLlibre.iSBN);
                sb.append(";");
                sb.append(itAsLlibre.editorial);
                sb.append(";");
                sb.append(itAsLlibre.llocPublicacio);
                sb.append(";");
            }
            TipusDocument.Partitura -> {
                val itAsPartitura : Partitura = it as Partitura;
                sb.append(itAsPartitura.formaComposicio);
                sb.append(";");
            }
            TipusDocument.Cartografia -> {
                val itAsCartografia : Cartografia = it as Cartografia;
                sb.append(itAsCartografia.textOCR);
                sb.append(";");
                sb.append(itAsCartografia.tema);
                sb.append(";");
                sb.append(itAsCartografia.iSBN);
                sb.append(";");
                sb.append(itAsCartografia.tipusMaterialCartografico);
                sb.append(";");
                sb.append(itAsCartografia.projeccioDelMapa);
                sb.append(";");
                sb.append(itAsCartografia.escalaDelMapa);
                sb.append(";");
            }
            TipusDocument.Gravat -> {
                val itAsGravat : Gravat = it as Gravat;
                sb.append(itAsGravat.textOCR);
                sb.append(";");
                sb.append(itAsGravat.tema);
                sb.append(";");
                sb.append(itAsGravat.iSBN);
                sb.append(";");
            }
            TipusDocument.Dibuix -> {
            }
            TipusDocument.Musica -> {
                val itAsMusica : Musica = it as Musica;

                sb.append(itAsMusica.editorMusical);
                sb.append(";");
                sb.append(itAsMusica.interprets);
                sb.append(";");
                sb.append(itAsMusica.formaComposicio);
                sb.append(";");
            }
            else -> throw IllegalArgumentException("The enum given does not exist within the options");
        }
        sb.appendLine("");
        file.write(sb.toString());
    }
    file.close();
}
fun ompleDocument() : Document {
    val result : Document;
    val scanner : Scanner = Scanner(System.`in`);
    var curAnswer : String;
    val idBNE : String;
    val autorPersones : List<String>;
    val autorEntitats : List<String>;
    val titol : String;
    val descripcio : List<String>;
    val genere : String;
    val dipositLegal : String;
    val pais : String;
    val idioma : String;
    val versioDigital : String;
    val tipus : TipusDocument;

    print("Introdueix idBNE: ");
    idBNE = scanner.nextLine();
    print("Introdueix l'autor/s (Escriure // després de cadascún): ");
    curAnswer = scanner.nextLine();
    autorPersones = separa(curAnswer);
    print("Introdueix l'entitat/s autora/es (Escriure // després de cadascún): ");
    curAnswer = scanner.nextLine();
    autorEntitats = separa(curAnswer);
    print("Introdueix el titol: ");
    titol = scanner.nextLine();
    print("Introdueix una descripció (Escriure // per a canviar de linia): ");
    curAnswer = scanner.nextLine();
    descripcio = separa(curAnswer);
    print("Introdueix el/s genere/s: ");
    genere = scanner.nextLine();
    print("Introdueix el diposit legal: ");
    dipositLegal = scanner.nextLine();
    print("Introdueix el pais de llançament: ");
    pais = scanner.nextLine();
    print("Introdueix el idioma: ");
    idioma = scanner.nextLine();
    print("Introdueix el codi de la versió digital: ");
    versioDigital = scanner.nextLine();

    print("Introdueix el tipus de document del que's trata: ");
    curAnswer = scanner.nextLine();
    tipus = TipusDocument.valueOf(curAnswer.substring(0,1).uppercase() + curAnswer.substring(1).lowercase());

    when (tipus) {
        TipusDocument.Manuscrit -> {
            print("Introdueix el TextOCR del manuscrit: ");
            val textOCR : String = scanner.nextLine();

            result = Manuscrit(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                textOCR
            );
        }
        TipusDocument.Llibre -> {
            print("Introdueix el TextOCR del llibre: ");
            val textOCR : String = scanner.nextLine();
            print("Introdueix el tema del llibre: ");
            val tema : String = scanner.nextLine();
            print("Introdueix el ISBN del llibre: ");
            val iSBN : String = scanner.nextLine();
            print("Introdueix la editorial del llibre: ");
            val editorial : String = scanner.nextLine();
            print("Introdueix el lloc de publicació del llibre: ");
            val llocPublicacio : String = scanner.nextLine();

            result = Llibre(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                textOCR,
                tema,
                iSBN,
                editorial,
                llocPublicacio
            );
        }
        TipusDocument.Partitura -> {
            print("Introdueix la forma de la composició de la partitura: ");
            val formaComposicio : String = scanner.nextLine();

            result = Partitura(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                formaComposicio
            )
        }
        TipusDocument.Cartografia -> {
            print("Introdueix el TextOCR del mapa: ");
            val textOCR : String = scanner.nextLine();
            print("Introdueix el tema del mapa: ");
            val tema : String = scanner.nextLine();
            print("Introdueix el ISBN del mapa: ");
            val iSBN : String = scanner.nextLine();
            print("Introdueix el tipus del material del mapa: ");
            val tipusMaterialCartografico : String = scanner.nextLine();
            print("Introdueix la projecció del mapa: ");
            val projeccioDelMapa : String = scanner.nextLine();
            print("Introdueix l'escala del mapa: ");
            val escalaDelMapa : String = scanner.nextLine();

            result = Cartografia(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                textOCR,
                tema,
                iSBN,
                tipusMaterialCartografico,
                projeccioDelMapa,
                escalaDelMapa
            )
        }
        TipusDocument.Gravat -> {
            print("Introdueix el TextOCR del gravat: ");
            val textOCR : String = scanner.nextLine();
            print("Introdueix el tema del gravat: ");
            val tema : String = scanner.nextLine();
            print("Introdueix el ISBN del gravat: ");
            val iSBN : String = scanner.nextLine();

            result = Gravat(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                textOCR,
                tema,
                iSBN
            )
        }
        TipusDocument.Dibuix -> {
            result = Dibuix(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus
            )
        }
        TipusDocument.Musica -> {
            print("Escriure el editor d'aquesta peça musical: ");
            val editorMusical : String = scanner.nextLine();
            print("Escriure l'interpret/s d'aquesta peça musical: ");
            val interprets : String = scanner.nextLine();
            print("Escriure la forma de composició d'aquesta peça musical: ");
            val formaComposicio : String = scanner.nextLine();

            result = Musica(
                idBNE,
                autorPersones,
                autorEntitats,
                titol,
                descripcio,
                genere,
                dipositLegal,
                pais,
                idioma,
                versioDigital,
                tipus,
                editorMusical,
                interprets,
                formaComposicio
            );
        }
        else -> throw IllegalArgumentException("The enum given does not exist within the options");
    }

    return result;
}
fun altaDocument(nouDocument : Document, biblioteca: MutableList<Document>) : Unit {
    var trobat : Boolean = false;
    var count : Int = 0;

    while(!trobat && count < biblioteca.count())
    {
        trobat = biblioteca[count].idBNE == nouDocument.idBNE;
        count++;
    }

    if(trobat)
        biblioteca[count - 1] = nouDocument;
    else
        biblioteca.add(nouDocument);
}
fun eliminaDocument(idBNE : String, biblioteca: MutableList<Document>) : Boolean {
    var trobat : Boolean = false;
    var count : Int = 0;

    while(!trobat && count < biblioteca.count())
    {
        trobat = biblioteca[count].idBNE == idBNE;
        count++;
    }

    if(trobat)
        biblioteca.removeAt(count - 1);

    return trobat;
}
fun eliminaPosicio(position : Int, biblioteca: MutableList<Document>) : Boolean {
    var result : Boolean = true;

    if(position >= biblioteca.count())
        result = false;
    else
        biblioteca.removeAt(position);

    return result;
}
fun llistaPaisos(biblioteca : MutableList<Document>) : Unit {
    val differentCountries : MutableSet<String> = mutableSetOf();

    biblioteca.forEach {
        differentCountries.add(it.pais);
    };

    differentCountries.forEach {
        println(it);
    }
}
fun llistaPais(pais: String, biblioteca : MutableList<Document>) : Unit {
    biblioteca.forEach {
        if(it.pais == pais)
            println(it);
    }
}
fun llistaIdiomes(biblioteca : MutableList<Document>) : Unit {
    val differentLanguages: MutableSet<String> = mutableSetOf();

    biblioteca.forEach {
        differentLanguages.add(it.idioma);
    };

    differentLanguages.forEach {
        println(it);
    }
}
fun llistaIdioma(idioma : String, biblioteca : MutableList<Document>) : Unit {
    biblioteca.forEach {
        if(it.idioma == idioma)
            println(it);
    }
}
fun llistaLlibre(idBNE : String, biblioteca: MutableList<Document>) : Boolean {
    var found : Boolean = false;
    var count : Int = 0;

    while(count < biblioteca.count() && !found)
    {
        found = biblioteca[count].idBNE == idBNE;
        count++;
    }

    if(found)
        println(biblioteca[count - 1]);
    else
        println("No existeix cap document amb aquest idBNE");

    return found;
}
fun llistaPos(posicio : Int, biblioteca : MutableList<Document>) : Boolean {
    val exists : Boolean = posicio < biblioteca.count();

    if(exists)
        println(biblioteca[posicio]);
    else
        println("No existeix cap Document en aquesta posició");

    return exists;
}
fun llistaRang(posicioInicio : Int, posicioFinal : Int, biblioteca: MutableList<Document>) : Boolean {
    var existeixenDocuments : Boolean;
    var pI : Int = posicioInicio;
    var pF : Int = posicioFinal;

    if (posicioInicio > posicioFinal)
    {
        pI = posicioFinal;
        pF = posicioInicio;
    }

    existeixenDocuments = pI < biblioteca.count();

    if(existeixenDocuments)
    {
        if(pF >= biblioteca.count())
            pF = biblioteca.count() - 1;

        for(i in pI..pF)
            println(biblioteca[i]);
    }
    else
        println("No existeix cap Document en el rang seleccionat");

    return existeixenDocuments;
}
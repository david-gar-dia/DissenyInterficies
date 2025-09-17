import java.util.Scanner;
import javax.swing.DefaultListSelectionModel

fun main() {
    fun Ejercicio1() : Unit {
        var currentLetter : Char;
        var numberIndex : Int = 0;

        print("Escribe una frase delimitada por '.': ");
        currentLetter = System.`in`.read().toChar();

        while(currentLetter != '.')
        {
            numberIndex++;
            currentLetter = System.`in`.read().toChar();
        }

        println("Ha habido $numberIndex caracteres antes de llegar al '.'")
    }
    fun Ejercicio2() : Unit {
        var currentLetter : Char;
        var numberIndex : Int = 0;

        print("Escribe una frase delimitada por '.': ");
        currentLetter = System.`in`.read().toChar();

        while(currentLetter != '.' && currentLetter != 'a' && currentLetter != 'A')
            currentLetter = System.`in`.read().toChar();

        while(currentLetter != '.')
        {
            numberIndex++;
            currentLetter = System.`in`.read().toChar();
        }

        if(numberIndex == 0)
            println("No ha habido una letra 'a' en ningún lugar de la frase.")
        else
            println("Ha habido $numberIndex caracteres entre la 'a' y el final de la frase")
    }
    fun Ejercicio3() : Unit {
        val scanner = Scanner(System.`in`);
        var prevNumber : Int;
        var curNumber : Int;

        print("Introduce una lista de números separados por espacios (El 0 marca el final): ");
        prevNumber = scanner.nextInt();

        if(prevNumber != 0)
        {
            curNumber = scanner.nextInt();
            while(curNumber != 0 && prevNumber <= curNumber)
            {
                prevNumber = curNumber;
                curNumber = scanner.nextInt();
            }
        }
        else
            curNumber = prevNumber;

        if(curNumber != 0)
            println("La secuencia de números NO es creciente");
        else
            println("La secuencia de números es creciente");
    }
    fun Ejercicio4() : Unit {
        val scanner = Scanner(System.`in`);
        var curNumber : Int;

        print("Introduce una lista de números separados por espacios (El 0 marca el final): ");
        curNumber = scanner.nextInt();

        while(curNumber > 0)
            curNumber = scanner.nextInt();

        if(curNumber != 0)
            println("La secuencia de números contiene negativos");
        else
            println("La secuencia de números contiene únicamente positivos");
    }
    fun Ejercicio5() : Unit {
        val scanner = Scanner(System.`in`);
        var currentInput : String;
        var currentNumber : Int;
        var prevNumber : Int;
        var olderPrevNumber : Int;

        print("Introduce un número: ");
        currentInput = scanner.nextLine();
        prevNumber = currentInput.toInt();

        print("Introduce un número: ");
        currentInput = scanner.nextLine();
        currentNumber = currentInput.toInt();

        do
        {
            print("Introduce un número: ");
            currentInput = scanner.nextLine();
            olderPrevNumber = prevNumber;
            prevNumber = currentNumber;
            currentNumber = currentInput.toInt();
        } while(currentNumber <= olderPrevNumber + prevNumber);

        println("El programa ha terminado.");
        print("Mótivo: $olderPrevNumber + $prevNumber = " + (olderPrevNumber + prevNumber));
        println(" | Número dado: $currentNumber");
    }
    fun Ejercicio6() : Unit {
        var currentLetter : Char;

        print("Escribe una frase delimitada por '.': ");
        currentLetter = System.`in`.read().toChar();

        println("La frase sin ningún espacio sería: ");

        while(currentLetter != '.')
        {
            if(currentLetter != ' ')
                print(currentLetter);
            currentLetter = System.`in`.read().toChar();
        }
    }
    fun Ejercicio7() : Unit {
        val scanner = Scanner(System.`in`);
        var countMult3 : Int = 0;
        var countBigger5 : Int = 0;
        var currentInput : String;
        var currentNumber : Int;
        var numberInputs : Int;

        print("¿Cuántos números te gustaría introducir? ");
        currentInput = scanner.nextLine();
        numberInputs = currentInput.toInt();

        for(index in 1..numberInputs)
        {
            print("Introduce un número: ");
            currentInput = scanner.nextLine();
            currentNumber = currentInput.toInt();

            if(currentNumber >= 5)
                countBigger5++;

            if(currentNumber % 3 == 0 && currentNumber != 0)
                countMult3++;
        }

        println("\nEl programa ha terminado.");
        println("Números mayores que 5: $countBigger5");
        println("Números múltiplo de 3: $countMult3");
    }
    fun Ejercicio8() : Unit {
        val scanner = Scanner(System.`in`);
        var lesserNumber : Int = Int.MAX_VALUE;
        var lesserPosition : Int = 0;
        var currentInput : String;
        var currentNumber : Int;
        var countNumbers : Int = 0;
        var numberInputs : Int;

        print("¿Cuántos números te gustaría introducir? ");
        currentInput = scanner.nextLine();
        numberInputs = currentInput.toInt();

        for(index in 1..numberInputs)
        {
            print("Introduce un número: ");
            currentInput = scanner.nextLine();
            currentNumber = currentInput.toInt();
            countNumbers++;

            if(currentNumber < lesserNumber)
            {
                lesserPosition = countNumbers;
                lesserNumber = currentNumber;
            }
        }

        println("\nEl programa ha terminado.");
        if(lesserPosition == 0)
            println("Ningún número ha sido introducido");
        else
        {
            println("El número más pequeño es: $lesserNumber");
            println("El número más pequeño se encuentra en la posición: $lesserPosition");
        }
    }
    fun Ejercicio9() : Unit {
        val scanner = Scanner(System.`in`);
        var numberGiven : Int;
        var numberGivenSqrt : Double;
        var divider : Int = 2;

        print("Introduzca el número a comprobar: ");
        numberGiven = scanner.nextInt();

        numberGivenSqrt = Math.sqrt(numberGiven.toDouble());

        while(divider <= numberGivenSqrt && numberGiven % divider != 0)
            divider++;

        if(numberGiven % divider == 0 && divider < numberGiven || numberGiven == 1)
            println("El número $numberGiven NO es primo");
        else
            println("El número $numberGiven es primo");
    }

    var scanner = Scanner(System.`in`);
    var optionChosen : Int;

    println("Selecciona un ejercicio que verificar:");
    println("1) Ejercicio 1");
    println("2) Ejercicio 2");
    println("3) Ejercicio 3");
    println("4) Ejercicio 4");
    println("5) Ejercicio 5");
    println("6) Ejercicio 6");
    println("7) Ejercicio 7");
    println("8) Ejercicio 8");
    println("9) Ejercicio 9");

    optionChosen = scanner.nextInt();

    println("");
    when(optionChosen) {
        1 -> Ejercicio1();
        2 -> Ejercicio2();
        3 -> Ejercicio3();
        4 -> Ejercicio4();
        5 -> Ejercicio5();
        6 -> Ejercicio6();
        7 -> Ejercicio7();
        8 -> Ejercicio8();
        9 -> Ejercicio9();
        else -> throw Exception("Por favor, escoja una opción válida");
    };
}
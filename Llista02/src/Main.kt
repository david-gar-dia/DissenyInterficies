import java.util.Scanner;

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

    }
}
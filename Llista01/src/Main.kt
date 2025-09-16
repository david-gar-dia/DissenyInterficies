import java.util.Scanner;

fun main() {
    fun Ejercicio1() : Unit {
        var scanner = Scanner(System.`in`);
        var numEqualNumbers : Int = 1;
        var highestNumber : Int;
        var givenNumber1 : Int;
        var givenNumber2 : Int;
        var givenNumber3 : Int;

        print("Inserta un número en pantalla: ");
        givenNumber1 = scanner.nextInt();
        highestNumber = givenNumber1;

        print("Inserta otro número en pantalla: ");
        givenNumber2 = scanner.nextInt();
        if(givenNumber2 > highestNumber)
        {
            highestNumber = givenNumber2;
            numEqualNumbers = 1;
        }
        else if(givenNumber2 == highestNumber)
            numEqualNumbers++;

        print("Inserta otro número en pantalla: ");
        givenNumber3 = scanner.nextInt();
        if(givenNumber3 > highestNumber)
        {
            highestNumber = givenNumber3;
            numEqualNumbers = 1;
        }
        else if (givenNumber3 == highestNumber)
            numEqualNumbers++;

        println("El número más grande es $highestNumber" + if (numEqualNumbers == 2) " y aparece dos veces" else if (numEqualNumbers == 3) " y aparece tres veces" else "");

    }
    fun Ejercicio2() : Unit {
        var scanner = Scanner(System.`in`);
        var givenNumber1 : Int;
        var givenNumber2 : Int;
        var result : Int;

        print("Introduce un número: ");
        givenNumber1 = scanner.nextInt();
        print("Introduce otro número: ");
        givenNumber2 = scanner.nextInt();

        result = givenNumber1 - givenNumber2;

        if(result < 0)
            result *= -1;

        println("El valor absoluto de la diferencia entre $givenNumber1 y $givenNumber2 es $result");
    }
    fun Ejercicio3() : Unit {
        var scanner = Scanner(System.`in`);
        var givenNumber1 : Int;
        var givenNumber2 : Int;

        print("Introduce un número: ");
        givenNumber1 = scanner.nextInt();
        if(givenNumber1 < 0)
            throw Exception("El valor del número no puede ser negativo");
        print("Introduce otro número: ");
        givenNumber2 = scanner.nextInt();
        if(givenNumber2 < 0)
            throw Exception("El valor del número no puede ser negativo");

        if(givenNumber1 == 0 || givenNumber2 == 0)
            throw Exception("Los valores de los números no pueden ser 0");

        if(givenNumber1 % givenNumber2 == 0 || givenNumber2 % givenNumber1 == 0)
            println("Los números $givenNumber1 y $givenNumber2 son divisibles entre si");
        else
            println("Los números $givenNumber1 y $givenNumber2 NO son divisibles entre si");
    }
    fun Ejercicio4() : Unit {
        var scanner = Scanner(System.`in`);
        var yearToCheck : Int;

        print("Introduce un año: ");
        yearToCheck = scanner.nextInt();

        if((yearToCheck % 4 == 0 && yearToCheck % 100 != 0) || yearToCheck % 400 == 0)
            println("El año $yearToCheck es bisiesto");
        else
            println("El año $yearToCheck NO es bisiesto");
    }
    fun Ejercicio5() : Unit {
        var scanner = Scanner(System.`in`);
        var givenTime : Int;
        var resultHours : Int;
        var resultMinutes : Int;
        var resultSeconds : Int;

        print("Introduzca el número de segundos: ");
        givenTime = scanner.nextInt();
        if(givenTime < 0)
            throw Exception("El valor no puede ser negativo");

        resultHours = givenTime / 3600;
        resultMinutes = givenTime % 3600 / 60;
        resultSeconds = givenTime % 60;

        println("El tiempo formateado sería: $resultHours:$resultMinutes:$resultSeconds");
    }
    fun Ejercicio6() : Unit {
        var scanner = Scanner(System.`in`);
        var givenHours : Int;
        var givenMinutes : Int;
        var givenSeconds : Int;

        print("Introduzca el número de horas: ");
        givenHours = scanner.nextInt();
        if(givenHours < 0 || givenHours > 23)
            throw Exception("El valor dado está fuera del rango");

        print("Introduzca el número de minutos: ");
        givenMinutes = scanner.nextInt();
        if(givenMinutes < 0 || givenMinutes > 59)
            throw Exception("El valor dado está fuera del rango");

        print("Introduzca el número de segundos: ")
        givenSeconds = scanner.nextInt();
        if(givenSeconds < 0 || givenSeconds > 59)
            throw Exception("El valor dado está fuera del rango");

        if(++givenSeconds >= 60)
        {
            if(++givenMinutes >= 60)
            {
                if(++givenHours >= 24)
                    givenHours = 0;
                givenMinutes = 0;
            }
            givenSeconds = 0;
        }

        println("Sumado un segundo, quedaría como: $givenHours:$givenMinutes:$givenSeconds");
    }
    fun Ejercicio7() : Unit {
        var scanner = Scanner(System.`in`);
        var import2Pay : Double;
        var quantityPaid : Double;
        var change : Double;
        var intChange : Int;
        var quant2Eur : Int;
        var quant1Eur : Int;
        var quant50Cent : Int;
        var quant20Cent : Int;
        var quant10Cent : Int;
        var quant5Cent : Int;
        var quant2Cent : Int;

        print("Introducir el importe que se quiere pagar: ");
        import2Pay = scanner.nextDouble();
        print("Introduce la cantidad con la que se paga: ");
        quantityPaid = scanner.nextDouble();

        if(quantityPaid <= import2Pay)
            println("No hay ningún cambio con la cantidad pagada escogida");
        else
        {
            change = quantityPaid - import2Pay;
            intChange = (change * 100).toInt();

            quant2Eur = intChange / 200;
            intChange %= 200;
            quant1Eur = intChange / 100;
            intChange %= 100;
            quant50Cent = intChange / 50;
            intChange %= 50;
            quant20Cent = intChange / 20;
            intChange %= 20;
            quant10Cent = intChange / 10;
            intChange %= 10;
            quant5Cent = intChange / 5;
            intChange %= 5;
            quant2Cent = intChange / 2;
            intChange %= 2;

            println("De cambio quedan:")
            println("$quant2Eur de monedas de 2€");
            println("$quant1Eur de monedas de 1€");
            println("$quant50Cent de monedas de 50 centimos");
            println("$quant20Cent de monedas de 20 centimos");
            println("$quant10Cent de monedas de 10 centimos");
            println("$quant5Cent de monedas de 5 centimos");
            println("$quant2Cent de monedas de 2 centimos");
            println("$intChange de monedas de 1 centimo");
        }
    }
    fun Ejercicio8() : Unit {
        var scanner = Scanner(System.`in`);
        var limitTable : Int;
        var curResult : Int;

        print("Hasta que tabla de multiplicar quieres?: ");
        limitTable = scanner.nextInt();
        if(limitTable <= 0)
            throw Exception("El valor debe ser positivo distinto de 0");

        for(index in 1..limitTable)
        {
            println("Tabla de multiplicar del $index");
            for(innerIndex in 1..10)
            {
                curResult = index * innerIndex;
                println("$index * $innerIndex = $curResult");
            }
            println("");
        }
    }
    fun Ejercicio9() : Unit {
        var scanner = Scanner(System.`in`);
        var limitInput : Int;
        var curResult : Int;

        print("Introduce el límite de líneas que quieres ver: ");
        limitInput = scanner.nextInt();
        if(limitInput <= 0)
            throw Exception("El número no puede ser menor o igual que 0");

        for(index in 1..limitInput)
        {
            curResult = 0;
            print("1 ");
            for(innerIndex in 2..index)
            {
                print("+ $innerIndex ");
                curResult += innerIndex;
            }
            println("= $curResult");
        }
    }
    fun Ejercicio10(num1 : Int, num2 : Int) : Int {
        var residue : Int;
        var a : Int = num1;
        var b : Int = num2;

        if(num1 <= 0 || num2 <= 0)
            throw Exception("Ningún número puede ser menor o igual que 0");

        do
        {
            residue = a % b;
            a = b;
            b = residue;
        }while(residue != 0)

        return a;
    }
    fun Ejercicio11() : Unit {
        var scanner = Scanner(System.`in`);
        var num1 : Int = 1;
        var num2 : Int = 1;
        var aux : Int;
        var numbersShown : Int;

        print("Cuántos números quieres que se muestren?: ");
        numbersShown = scanner.nextInt();
        if(numbersShown < 0)
            throw Exception("El número introducido no puede ser menor a 0");

        if(numbersShown != 0)
            print(num1);
        for(index in 1 until numbersShown)
        {
            aux = num1 + num2;
            num1 = num2;
            num2 = aux;
            print(", $num1");
        }
    }
    fun Ejercicio12() : Unit {
        var scanner = Scanner(System.`in`);
        var optionChosen : Int;
        var radius : Double;
        var result : Double;

        println("Elija qué quiere calcular:\n1) Longitud de circunferencia\n2) Área de un círculo\n3) Volumen de un círculo");
        optionChosen = scanner.nextInt();

        while(optionChosen != 1 && optionChosen != 2 && optionChosen != 3)
        {
            println("La opción dada no es correcta.\n1) Longitud de circunferencia\n2) Área de un círculo\n3) Volumen de un círculo");
            optionChosen = scanner.nextInt();
        }

        print("Determine el radio para calcular: ");
        radius = scanner.nextDouble();
        if(radius <= 0)
            throw Exception("El radio debe ser mayor que 0")

        when (optionChosen)
        {
            1 -> {
                result = 2 * Math.PI * radius;
                print("La longitud de un circunferencia de radio ");
            };
            2 -> {
                result = Math.PI * Math.pow(radius, 2.0);
                print("El área de un círculo de radio ");
            };
            3 -> {
                result = (4/3).toDouble() * Math.PI * Math.pow(radius, 3.0);
                print("El volumen de una esfera de radio ")
            };
            else -> result = 0.0;
        }

        result = Math.round(result * 100).toDouble() / 100;
        println("$radius sería $result");
    }
    fun Ejercicio13() : Unit {
        var givenChar : Char;
        var charAsInt : Int;
        var result : Char;

        print("Introduce un caracter: ");
        givenChar = System.`in`.read().toChar();
        charAsInt = givenChar.code;

        if(charAsInt >= 97 && charAsInt < 123)
            charAsInt -= 32;

        result = charAsInt.toChar();

        if(result == givenChar)
            println("$givenChar -> Ningún cambio");
        else
            println("$givenChar -> $result");
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
    println("10) Ejercicio 10");
    println("11) Ejercicio 11");
    println("12) Ejercicio 12");
    println("13) Ejercicio 13");

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
        10 -> {
            var num1 : Int;
            var num2 : Int;
            var result : Int;

            print("Introduzca un número: ");
            num1 = scanner.nextInt();

            print("Introduza otro número: ");
            num2 = scanner.nextInt();

            result = Ejercicio10(num1, num2);
            println("El máximo común divisor de $num1 y $num2 es $result");
        };
        11-> Ejercicio11();
        12 -> Ejercicio12();
        13 -> Ejercicio13();
        else -> throw Exception("Por favor, escoja una opción válida");
    }


}
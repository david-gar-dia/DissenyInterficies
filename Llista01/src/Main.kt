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
            for(innerIndex in 1..index)
            {
                if(innerIndex == 1)
                    print(innerIndex );
                else
                    print("+ $innerIndex ");
                curResult += innerIndex;
            }
            println("= $curResult");
        }
    }
    fun Ejercicio10(num1 : Int, num2 : Int) : Int {
        var residue : Int;

        if(num1 <= 0 || num2 <= 0)
            throw Exception("Ningún número puede ser menor o igual que 0");

        do
        {
            residue = num1 % num2;
            num1 = num2;
            num2 = residue;
        }while(residue != 0)
    }
}
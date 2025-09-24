import java.util.Scanner;

fun main() {
}
fun readTable(table : MutableList<MutableList<Int>>):Unit {
    table.forEach { i ->
        i.forEach { j ->
            print("$j ");
        }
        println("");
    }
}
fun readVector(vector : MutableList<Int>) {
    vector.forEach {
        print("$it ");
    }
}
fun ejercicio1():Unit {
    val testTable : MutableList<MutableList<Int>> = mutableListOf();
    val row1 : MutableList<Int> = mutableListOf(1, 2, 3);
    val row2 : MutableList<Int> = mutableListOf(4, 1, 3);
    val row3 : MutableList<Int> = mutableListOf(6, 1, 2);
    val row4 : MutableList<Int> = mutableListOf(9, 8, 7);

    testTable.add(row1);
    testTable.add(row2);
    testTable.add(row3);
    testTable.add(row4);

    readTable(testTable);

    println("");

    val testVector : MutableList<Int> = mutableListOf(1, 0, 2, 5);

    readVector(testVector);
}
fun ejercicio2():MutableList<MutableList<Int>> {
    val table : MutableList<MutableList<Int>> = mutableListOf();
    val scanner = Scanner(System.`in`);
    var numColumns : Int;
    var numRows : Int;

    print("Introduce el número de columnas que quieres: ");
    numColumns = scanner.nextInt();
    print("Introduce el número de filas que quieres: ");
    numRows = scanner.nextInt();

    println("");

    for(i in 0..< numColumns)
    {
        table.add(mutableListOf());
        for(j in 0..< numRows)
            table[i].add(i + 1);
    }

    return table;
}
fun ejercicio3():MutableList<MutableList<Int>> {
    val table : MutableList<MutableList<Int>> = mutableListOf();
    val scanner = Scanner(System.`in`);
    var numColumns : Int;
    var numRows : Int;

    print("Introduce el número de columnas que quieres: ");
    numColumns = scanner.nextInt();
    print("Introduce el número de filas que quieres: ");
    numRows = scanner.nextInt();

    println("");

    for(i in 0..< numColumns)
    {
        table.add(mutableListOf());
        for(j in 0..< numRows)
            table[i].add(j + 1);
    }

    return table;
}
fun ejercicio4():MutableList<MutableList<Int>> {
    val table : MutableList<MutableList<Int>> = mutableListOf();
    val scanner = Scanner(System.`in`);
    var numColumns : Int;
    var numRows : Int;

    print("Introduce el número de columnas que quieres: ");
    numColumns = scanner.nextInt();
    print("Introduce el número de filas que quieres: ");
    numRows = scanner.nextInt();

    println("");

    for(i in 0..< numRows)
    {
        table.add(mutableListOf());
        for(j in 0..< numColumns)
            table[i].add(j + 1 + i * numColumns);
    }

    return table;
}
fun ejercicio5():MutableList<MutableList<Int>> {
    val table : MutableList<MutableList<Int>> = mutableListOf();
    val scanner = Scanner(System.`in`);
    var numColumns : Int;
    var numRows : Int;

    print("Introduce el número de columnas que quieres: ");
    numColumns = scanner.nextInt();
    print("Introduce el número de filas que quieres: ");
    numRows = scanner.nextInt();

    println("");

    for(i in 0..< numRows)
    {
        table.add(mutableListOf());
        for(j in 0..< numColumns)
            table[i].add(numColumns * numRows - (j + i * numColumns));
    }

    return table;
}
fun ejercicio6():MutableList<MutableList<Int>> {
    val table : MutableList<MutableList<Int>> = mutableListOf();
    val scanner : Scanner = Scanner(System.`in`);
    var width : Int;

    print("Introduce la amplitud del cuadrado: ");
    width = scanner.nextInt();

    println("");

    for(i in 0..<width)
    {
        table.add(mutableListOf());
        for(j in 0..<width)
            if(j == i)
                table[i].add(1);
            else
                table[i].add(0);
    }

    return table;
}
fun ejercicio7():MutableList<Int> {
    val vector : MutableList<Int> = mutableListOf();
    val scanner : Scanner = Scanner(System.`in`);
    var vectorLength : Int;
    var currentNum : Int;

    print("¿Cuántos números guardará el vector? ");
    vectorLength = scanner.nextInt();

    println("");

    for(i in 0..<vectorLength)
    {
        print("Inserta el número de la posición $i: ");
        currentNum = scanner.nextInt();
        vector.add(currentNum);
    }

    return vector;
}
fun ejercicio8(vector : MutableList<Int>):Unit {
    var lowestNumber : Int = Int.MAX_VALUE;
    var positionLowestNumber : Int = -1;

    vector.forEachIndexed { index, element ->
        if(element < lowestNumber)
        {
            lowestNumber = element;
            positionLowestNumber = index;
        }
    }

    println("El número más pequeño es: $lowestNumber");
    println("Se encuentra en el índice: $positionLowestNumber");
}

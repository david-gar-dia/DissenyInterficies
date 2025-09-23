import java.util.Scanner;

fun main() {
    ejercicio3();
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
fun ejercicio2():Unit {
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

    readTable(table);
}
fun ejercicio3():Unit {
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

    readTable(table);
}
fun ejercicio4():Unit {
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
            table[i].add(j + 1 + i * numRows);
    }

    readTable(table);
}

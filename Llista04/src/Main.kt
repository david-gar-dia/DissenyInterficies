fun main() {

}
fun separa(input : String) : MutableList<String> {
    val listOfSubstrings : List<String>;
    val result : MutableList<String>;

    result = input.split("//").toMutableList();
    for(i in 0..<result.count())
        result[i] = result[i].trim();

    return result;
}
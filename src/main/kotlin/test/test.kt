package test
fun main() {
    var array = readln().split(" ").map { it.toInt() }

    if (array[0] > 2 * array[1] || array[1] > 2 * array[0]) {
        println("NO SOLUTION")
        return
    }

    val result: MutableList<String> = mutableListOf()
    var boys = array[0]-1
    var girls = array[1]-1

    if (boys > girls) {
        result.add("BG")
        while (boys > 0 || girls > 0) {
            if (boys > 0) {
                result.add("B")
                boys--
            }
            if (boys >= girls && boys > 0) {
                result.add("B")
                boys--
            }
            if (girls > 0) {
                result.add("G")
                girls--
            }
        }
    } else if (girls > boys) {
        result.add("GB")
        while (boys > 0 || girls > 0) {
            if (girls > 0) {
                result.add("G")
                girls--
            }
            if (girls >= boys && girls > 0) {
                result.add("G")
                girls--
            }
            if (boys > 0) {
                result.add("B")
                boys--
            }
        }
    } else {
        // boys == girls
        repeat(boys+2) {
            result.add("BG")
        }
    }
    if(result[0] == result[1]){
        result.removeAt(0)
    }

    println(result.joinToString(""))
}
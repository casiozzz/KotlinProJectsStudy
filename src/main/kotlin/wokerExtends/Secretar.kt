package wokerExtends

class Secretar(name: String, age: Int = 0): Worker(name = name, years = age) {
    fun bringCoffee(count: Int = 1):String {
        repeat(count) {
            println("Get Up")
            println("Go to coffee machine")
            println("Press the \"Cappucino\"")
            println("take coffee")
            println("Return workspace")
        }
        return "Esspresso"
    }

    override fun work(name: String){
        println("Секретарь ${name} несёт кофе")
    }
}
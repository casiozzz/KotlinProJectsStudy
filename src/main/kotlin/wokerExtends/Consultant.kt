package wokerExtends

import kotlin.random.Random

class Consultant (name: String, age: Int = 0):Worker(name =name, years = age){
    fun sayHello(){
        print("Hello! My name is $name")
        if(years > 0){
            print("I'm $years years old.\n")
        }
    }

    fun clientService(): Int{
        val count: Int = Random.nextInt(0,100)
        repeat(count) {
            println("Client service!")
        }
        return count
    }

    override fun work(name: String) {
        println("Консультант ${name} обслуживает клиентов")
    }
}
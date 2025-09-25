package wokerExtends

import java.time.Year

class Director (name: String,year: Int): Worker(name = name, years = year){

    override fun work(name: String){
        println("Директор ${name} пьёт кофе")
    }

    fun ConsutantWork(consultant: Consultant){
        val clientServices = consultant.clientService()
        println("Consultant ${consultant.name} service ${clientServices} clients")
    }

    fun takeCoffee(secretar: Secretar){
        val drinkName: String = secretar.bringCoffee()
        println("Thank you, ${secretar.name}! The ${drinkName} is very tasty :)")
    }

}
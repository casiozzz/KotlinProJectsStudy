package wokerExtends//fun main(){
//    val assistant = Secretar()
//    assistant.bringCoffee()
//}

fun main(){
    val consultant = Consultant(name = "Max")
    val director = Director("Andrey",25)
    val secretar = Secretar("Helen",20)
    val employes = listOf<Worker>(director,consultant, secretar)  //неявное наслеование от Any
    director.ConsutantWork(consultant)
    director.takeCoffee(secretar)
    for (employ in employes){
        employ.work(employ.name)
    }

}
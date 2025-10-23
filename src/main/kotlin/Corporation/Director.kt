package Corporation

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int = 100_000):Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = WorkerType.DIRECTOR
), Provider {

    override fun copy(id: Int, name: String, age: Int, salary: Int, position: WorkerType): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    override fun work(){
        println("I director number ${id} drink coffee")
    }

    override fun buyThings() {
        println("My position Director. I am buy things")
    }

    fun takeCoffee(assistant: Assistant){
        val drinkName: String = assistant.bringCoffee().toString()
        println("Thank you, ${assistant.name}! The $drinkName is very tasty!")
    }
}
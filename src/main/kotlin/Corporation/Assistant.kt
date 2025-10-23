package Corporation

import kotlin.random.Random
import kotlin.random.nextInt

data class Assistant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int = 50_000):Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = WorkerType.ASSISTANT
), Cleaner, Provider {

    override fun copy(id: Int, name: String, age: Int, salary: Int, position: WorkerType): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    override fun work(){
        println("I assistant number $id go to the coffee for director")
    }

    override fun clean() {
        println("My position Assistant. I am cleaning workspace")
    }

    override fun buyThings() {
        println("My position Assistant. I am buy things")
    }

    fun bringCoffee(): String {
        val drinkName = when(Random.nextInt(0 until 3)){
            0 -> "Americano"

            1 -> "Cappuchino"

            2 -> "Espresso"

            else -> "Americano"
        }
        return drinkName
    }
}
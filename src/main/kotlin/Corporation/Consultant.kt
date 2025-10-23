package Corporation

import kotlin.random.Random

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int = 40_000): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = WorkerType.CONSULTANT
), Cleaner {

    override fun copy(id: Int, name: String, age: Int, salary: Int, position: WorkerType): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    override fun work() {
        repeat(Random.nextInt(0, 10)) {
            print("I consultant number $id customer is server ")
        }
    }

    override fun clean() {
        println("My position Consultant. I am cleaning workspace")
    }
}
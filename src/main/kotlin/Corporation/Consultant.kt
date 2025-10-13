package Corporation

import kotlin.random.Random

class Consultant(id: Int,name: String, age: Int, salary: Int = 40_000): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = WorkerType.CONSULTANT
), Cleaner {
    override fun work() {
        repeat(Random.nextInt(0, 10)) {
            println("I consultant number $id service client")
        }
    }

    override fun clean() {
        println("My position Consultant. I am cleaning workspace")
    }
}
package Corporation

import kotlin.random.Random

class Consultant(id: Int,name: String, age: Int): Worker(id,name,age,WorkerType.CONSULTANT) {
    override fun work() {
        repeat(Random.nextInt(0, 10)) {
            println("I consultant number $id service client")
        }
    }

    override fun printInfo(){
        print("Consultant - Id: $id, Name: $name, Age: $age")
    }
}
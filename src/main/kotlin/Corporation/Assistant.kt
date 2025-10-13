package Corporation

class Assistant(id: Int,name: String,age: Int, salary: Int = 50_000):Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = WorkerType.ASSISTANT
), Cleaner, Provider {
    override fun work(){
        println("I assistant number $id go to the coffee for director")
    }

    override fun clean() {
        println("My position Assistant. I am cleaning workspace")
    }

    override fun buyThings() {
        println("My position Assistant. I am buy things")
    }
}
package Corporation

class Director(id: Int,name: String,age: Int,salary: Int = 100_000):Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = WorkerType.DIRECTOR
), Provider {

    override fun copy(salary: Int,age: Int): Director {
        return Director(this.id,this.name,age,salary)
    }

    override fun work(){
        println("I director number ${id} drink coffee")
    }

    override fun buyThings() {
        println("My position Director. I am buy things")
    }
}
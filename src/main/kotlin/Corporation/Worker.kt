package Corporation
abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int = 0,
    open val salary: Int = 15_000,
    val position: WorkerType)
{

//    override fun equals(other: Any?): Boolean {
//        if (other !is Worker) return false
//
//        return (this.id == other.id && this.age == other.age && this.name == other.name && this.salary == other.salary)
//    }
//
      abstract fun copy(id: Int = this.id, name: String = this.name, age: Int = this.age, salary: Int = this.salary, position: WorkerType = this.position): Worker
////
      abstract fun work()
//
//     override fun toString(): String {
//        return "Post: ${position.title} - Id: $id, Name: $name, Age: $age, Salary $salary"
//    }

    open fun printInfo(){
        println(this)
    }
}


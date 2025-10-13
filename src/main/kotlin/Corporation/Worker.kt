package Corporation

abstract class Worker(val id: Int,
                  val name: String,
                  val age: Int = 0,
                  private var salary: Int = 15_000,
                  val position: WorkerType)
{
    fun getSalary() = this.salary
    fun setSalary(salary: Int){
        if (this.salary > salary){
            println("New salary not down old salary")
        } else {
            this.salary = salary
        }
    }

    abstract fun work()

    override fun toString(): String {
        return "Post: ${position.title} - Id: $id, Name: $name, Age: $age, Salary $salary"
    }

    open fun printInfo(){
        println(this)
    }
}
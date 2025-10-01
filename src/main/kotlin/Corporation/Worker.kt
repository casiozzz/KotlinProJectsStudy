package Corporation

abstract class Worker(val id: Int,
                  val name: String,
                  val age: Int = 0,
                  val position: WorkerType)
{
    abstract fun work()
    open fun printInfo(){
        println("Id: $id, Name: $name, Age: $age, Post: ${position.title}")
    }
}
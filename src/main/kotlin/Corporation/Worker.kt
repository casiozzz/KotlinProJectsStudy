package Corporation

abstract class Worker(val id: Int,
                  val name: String,
                  val age: Int = 0,
                  val salary: Int = 15_000,
                  val position: WorkerType)
{

    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

   fun print(){
       println("Время ожидания: <timeout> секунд\n" +
               "Максимальное количество повторных попыток: <maxRetries>\n" +
               "Уровень логирования: <loggingLevel>\n" +
               "Режим отладки: <isDebugMode>\n" +
               "Режим продакшн: <isProductionMode>")
   }

    abstract fun work()

     override fun toString(): String {
        return "Post: ${position.title} - Id: $id, Name: $name, Age: $age, Salary $salary"
    }

    open fun printInfo(){
        println(this)
    }
}
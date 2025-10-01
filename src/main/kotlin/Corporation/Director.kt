package Corporation

class Director(id: Int,name: String,age: Int):Worker(id,name,age, WorkerType.DIRECTOR) {
    override fun work(){
        println("I director number ${id} drink coffee")
    }
    override fun printInfo(){
        println("Director - Id: $id, Name: $name, Age: $age")
    }
}
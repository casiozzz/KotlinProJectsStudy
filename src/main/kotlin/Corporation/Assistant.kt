package Corporation

class Assistant(id: Int,name: String,age: Int):Worker(id,name,age,WorkerType.ASSISTANT) {
    override fun work(){
        println("I assistant number $id go to the coffee for director")
    }
    override fun printInfo(){
        print("Assistant - Id: $id, Name: $name, Age: $age")
    }
}
package Corporation

import java.io.File

object WorkersRepository {
    private val fileEmployee = File("Employees.txt")
    private val _workers = loadAllEmployees()
    val workers
        get() = _workers.toList()

    fun RegisterNewEmployee(newWorker: Worker){
        _workers.add(newWorker)
    }

     private fun loadAllEmployees(): MutableSet<Worker>{
        val employees = mutableSetOf<Worker>()
        if (!fileEmployee.exists()){
            fileEmployee.createNewFile()
        }
        val content = fileEmployee.readText().trim()

        if(content.isEmpty()){
            return employees
        }
        val employeesAsString = content.split("\n")
        for (employeeAsString in employeesAsString){
            val employeeString = employeeAsString.split("%")
            val workerType = WorkerType.valueOf(employeeString.last())
            val id = employeeString[0].toInt()
            val name = employeeString[1]
            val age = employeeString[2].toInt()
            val salary = employeeString[3].toInt()
            val worker = when(workerType){
                WorkerType.DIRECTOR -> {Director(id,name,age,salary)}
                WorkerType.ACCOUNTANT -> {Accountant(id,name,age,salary)}
                WorkerType.ASSISTANT -> {Assistant(id,name,age,salary)}
                WorkerType.CONSULTANT -> {Consultant(id,name,age,salary)}
            }
            employees.add(worker)
        }

        return employees
    }

     fun FireAnEmployee(id: Int){
        for (worker in _workers){
            if (worker.id == id){  _workers.remove(worker)
                break
            }
        }
    }

     fun changeSalary(id: Int,salary: Int){
        for (worker in _workers){
            if (worker.id == id){
                val newWorker = worker.copy(salary = salary)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun saveChangesToFile(){
        val content = StringBuilder()
        for (worker in _workers){
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.position}\n")
        }
        fileEmployee.writeText(content.toString())
    }

    fun changeAge(id: Int,age: Int){
        for (worker in _workers){
            if (worker.id == id){
                val newWorker = worker.copy(age = age)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun findAssistant(): Assistant? {
        for (worker in _workers){
            if (worker is Assistant){
                return worker
            }
        }
        return null
    }

    fun findDirector(): Director? {
        for (worker in _workers){
            if (worker is Director){
                return worker
            }
        }
        return null
    }

}
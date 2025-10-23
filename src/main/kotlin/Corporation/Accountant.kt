package Corporation

import java.io.File
import javax.swing.text.Position

data class Accountant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int = 60000): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = WorkerType.ACCOUNTANT
), Cleaner, Provider {

    private val workersRepository = WorkersRepository
    private val cardsRepository = CardsRepository

    override fun copy(id: Int, name: String, age: Int, salary: Int, position: WorkerType): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    private fun changeSalary(){
        print("Enter id worker to change salary: ")
        val id = readln().toInt()
        print("Enter a new salary: ")
        val salary = readln().toInt()
        workersRepository.changeSalary(id,salary)
    }

    override fun clean() {
        println("My position is Accountant. I am cleaning workspace")
    }

    override fun buyThings() {
        println("My position Accountant. I am but things")
    }


    private fun removeProductCard(){
        print("Enter name card for removing: ")
        val name = readln()
        cardsRepository.removeProductCard(name)
    }

    private fun showAllItems(){
        val items = cardsRepository.cards
        for (item in items){
            item.printInfo()
        }
    }

    private fun RegisterNewItem() {
            val productTypes = ProductType.entries
            print("Enter the product type.")
            for((index,type) in productTypes.withIndex()){
                print("$index - ${type.title}")
                if (index < productTypes.size-1){
                    print(", ")
                } else {
                    print(":")
                }
            }
        val productTypeIndex = readln().toInt()
        print("Enter the product name: ")
        val name = readln()
        print("Enter the product brand: ")
        val brand = readln()
        print("Enter the product price: ")
        val price = readln().toInt()
            val productType = productTypes[productTypeIndex]
            val card = when (productType) {
                ProductType.FOOD -> {
                    print("Enter caloric: ")
                    val caloric = readln().toInt()
                    foodCard(name,brand,price, caloric)
                }
                ProductType.APPLIANCE -> {
                    print("Enter lifetime: ")
                    val lifetime = readln().toInt()
                    applianceCard(name,brand,price,lifetime)
                }
                ProductType.SHOE -> {
                    print("Enter size: ")
                    val size = readln().toFloat()
                    shoeCard(name,brand,price,size)
                }
            }
        cardsRepository.saveProductCard(card)
        }

    private fun RegisterNewEmployee(){
        val workerTypes = WorkerType.entries
        print("Choose position - ")
        for ((index, type) in workerTypes.withIndex()){
            print("${index} - ${type.title}")
            if (index < workerTypes.size-1){
                print(", ")
            } else {
                print(": ")
            }
        }
        val workerTypeIndex = readln().toInt()
        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        print("Enter salary: ")
        val salary = readln().toInt()
        val workerType = workerTypes[workerTypeIndex]
        val employee = when(workerType){
            WorkerType.DIRECTOR -> {
                Director(id,name,age,salary)
            }
            WorkerType.ACCOUNTANT -> {
                Accountant(id,name,age,salary)
            }
            WorkerType.ASSISTANT -> {
                Assistant(id,name,age,salary)
            }
            WorkerType.CONSULTANT -> {
                Consultant(id,name,age,salary)
            }
        }
        workersRepository.RegisterNewEmployee(employee)
    }

    private fun ShowAllEmployees(){
        val employees = workersRepository.workers
        for (employee in employees){
            employee.printInfo()
        }
    }

    private fun FireAnEmployee(){
        print("Enter id worker to fire: ")
        val id = readln().toInt()
        workersRepository.FireAnEmployee(id)
    }

    private fun changeAge(){
        print("Enter id worker to change age: ")
        val id = readln().toInt()
        print("Enter a new age: ")
        val age = readln().toInt()
        workersRepository.changeAge(id,age)
    }

    override fun work(){
        while (true){
            val operationCodes = OperationCode.entries
            println("Enter the operation code. ")
            for ((index, type) in operationCodes.withIndex()){
                print("$index - ${type.title}")
                if (index < operationCodes.size-1){
                    print("\n")
                } else{
                    print("\nYour chose -> ")
                }
            }
            val breakContinueIndex = readln().toInt()
            val breakContinue = operationCodes[breakContinueIndex]
            when(breakContinue){
                OperationCode.EXIT -> {
                    workersRepository.saveChangesToFile()
                    cardsRepository.saveChangesToFile()
                    break
                }
                OperationCode.REGISTER_NEW_ITEM -> RegisterNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD ->removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> RegisterNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> FireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEE -> ShowAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
                OperationCode.CHANGE_AGE -> changeAge()
            }
        }
    }
}
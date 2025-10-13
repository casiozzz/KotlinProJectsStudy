package Corporation

import java.io.File

class Accountant(id: Int, name: String, age: Int, salary: Int = 60000): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = WorkerType.ACCOUNTANT
), Cleaner, Provider {

    private val fileCards = File("ProductCard.txt")
    private val fileEmployee = File("Employees.txt")
    fun saveWorkerToFile(worker: Worker){
        fileEmployee.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%")
        when(worker){
            is Director -> {
                fileEmployee.appendText("${WorkerType.DIRECTOR}\n")
            }
            is Assistant -> {
                fileEmployee.appendText("${WorkerType.ASSISTANT}\n")
            }
            is Accountant -> {
                fileEmployee.appendText("${WorkerType.ACCOUNTANT}\n")
            }
            is Consultant -> {
                fileEmployee.appendText("${WorkerType.CONSULTANT}\n")
            }
        }
    }

    private fun changeSalary(){
        val employees: MutableList<Worker> = ShowAllEmployees()
        print("Enter id worker to change salary: ")
        val id = readln().toInt()
        print("Enter a new salary: ")
        val salary = readln().toInt()
        for ((index, employ) in employees.withIndex()){
            if (employ.id == id){
                employ.setSalary(salary)
                break
            }
        }
        fileEmployee.writeText("")
        for (employee in employees){
            saveWorkerToFile(employee)
        }
    }

    override fun clean() {
        println("My position is Accountant. I am cleaning workspace")
    }

    override fun buyThings() {
        println("My position Accountant. I am but things")
    }

    private fun saveProductCard(productCard: ProductCard){
        fileCards.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is foodCard -> {
                val date = productCard.ExpirationDate
                fileCards.appendText("$date%${ProductType.FOOD}\n")
            }

            is shoeCard -> {
                val size = productCard.size
                fileCards.appendText("$size%${ProductType.SHOE}\n")
            }

            is applianceCard -> {
                val lifetime = productCard.lifetime
                fileCards.appendText("$lifetime%${ProductType.APPLIANCE}\n")
            }
        }
    }

    private fun removeProductCard(){
        val cards: MutableList<ProductCard> = showAllItems()
        print("Enter name card for removing: ")
        val name = readln()
        for((index, card) in cards.withIndex()){
            if (card.name == name){
                cards.removeAt(index)
                break
            }
        }
        fileCards.writeText("")
        for (card in cards){
            saveProductCard(card)
        }
    }

    private fun showAllItems(): MutableList<ProductCard> {
        val items = mutableListOf<ProductCard>()
        val content = fileCards.readText().trim()
        if (content.isEmpty()){
            return items
        }
        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString){
            val properties = cardAsString.split("%")
            val productType = ProductType.valueOf(properties.last())
            when(productType){
                ProductType.FOOD -> {items.add(foodCard(properties[0],properties[1],properties[2].toInt(),properties[3]))}
                ProductType.APPLIANCE -> {items.add(applianceCard(properties[0],properties[1],properties[2].toInt(),properties[3].toInt()))}
                ProductType.SHOE -> {items.add(shoeCard(properties[0],properties[1],properties[2].toInt(),properties[3].toFloat()))}
            }
        }
        for (item in items){
            item.printInfo();println()
        }
        return items
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
                    print("Enter expiration date: ")
                    val date = readln()
                    foodCard(name,brand,price,date)
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
        saveProductCard(card)
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
        employee.setSalary(salary)
        saveWorkerToFile(employee)
    }

    fun ShowAllEmployees(): MutableList<Worker>{
        val employees = mutableListOf<Worker>()
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
            worker.setSalary(salary)
            employees.add(worker)
        }

        for (employee in employees){
            employee.printInfo()
        }
        return employees
    }

    private fun FireAnEmployee(){
        val employees: MutableList<Worker> = ShowAllEmployees()
        print("Enter id worker to fire: ")
        val id = readln().toInt()
        for ((index, employ) in employees.withIndex()){
            if (employ.id == id){
                employees.removeAt(index)
                break
            }
        }
        fileEmployee.writeText("")
        for (employee in employees){
            saveWorkerToFile(employee)
        }
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
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> RegisterNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD ->removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> RegisterNewEmployee()
                OperationCode.FIRE_AN_EMPLOYEE -> FireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEE -> ShowAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }
}
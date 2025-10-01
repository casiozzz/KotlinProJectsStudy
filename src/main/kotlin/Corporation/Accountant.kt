package Corporation

import java.io.File

class Accountant(id: Int, name: String, age: Int): Worker(id,name,age, WorkerType.ACCOUNTANT) {

    private val fileCards = File("ProductCard.txt")
    private val fileEmployee = File("Employees.txt")
    fun saveWorkerToFile(worker: Worker){
        fileEmployee.appendText("${worker.id}%${worker.name}%${worker.age}%")
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
    override fun printInfo(){
        println("Accountant - Id: $id, Name: $name, Age: $age")
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
        print("Enter the product name: ")
        val name = readln()
        print("Enter the product brand: ")
        val brand = readln()
        print("Enter the product price: ")
        val price = readln().toInt()
            val productTypeIndex = readln().toInt()
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
        val workerType = workerTypes[workerTypeIndex]
        val employee = when(workerType){
            WorkerType.DIRECTOR -> {
                Director(id,name,age)
            }
            WorkerType.ACCOUNTANT -> {
                Accountant(id,name,age)
            }
            WorkerType.ASSISTANT -> {
                Assistant(id,name,age)
            }
            WorkerType.CONSULTANT -> {
                Consultant(id,name,age)
            }
        }
        saveWorkerToFile(employee)
    }

    private fun ShowAllEmployees(): MutableList<Worker>{
        val employees = mutableListOf<Worker>()
        val content = fileEmployee.readText().trim()
        if (!fileEmployee.exists()){
            fileEmployee.createNewFile()
        }
        if(content.isEmpty()){
            return employees
        }
        val employeesAsString = content.split("\n")
        for (employeeAsString in employeesAsString){
            val employeeString = employeeAsString.split("%")
            val workerType = WorkerType.valueOf(employeeString.last())
            when(workerType){
                WorkerType.DIRECTOR -> {employees.add(Director(employeeString[0].toInt(),employeeString[1],employeeString[2].toInt()))}
                WorkerType.ACCOUNTANT -> {employees.add(Accountant(employeeString[0].toInt(),employeeString[1],employeeString[2].toInt()))}
                WorkerType.ASSISTANT -> {employees.add(Assistant(employeeString[0].toInt(),employeeString[1],employeeString[2].toInt()))}
                WorkerType.CONSULTANT -> {employees.add(Consultant(employeeString[0].toInt(),employeeString[1],employeeString[2].toInt()))}
            }
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
            }
        }
    }
}
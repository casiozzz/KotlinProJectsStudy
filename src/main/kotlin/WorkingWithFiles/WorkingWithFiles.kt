package WorkingWithFiles

import java.io.File
//
//fun main() {
//
//    val file = File("test.txt")
//    while (true)
//    when(opeartion()){
//        OperationCode.STOPROGRAM -> {
//            break
//        }
//        OperationCode.NEWITEM -> {
//            file.appendText(readln()+"\n")
//        }
//        OperationCode.SHOWALL -> {
//            val showAll = file.readText().split("\n")
//            for ((index, show) in showAll.withIndex()){
//                if (index < showAll.size-1) {
//                    println("${index + 1} - $show")
//                }
//            }
//        }
//    }
//
//
//}
//
//fun opeartion(): OperationCode{
//    val operationCode = OperationCode.entries
//    print("Выбирите код операции: ")
//    for ((index, operation) in operationCode.withIndex()){
//        print("${index} - ${operation.title}")
//        if (index < operationCode.size-1){
//            print(", ")
//        } else {
//            print(": ")
//        }
//    }
//    val operationIndex = readln().toInt()
//    val operation = operationCode[operationIndex]
//    return operation
//}

fun main() {
    val order = mutableListOf<String>()
    val listUser = listOf("user0", "user1", "user2", "user3")
    fun task(listUser: List<String>): List<String>{
        val users = mutableListOf<String>()
        for (user in listUser){
            users.add(user)
        }
        when(readln().toString()){
            "SHOW" -> {
                for (user in users){
                    println(user)
                }
            }
            "ADD" -> {
                users.add(readln().toString())
                for (user in users){
                    println(user)
                }
            }
            "REMOVE" -> {
                val deleteElement = readln()
                var iterator = 0
                while (iterator < users.size){
                    if (deleteElement == users[iterator]){
                        users.remove(deleteElement)
                    }else{
                        println(users[iterator])
                        iterator++
                    }
                }
            }
            "REMOVE_AT" -> {
                val deleteElementForIndex = readln().toInt()
                if (deleteElementForIndex-1 > users.size){
                    for (user in users){
                        println(user)
                    }
                } else {
                    users.removeAt(deleteElementForIndex)
                    for (user in users){
                        println(user)
                    }
                }
            }
            else -> {
                print("Некорректное значение")
            }
        }
        return users
    }
    task(listUser)
}
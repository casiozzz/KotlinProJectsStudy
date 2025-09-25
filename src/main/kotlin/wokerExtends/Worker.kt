package wokerExtends

open class Worker(val name: String, val years: Int = 0) {
    open fun work(name: String){
        println("${name} Работает")
    }
}
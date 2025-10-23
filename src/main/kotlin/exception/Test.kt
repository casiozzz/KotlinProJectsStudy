package exception

fun main() {
    val number: Int = 0
    processNumber(number)

}

fun processNumber(number: Int) {
    try{
        println("Число: ${NumberValidator.validate(number)}")
    } catch (e: IllegalArgumentException){
        println(e.message)
    }
}


object NumberValidator {

    /**
     * Завершает выполнение программы или выбрасывает исключение с заданным сообщением.
     * Возвращает тип Nothing.
     */
    fun terminate(message: String): Nothing = throw IllegalArgumentException(message)

    /**
     * Проверяет число на корректность.
     * Если число некорректно, вызывает terminate.
     * @return то же число, если данные корректны.
     */
    fun validate(number: Int): Int {
        if(number < 0){
            terminate("Ошибка: Число отрицательное.")
        } else if (number == 0){
            terminate("Ошибка: Число равно нулю.")
        } else {
            return number
        }
    }
}
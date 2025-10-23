package test

interface Repository {
    /**
     * Возвращает список пользователей, некоторые элементы или их поля могут быть null.
     */
    fun getUsers(): List<UserData?>
}
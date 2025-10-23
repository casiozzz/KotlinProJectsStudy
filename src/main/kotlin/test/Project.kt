package test

class UserViewModel(private val repository: Repository) {


    /**
     * Реализуйте метод getUserDescriptions, который:
     * 1. Получает данные из репозитория.
     * 2. Удаляет null элементы списка.
     * 3. Заменяет null значения в полях name, email и age на дефолтные.
     * 4. Формирует строки в формате: "Name: [name], Email: [email], Age: [age]".
     *
     * @return Список строк с описаниями пользователей.
     */
    fun getUserDescriptions(): List<String> {
        val userLists = repository.getUsers()
        val emptyList = mutableListOf<String>()
        for (list in userLists){
            if (list == null){
                continue
            }

            val str = StringBuilder()

            if(list.name == null){
                str.append("Name: Unknown Name, ")
            } else {
                str.append("Name: ${list.name}, ")
            }

            if(list.email == null){
                str.append("Email: Unknown Email, ")
            } else {
                str.append("Email: ${list.email}, ")
            }

            if(list.age == null){
                str.append("Age: 0\n")
            } else {
                str.append("Age: ${list.age}")
            }
            emptyList.add(str.toString())


        }

        // Реализуйте логику здесь
        return emptyList
    }
}
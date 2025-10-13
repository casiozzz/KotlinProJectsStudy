package Corporation

enum class OperationCode(val title: String) {
    EXIT("Exit program"),
    REGISTER_NEW_ITEM(title = "Register new item"),
    SHOW_ALL_ITEMS(title = "Show all items"),
    REMOVE_PRODUCT_CARD(title = "Remove product card"),
    REGISTER_NEW_EMPLOYEE("Register new employee"),
    FIRE_AN_EMPLOYEE("Fire an employee"),
    SHOW_ALL_EMPLOYEE("Show all employee"),
    CHANGE_SALARY("Change salary")
}
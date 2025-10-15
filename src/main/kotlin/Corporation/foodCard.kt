package Corporation

class foodCard(name: String,brand: String,price: Int, val caloric: Int): ProductCard(name = name, brand = brand, price = price, ProductType.FOOD) {


    override fun toString(): String {
        return super.toString() + " Caloric: $caloric"
    }
}

package Corporation

class applianceCard(name: String,brand: String,price: Int, val lifetime: Int): ProductCard(name = name, brand = brand, price = price, ProductType.APPLIANCE) {

    override fun toString(): String {
        return super.toString() + " Lifetime: $lifetime"
    }
}
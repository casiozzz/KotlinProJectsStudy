package Corporation

class shoeCard(name: String,brand: String,price: Int, val size: Float): ProductCard(name = name, brand = brand, price = price, ProductType.SHOE) {

    override fun toString(): String {
        return super.toString() + " Size: $size"
    }
}
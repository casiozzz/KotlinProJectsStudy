package Corporation

class foodCard(name: String,brand: String,price: Int, val ExpirationDate: String): ProductCard(name = name, brand = brand, price = price, ProductType.FOOD) {
    override fun printInfo(){
        println("Name: $name Brand $brand Price $price Expiration date: $ExpirationDate Product type: ${productType.title}")
    }
}

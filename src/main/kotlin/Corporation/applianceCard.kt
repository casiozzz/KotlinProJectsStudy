package Corporation

class applianceCard(name: String,brand: String,price: Int, val lifetime: Int): ProductCard(name = name, brand = brand, price = price, ProductType.APPLIANCE) {
    override fun printInfo(){
        println("Name: $name Brand $brand Price $price Lifetime: ${lifetime} Product type: ${productType.title}")
    }
}
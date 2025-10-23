package Corporation

data class applianceCard(
    override val name: String,
    override val brand: String,
    override val price: Int,
    val lifetime: Int): ProductCard(
    name = name,
    brand = brand, 
    price = price,
    ProductType.APPLIANCE) {

}
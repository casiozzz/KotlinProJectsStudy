package Corporation

abstract class ProductCard (val name: String, val brand: String, val price: Int, val productType: ProductType){
    fun printInfo(){
        println(this)
    }

    override fun toString(): String {
        return "Name: $name Brand: $brand Price: $price Product type: ${productType.title}"
    }
}
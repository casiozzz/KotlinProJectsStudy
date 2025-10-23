package Corporation

import java.io.File

object CardsRepository {
    private val fileCards = File("ProductCard.txt")
    private val _cards = loadAllItems()
    val cards
        get() = _cards.toList()

    private fun loadAllItems(): MutableSet<ProductCard> {
        val items = mutableSetOf<ProductCard>()
        val content = fileCards.readText().trim()
        if (content.isEmpty()){
            return items
        }
        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString){
            val properties = cardAsString.split("%")
            val productType = ProductType.valueOf(properties.last())
            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()
            val card = when(productType){
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    foodCard(name,brand,price,caloric)}
                ProductType.APPLIANCE -> {
                    val lifetime = properties[3].toInt()
                    applianceCard(name,brand,price,lifetime)}
                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    shoeCard(name,brand,price,size)}
            }
            items.add(card)
        }
        return items
    }

    fun removeProductCard(name: String){
        for(card in _cards){
            if (card.name == name){
                _cards.remove(card)
                break
            }
        }
    }

    fun saveChangesToFile(){
        //"${productCard.name}%${productCard.brand}%${productCard.price}%"
        val content = StringBuilder()
        for (card in _cards){
            when (card) {
                is foodCard -> {
                    val date = card.caloric
                    content.append("${card.name}%${card.brand}%${card.price}%${card.caloric}%${card.productType}")
                }

                is shoeCard -> {
                    val size = card.size
                    content.append("${card.name}%${card.brand}%${card.price}%${card.size}%${card.productType}")
                }

                is applianceCard -> {
                    val lifetime = card.lifetime
                    content.append("${card.name}%${card.brand}%${card.price}%${card.lifetime}%${card.productType}")

                }
            }
        }
        fileCards.writeText(content.toString())
    }

    fun saveProductCard(card: ProductCard){
        _cards.add(card)
    }
}
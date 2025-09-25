package Delivery

fun main(){
    val deliveryObject: DeliveryObject = DeliveryObject(90,80,45,14.0)
    val delivery = Warehouse().packCargo(deliveryObject)
    delivery.printInfo()
}
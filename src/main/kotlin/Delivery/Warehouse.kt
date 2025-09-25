package Delivery

class Warehouse {
    fun getPack(deliveryObject: DeliveryObject): Pack{
        val pack: Pack = Pack(deliveryObject.length+1,deliveryObject.width+1,deliveryObject.height+1, weight = 0.3)
        return pack
    }

    fun packCargo(deliveryObject: DeliveryObject): Cargo{
        val cargo: Cargo = Cargo(length = Warehouse().getPack(deliveryObject).length, width = Warehouse().getPack(deliveryObject).width, height = Warehouse().getPack(deliveryObject).height, typePackaging = Warehouse().getPack(deliveryObject).type, netWeight = Warehouse().getPack(deliveryObject).weight, grossWeight = Warehouse().getPack(deliveryObject).weight+deliveryObject.weight)
        return cargo
    }
}
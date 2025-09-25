import kotlin.math.pow

//package org.example
//
//fun message(Transport : Boolean,HorsePower : Int, TaxRate : Int){
//    if (Transport) {
//        println(
//            "Вид ТС: грузовой автомобиль\n" +
//                    "Мощность двигателя: $HorsePower л.с.\n" +
//                    "Налоговая ставка: $TaxRate руб./л.с.\n" +
//                    "Сумма налога: ${HorsePower * TaxRate} руб."
//        )
//    } else {
//        println(
//            "Вид ТС: легковой автомобиль\n" +
//                    "Мощность двигателя: $HorsePower л.с.\n" +
//                    "Налоговая ставка: $TaxRate руб./л.с.\n" +
//                    "Сумма налога: ${HorsePower * TaxRate} руб."
//        )
//    }
//}
//
//fun main() {
//    val Transport = readln().toBoolean()
//    val HorsePower = readln().toInt()
//    var TaxRate : Int = 0
//    if (HorsePower <= 100){
//        if (Transport){
//            TaxRate = 25
//            message(Transport,HorsePower,TaxRate)
//        } else{
//            TaxRate = 10
//            message(Transport,HorsePower,TaxRate)
//        }
//    }
//    else if (HorsePower in 101..150){
//        if (Transport){
//            TaxRate = 40
//            message(Transport,HorsePower,TaxRate)
//        } else{
//            TaxRate = 34
//            message(Transport,HorsePower,TaxRate)
//        }
//    }
//    else if (HorsePower in 151..200) {
//        if (Transport){
//            TaxRate = 50
//            message(Transport,HorsePower,TaxRate)
//        } else{
//            TaxRate = 49
//            message(Transport,HorsePower,TaxRate)
//        }
//    }
//    else if (HorsePower in 201..250) {
//        if (Transport){
//            TaxRate = 65
//            message(Transport,HorsePower,TaxRate)
//        } else{
//            TaxRate = 75
//            message(Transport,HorsePower,TaxRate)
//        }
//    }
//    else{
//        if (Transport){
//            TaxRate = 85
//            message(Transport,HorsePower,TaxRate)
//        } else{
//            TaxRate = 150
//            message(Transport,HorsePower,TaxRate)
//        }
//    }
//}




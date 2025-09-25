package catExtends

fun main() {
val cat = Cat("Sam")
    println(cat.catName + " " + cat.legs)
    val lion = Lion(25)
    println(""+ lion.legs + " " + lion.countLionInPride)
    cat.playWithMouse()
}
package org.yqj.source.init.examples.flow

fun eatACake() = println("Eat a Cake")
fun bakeACake() = println("Bake a Cake")

class Animal(val name: String)

class Zoo(val animals: List<Animal>) {
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}

fun main() {
    // 1. for in
//    val collection = listOf(1, 2, 3, 4, 5)
//    for (item in collection) {
//        println(item)
//    }

    // 2. while do
//    var cakesEaten = 0
//    while (cakesEaten < 2) {
//        eatACake()
//        cakesEaten++
//    }
//
//    var cakesBaked = 0
//    do {
//        bakeACake()
//        cakesBaked++
//    } while (cakesBaked < cakesEaten)

    // 3 operator for...in
//    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
//
//    for (animal in zoo) {                                   // 3
//        println("Watch out, it's a ${animal.name}")
//    }

}
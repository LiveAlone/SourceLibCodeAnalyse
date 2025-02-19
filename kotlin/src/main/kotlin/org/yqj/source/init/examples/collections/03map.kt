package org.yqj.source.init.examples.collections

import kotlin.math.abs

const val POINTS_X_PASS: Int = 15
val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)   // 1
val EZPassReport: Map<Int, Int> = EZPassAccounts                                        // 2

fun updatePointsCredit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {                                        // 3
        println("Updating $accountId...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS  // 4
    } else {
        println("Error: Trying to update a non-existing account (id: $accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass report:")
    EZPassReport.forEach {                                                              // 5
            k, v -> println("ID $k: credit $v")
    }
}

fun main() {

    // 1 map
//    accountsReport()                                                                    // 6
//    updatePointsCredit(1)                                                               // 7
//    updatePointsCredit(1)
//    updatePointsCredit(5)                                                               // 8
//    accountsReport()

    // 2 associateBy, groupBy
//    data class Person(val name: String, val city: String, val phone: String) // 1
//
//    val people = listOf(                                                     // 2
//        Person("John", "Boston", "+1-888-123456"),
//        Person("Sarah", "Munich", "+49-777-789123"),
//        Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
//        Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))
//    // 生成map 重复覆盖
//    println(people.associateBy { it.phone })
//    println(people.associateBy(Person::phone, Person::city))
//    println(people.associateBy { it.city })
//
//    println(people.groupBy(Person::city, Person::name))
//    println(people.associateBy(Person::city, Person::name))

    // 3 partition
//    val numbers = listOf(1, -2, 3, -4, 5, -6)
//    println(numbers.partition { it % 2 == 0 } )
//    println(numbers.partition { it > 0 })
//    println(numbers.partition { it > 100 })

    // 4 flatMap
//    val fruitsBag = listOf("apple","orange","banana","grapes")  // 1
//    val clothesBag = listOf("shirts","pants","jeans")           // 2
//    val cart = listOf(fruitsBag, clothesBag)
//    println(cart.map { it })
//    println(cart.flatMap { it })

    // 4 min max
//    val numbers = listOf(1, 2, 3)
//    val empty = emptyList<Int>()
//    val only = listOf(3)
//
//    println("Numbers: $numbers, min = ${numbers.minOrNull()} max = ${numbers.maxOrNull()}") // 1
//    println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}")        // 2
//    println("Only: $only, min = ${only.minOrNull()}, max = ${only.maxOrNull()}")


    // 5 sort sort by
//    val shuffled = listOf(5, 4, 2, 1, 3, -10)
//    println(shuffled.sorted())
//    println(shuffled.sortedBy { -it })
//    println(shuffled.sortedDescending())
//    println(shuffled.sortedByDescending { abs(it) })

    // 6 map element access
//    val map = mapOf("key" to 42)
//    println(map["key"])
//    println(map["key2"])
//    println(map.getValue("key"))
//    try {
//        map.getValue("anotherKey")                              // 4
//    } catch (e: NoSuchElementException) {
//        println("Message: $e")
//    }
//
//    val mapWithDefault = map.withDefault { k -> k.length }
//    println(mapWithDefault.getValue("key2") )

    // 7 get or else
    val map = mutableMapOf<String, Int?>()
    println(map.getOrElse("x") { 1 })
    map["x"] = 3
    println(map.getOrElse("x") { 1 })
    map["x"] = null
    println(map.getOrElse("x") { 1 })
}

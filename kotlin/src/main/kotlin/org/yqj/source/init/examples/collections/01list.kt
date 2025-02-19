package org.yqj.source.init.examples.collections

val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)        // 1
val sudoers: List<Int> = systemUsers                              // 2

fun addSystemUser(newUser: Int) {                                 // 3
    systemUsers.add(newUser)
}

fun getSysSudoers(): List<Int> {                                  // 4
    return sudoers
}

fun main() {

    // 1 list
//    addSystemUser(4)                                              // 5
//    println("Tot sudoers: ${getSysSudoers().size}")               // 6
//    getSysSudoers().forEach {                                     // 7
//            i -> println("Some useful info on user $i")
//    }
////     getSysSudoers().add(5) <- Error!                           // 8

    // 2. filter
//    val numbers = listOf(1, -2, 3, -4, 5, -6)      // 1
//    println(numbers)
//    val positives = numbers.filter { x -> x > 0 }  // 2
//    println(positives)
//    val negatives = numbers.filter { it < 0 }      // 3
//    println(negatives)

    // 3 any all none
//    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1
//    val anyNegative = numbers.any { it < 0 }             // 2
//    val anyGT6 = numbers.any { it > 6 }                  // 3
//    println(anyNegative)
//    println(anyGT6)
//
//    val allEven = numbers.all { it % 2 == 0 }            // 2
//    val allLess6 = numbers.all { it < 6 }                // 3
//    println(allEven)
//    println(allLess6)

//    val allEven = numbers.none { it % 2 == 1 }           // 2
//    val allLess6 = numbers.none { it > 6 }               // 3
//    println(allEven)
//    println(allLess6)

    // 4 find find last
//    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")  // 1
//    val first = words.find { it.startsWith("some") }
//    println(first)
//    val last = words.findLast { it.startsWith("some") }
//    println(last)
//    val nothing = words.find { it.contains("nothing") }
//    println(nothing)

    // 5 first last
//    val numbers = listOf(1, -2, 3, -4, 5, -6)
//    println(numbers.first())
//    println(numbers.last())
//    println(numbers.first { it % 2 == 0 })
//    // println(numbers.first { it % 7 == 0 }) // throw exception
//    println(numbers.last { it < 0 })

    // 6 firstOrNull lastOrNull
//    val words = listOf("foo", "bar", "baz", "faz")         // 1
//    val empty = emptyList<String>()
//    println(empty.firstOrNull())
//    println(empty.lastOrNull())
//    println(words.firstOrNull { it.contains("a") })
//    println(words.lastOrNull { it.length < 4 })
//    println(words.firstOrNull { it.contains("x") })
//    println(words.lastOrNull { it.length > 4 })

    // 7 count
//    val numbers = listOf(1, -2, 3, -4, 5, -6)
//    println(numbers.count())
//    println(numbers.count { it % 2 == 0 })

    // 8 zip
//    val A = listOf("a", "b", "c", "e", "f")                  // 1
//    val B = listOf(1, 2, 3, 4)
//    println(A zip B)
//    println(A.zip(B) {a, b -> "$a$b"})

    // 9 getOrElse get index or default
    // 防止数组超出范围
    val list = listOf(0, 10, 20)
    println(list.getOrElse(1) { 42 })
    println(list.getOrElse(10) { 42 })
}


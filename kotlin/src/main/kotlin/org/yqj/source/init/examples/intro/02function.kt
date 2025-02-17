package org.yqj.source.init.examples.intro

fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y


class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}

fun main() {

    // 1. print
//    printMessage("Hello")
//    printMessageWithPrefix("Hello", "Log")
//    printMessageWithPrefix("Hello")
//    println(sum(1, 2))
//    println(multiply(2, 4))


    // 2. infix append
//    infix fun Int.times(str: String) = str.repeat(this)        // 1
//    println(2 times "Bye ")
//
//    val pair = "Ferrari" to "Katrina"                          // 3
//    println(pair)
//
//    infix fun String.onto(other: String) = Pair(this, other)   // 4
//    val myPair = "McLaren" onto "Lucas"
//    println(myPair)
//
//    val sophia = Person("Sophia")
//    val claudia = Person("Claudia")
//    sophia likes claudia
//    sophia.likedPeople.forEach { println(it.name) }


    // 3 operator overloading
//    operator fun Int.times(str: String) = str.repeat(this)       // 1
//    println(2 * "Bye ")                                          // 2
//
//    operator fun String.get(range: IntRange) = substring(range)  // 3
//    val str = "Always forgive your enemies; nothing annoys them so much."
//    println(str[0..14])


    // 4 vararg
    fun printAll(vararg messages: String) {                            // 1
        for (m in messages) println(m)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")                 // 2

    fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "                                          // 4
    )
    fun log(vararg entries: String) {
        printAll(*entries)                                             // 5
    }
    log("Hello", "Hallo", "Salut", "Hola", "你好")
}
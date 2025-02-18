package org.yqj.source.init.examples.flow

fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

fun whenAssign(obj: Any): Any {
    val result = when(obj) {
        1 -> "One"
        "Hello" -> 1
        is Long -> false
        else -> 42
    }
    return result;
}

class MyClass

fun main() {
    // 1 when case
//    cases("Hello")
//    cases(1)
//    cases(0L)
//    cases(MyClass())
//    cases("hello")

    // 2 when assign
    println(whenAssign("Hello"))
    println(whenAssign(3.4))
    println(whenAssign(1))
    println(whenAssign(1L))
    println(whenAssign(MyClass()))
}
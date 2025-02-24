package org.yqj.source.init.examples.func

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
    return operation(x, y)                                          // 2
}

fun sum(x: Int, y: Int) = x + y

fun operation(): (Int) -> Int {                                     // 1
    return ::square
}

fun square(x: Int) = x * x                                          // 2


fun main() {
//    val sumResult = calculate(4, 5, ::sum)                           // 3
//    val mulResult = calculate(4, 5) { a, b -> a * b }                // 4
//    println("sumResult $sumResult, mulResult $mulResult")

    val func = operation()                                          // 3
    println(func(2))
}
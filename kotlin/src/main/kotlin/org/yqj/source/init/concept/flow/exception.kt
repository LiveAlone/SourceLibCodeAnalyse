package org.yqj.source.init.concept.flow

import java.io.FileWriter

open class WithdrawalException(message: String) : Exception(message)
class InsufficientFundsException(message: String) : WithdrawalException(message)

fun processWithdrawal(amount: Double, availableFunds: Double) {
    if (amount > availableFunds) {
        throw InsufficientFundsException("Insufficient funds for the withdrawal.")
    }
    if (amount < 1 || amount % 1 != 0.0) {
        throw WithdrawalException("Invalid withdrawal amount.")
    }
    println("Withdrawal processed")
}


class Person(val name: String?)

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
    // This function will never return successfully.
    // It will always throw an exception.
}

fun main() {

    // 1. 参数校验逻辑
//    val a = 100
//    require(a > 200, { "a should be greater than 200" })

    // 2. 异常捕获场景
//    val num: Int = try {
//        count()
//    } catch (e: ArithmeticException) {
//        -1
//    }
//    println("Result: $num")


    // 3 except catch
//    val availableFunds = 500.0
//    val withdrawalAmount = 500.5
//    val withdrawalAmount = -500.5

//    try {
//        processWithdrawal(withdrawalAmount.toDouble(), availableFunds)
//    } catch (e: InsufficientFundsException) {
//        println("Caught an InsufficientFundsException: ${e.message}")
//    } catch (e: WithdrawalException) {
//        println("Caught a WithdrawalException: ${e.message}")
//    }

    // use 方式， 封装 try-with-resource 逻辑
//    FileWriter("test.txt").use { writer -> writer.write("some text") }

    val person = Person(name = null)
    val s: String = person.name ?: fail("Name required")
    println(s)

}

fun count(): Int {
    val a = 0
    return 10 / a
}
package org.yqj.source.init.concept.classobject

import java.util.function.IntBinaryOperator

//infix fun Int.tt(x: Int): Int {
//    return this * x
//}
//
//// class 定义实现函数
//class IntTransformer: (Int) -> Int {
//    override operator fun invoke(x: Int): Int = TODO()
//}

fun main() {
//    println(1 tt 2)

    // lambda 不同的输入方式
//    val localAdd: (Int, Int) -> Int = { x, y -> x + y }
//    val addOne = fun(x: Int): Int {
//        return x + 1
//    }
//    val a = { i: Int -> i + 1 }
//    println(localAdd)
//    println(addOne)

//    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
//    println(repeatFun("x", 3)) // xxx
//    val twoParameters: (String, Int) -> String = repeatFun // OK
//    fun runTransformation(f: (String, Int) -> String): String {
//        return f("hello", 3)
//    }
//    val result = runTransformation(repeatFun)
//    println(result)

    // lambda 表达式
//    val stringPlus: (String, String) -> String = String::plus
//    val intPlus: Int.(Int) -> Int = Int::plus
//
//    println(stringPlus.invoke("<-", "->"))
//    println(stringPlus("Hello, ", "world!"))
//
//    println(intPlus.invoke(1, 1))
//    println(intPlus(1, 2))
//    println(2.intPlus(3)) // extension-like call


    "".let {  }
}
package org.yqj.source.init.concept.flow

fun main() {
    val a = 100
    val b = 200

    // 1 条件判断，返回max最大值
//    val maxLimit = 1
//    val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b
//    println(maxOrLimit)

    // 2 print max value
//    val max = if (a > b) {
//        println("Choose a")
//        a
//    } else {
//        println("Choose b")
//        b
//    }
//    println(max)

    // 3 when condition
//    val x = 2
//    when (x) {
//        1 -> println("x == 1")
//        2 -> println("x == 2")
//        else -> println("x is neither 1 nor 2")
//    }
//    val text = when (x) {
//        1 -> "x == 1"
//        2 -> "x == 2"
//        else -> "x is neither 1 nor 2"
//    }
//    println(text)


    // for in
//    for (i in 1..3) {
//        print(i)
//    }
//    println()
//    for (i in 6 downTo 0 step 2) {
//        print(i)
//    }

    // break continue
//    loop@ for (i in 1..100) {
//        for (j in 1..100) {
//            if (1 == 1) break@loop
//        }
//    }

    // return label
//    fun foo() {
//        listOf(1, 2, 3, 4, 5).forEach lit@{
//            if (it == 3)
//                return@lit // local return to the caller of the lambda - the forEach loop
//            print(it)
//        }
//        print(" done with explicit label")
//    }
//    fun foo() {
//        listOf(1, 2, 3, 4, 5).forEach {
//            if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
//            print(it)
//        }
//        print(" done with implicit label")
//    }
//    fun foo() {
//        listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
//            if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
//            print(value)
//        })
//        print(" done with anonymous function")
//    }
    fun foo() {
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // non-local return from the lambda passed to run
                print(it)
            }
        }
        print(" done with nested loop")
    }
    foo()

}
package org.yqj.source.init.concept.basic

fun main() {

    // 1 integer type
//    println(Math.PI)
//    val one = 1
//    val threeBi = 3000000000
//    val oneLong: Long = 1L
//    val oneByte: Byte = 1
//    println("$one $threeBi $oneLong $oneByte")

    // 2 float double
//    val pi = 3.14          // Double
////    val one: Double = 1    // Int is inferred
//    val oneDouble = 1.0    // Double
//    val e = 2.7182818284          // Double
//    val eFloat: Float = 2.71828f    // Float, actual value is 2.7182817
//    println("$pi $oneDouble $e $eFloat")
//
//    fun printDouble(x: Double) { print(x) }
//    val x = 1.0
//    val xInt = 1
//    val xFloat = 1.0f
//    printDouble(x)
////    printDouble(xInt)
////    printDouble(xFloat)

    // 3 不同进制输入方式
//    val v = 0x0F
//    val v1 = 0b00001011
//    println("$v $v1")
//
//    val oneMillion = 1_000_000
//    val creditCardNumber = 1234_5678_9012_3456L
//    val socialSecurityNumber = 999_99_9999L
//    val hexBytes = 0xFF_EC_DE_5E
//    val bytes = 0b11010010_01101001_10010100_10010010
//    val bigFractional = 1_234_567.7182818284
//    println("$oneMillion $creditCardNumber $socialSecurityNumber $hexBytes $bytes $bigFractional")

    // 类型转换校验
//    val b: Int = 10000
//    val boxedB: Int? = b
//    val anotherBoxedB: Int? = b
//    println(b == boxedB) // true
//    println(boxedB === anotherBoxedB) // false
//    println(boxedB == anotherBoxedB) // true

    // 不同类型数据不允许比较
//    val a: Int? = 1
//    val b: Long? = a
//    print(b == a)

    // int cal
//    val x = 5 / 2
//    println(x)
//    // println(x == 2.5)
//    println(x == 2)

//    println(Double.NaN == Double.NaN)                 // false
//    println(listOf(Double.NaN) == listOf(Double.NaN)) // true
//    println(0.0 == -0.0)                              // true
//    println(listOf(0.0) == listOf(-0.0))              // false
//    println(listOf(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.0, -0.0).sorted()) // [-Infinity, -0.0, 0.0, Infinity, NaN]


}

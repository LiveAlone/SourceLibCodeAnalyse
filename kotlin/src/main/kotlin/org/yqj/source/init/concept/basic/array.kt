package org.yqj.source.init.concept.basic

fun main() {

    // 1 array string list
//    var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
//    riversArray += "Mississippi"
//    println(riversArray.joinToString())
//
//    // 2 array null
//    val nullArray: Array<Int?> = arrayOfNulls(3)
//    println(nullArray.joinToString())


    // init array
//    var exampleArray = emptyArray<String>()
//    exampleArray += "test"
//    println(exampleArray.joinToString())

    // 3 array index 初始化valueR
//    val initArray = Array<Int>(3) { 0 }
//    println(initArray.joinToString())
//    val asc = Array(5) { i -> (i * i).toString() }
//    asc.forEach { println(it) }

    // nest array
//    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
//    println(twoDArray.contentDeepToString())
//
//    val threeDArray = Array(3) { Array(3) { Array<Int>(3) { 0 } } }
//    println(threeDArray.contentDeepToString())

//    val lettersArray = arrayOf("c", "d")
//    printAllStrings("a", "b", *lettersArray)

    // 集合数据类型转换
    val simpleArray = arrayOf("a", "b", "c", "c")
    println(simpleArray.toList())
    println(simpleArray.toSet())

    val pairArray = arrayOf("apple" to 120, "banana" to 150, "cherry" to 90, "apple" to 140)
    for (pair in pairArray) {
        println(pair)
    }
    println(pairArray.toMap())

}

fun printAllStrings(vararg strings: String) {
    for (string in strings) {
        print(string)
    }
}
package org.yqj.source.init.concept.basic

import org.yqj.source.init.EmptyMain

fun main() {

    // 1. 特殊字符长度
//    val s = "\uD840\uDC40\uD840\uDC87\uD840\uDCCC\uD840\uDD00\uD840\uDD64";
////    println("len size is s: $s len: ${s.length}")
////    val s = "中国"
//    for (c in s) {
//        println(c)
//    }

    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)

    val i = 10
    println("i = $i")
    val letters = listOf("a","b","c","d","e")
    println("Letters: $letters")

    val s = "abc"
    println("$s.length is ${s.length}")

    val price = """${'$'}_9.99
    """.trimMargin()
    println(price)
}
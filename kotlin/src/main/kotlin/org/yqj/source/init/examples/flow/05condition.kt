package org.yqj.source.init.examples.flow

fun main() {
    fun max(a: Int, b: Int) = if (a > b) a else b         // 1
    println(max(99, -42))
}
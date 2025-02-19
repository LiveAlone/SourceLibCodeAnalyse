package org.yqj.source.init.examples.func

fun main() {
    // 1. lambda 变量 函数体 声明类型
    val upperCase1: (String) -> String = { str: String -> str.uppercase() }

    // 2. 变量定义
    val upperCase2: (String) -> String = { str -> str.uppercase()}

    // 3. 函数定义
    val upperCase3 = { str: String -> str.uppercase() }

    // 4 编译失败 无法推断类型
    // val upperCase4 = { str -> str.uppercase() }

    // 5 单个变量 lambda it 代替
    val upperCase5: (String) -> String = { it.uppercase() }

    // 6. 单变量 :: 代替
    val upperCase6: (String) -> String = String::uppercase

    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))

}
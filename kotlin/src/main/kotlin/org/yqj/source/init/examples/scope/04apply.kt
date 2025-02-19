package org.yqj.source.init.examples.scope

data class Person(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun main() {
    // with 类似，创建对象上下文
    // 区别 obj.apply {} 返回的是 obj 对象, 执行函数是在 obj 上下文中
    // 通常用来初始化对象
    val jake = Person()                                     // 1
    val stringDescription = jake.apply {                    // 2
        name = "Jake"                                       // 3
        age = 30
        about = "Android developer"
    }.toString()                                            // 4
    println(stringDescription)
}
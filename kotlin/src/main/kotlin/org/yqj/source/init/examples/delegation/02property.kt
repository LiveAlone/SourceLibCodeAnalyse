package org.yqj.source.init.examples.delegation

import kotlin.reflect.KProperty

class Example {
    var p: String by Delegate()                                               // 1
    override fun toString() = "Example Class"
}

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {        // 2
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) { // 2
        println("$value has been assigned to ${prop.name} in $thisRef")
    }
}

class LazySample {
    init {
        println("created!")            // 1
    }

    // 线程安全使用 blockingLazy
    val lazyStr: String by lazy {
        println("computed!")          // 2
        "my lazy"
    }
}

class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun main() {
    // 1 类属性通过代理方式 完成 get set 操作
    // 代理类 Delegate 实现 getValue setValue 方法
//    val e = Example()
//    println(e.p)
//    e.p = "NEW"

    // 2 lazy 代理方式
//    val sample = LazySample()
//    println("lazyStr = ${sample.lazyStr}")
//    println(" = ${sample.lazyStr}")

    // 3 map delegation
    // 如果支持修改, 需要使用 MutableMap
    val user = User(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))
    println("name = ${user.name}, age = ${user.age}")
}
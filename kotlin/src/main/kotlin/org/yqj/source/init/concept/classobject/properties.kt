package org.yqj.source.init.concept.classobject

//class Rectangle(var width: Int, var height: Int) {
//    val area: Int
//        get() = this.width * this.height
//
//    var setterVisibility: String = "abc"
//        set(value) {
//            field = value.also { println("setting value") }
//        }
//}

//const val NAME: String = "this is const name"

// 3 late init
public class MyTest {
    lateinit var subject: String

    fun setup() {
        subject = "this is subject"
    }

    fun println() {
        println(subject)
    }
}


fun main() {
    // 1. 修改 getter 函数，val 可变操作
//    val rectangle = Rectangle(5, 7)
//    println(rectangle.area) // 35
//    rectangle.width = 50
//    println(rectangle.area) // 350
//
//    println(rectangle.setterVisibility)

    // 2. const name
//    println(NAME)

    // 3 print
    val myTest = MyTest()
    myTest.setup()
    myTest.println()
}
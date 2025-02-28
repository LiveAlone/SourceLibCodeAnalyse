package org.yqj.source.init.concept.classobject


// 1 定义扩展函数类型
//fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
//    val tmp = this[index1] // 'this' corresponds to the list
//    this[index1] = this[index2]
//    this[index2] = tmp
//}

// 2 扩展静态函数, 静态刚发根据Class 类型动态调用
//open class Shape
//class Rectangle: Shape()
//
//fun Shape.getName() = "Shape"
//fun Rectangle.getName() = "Rectangle"
//
//fun printClassName(s: Shape) {
//    println(s.getName())
//    if (s is Rectangle) {
//        println(s.getName())
//    }
//}
// 成员函数优先级默认高于扩展函数
//class Example {
//    fun printFunctionType() { println("Class method") }
//}
//fun Example.printFunctionType() { println("Extension function") }

// 3 print companion
//class MyClass {
//    companion object { }  // will be called "Companion"
//}
//fun MyClass.Companion.printCompanion() { println("companion") }

// 4 Host Connect
//class Host(val hostname: String) {
//    fun printHostname() { print(hostname) }
//}
//
//class Connection(val host: Host, val port: Int) {
//    fun printPort() { print(port) }
//
//    fun Host.printConnectionString() {
//        printHostname()
//        print(":")
//        // 内置对象类似，内置函数支持外部调用
//        // this@Connection.printPort()
//        printPort()
//    }
//
//    fun connect() {
//        host.printConnectionString()   // calls the extension function
//    }
//}


// 5 override extension
//open class Base { }
//
//class Derived : Base() { }
//
//open class BaseCaller {
//    open fun Base.printFunctionInfo() {
//        println("Base extension function in BaseCaller")
//    }
//
//    open fun Derived.printFunctionInfo() {
//        println("Derived extension function in BaseCaller")
//    }
//
//    fun call(b: Base) {
//        b.printFunctionInfo()   // call the extension function
//    }
//}
//
//class DerivedCaller: BaseCaller() {
//    override fun Base.printFunctionInfo() {
//        println("Base extension function in DerivedCaller")
//    }
//
//    override fun Derived.printFunctionInfo() {
//        println("Derived extension function in DerivedCaller")
//    }
//}

fun main() {
//    val list = mutableListOf(1, 2, 3)
//    list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'
//    println(list)

    // 2 print class
//    printClassName(Shape())
//    printClassName(Rectangle())
//    Example().printFunctionType()

    // 3 print companion
//    MyClass.printCompanion()

    // 4 host connect
//    Connection(Host("kotl.in"), 443).connect()
//    println()
//    Connection(Host("kotl2.in"), 4432).connect()


    // 4 base call
    // call 接收Base 对象，执行base 对象的扩展函数
//    BaseCaller().call(Base())
//    DerivedCaller().call(Base())
//    DerivedCaller().call(Derived())
}
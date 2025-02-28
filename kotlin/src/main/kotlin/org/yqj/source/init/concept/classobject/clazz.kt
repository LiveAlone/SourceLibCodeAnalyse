package org.yqj.source.init.concept.classobject

//class Person(val name: String) {
//    val firstProperty = "First property: $name".also(::println)
//    init {
//        // println("test second $secondProperty")   // second not init
//        println("First initializer block that prints $name")
//    }
//
//    val secondProperty = "Second property: ${name.length}".also(::println)
//    init {
//        println("Second initializer block that prints ${name.length}")
//    }
//}
//
//class Empty


// 2 second constructor
//class Person2(val name: String) {
//    val children: MutableList<Person2> = mutableListOf()
//    constructor(name: String, parent: Person2) : this(name) {
//        parent.children.add(this)
//    }
//}
//
//class Constructors {
//    init {
//        println("Init block")
//    }
//
//    constructor(i: Int) {
//        println("Constructor $i")
//    }
//
//    init {
//        println("Init block 2")
//    }
//}

//abstract class Polygon {
//    abstract fun draw()
//}
//
//class Square : Polygon() {
//    override fun draw() {
//        println("Drawing a square")
//    }
//}

// 2 open 函数
//open class Polygon {
//    open fun draw() {
//    }
//}
//
//abstract class WildShape : Polygon() {
//    abstract override fun draw()
//}
//
//class Rectangle : WildShape() {
//    override fun draw() {
//        println("Drawing a rectangle")
//    }
//}


fun main() {
    // 1
//    val p = org.yqj.source.init.concept.flow.Person("Alice")

    // 2 second constructor
//    val c = Constructors(1)
}
package org.yqj.source.init.concept.classobject

//interface MyInterface {
//    val prop: Int // abstract
//
//    val propertyWithImplementation: String
//        get() = "foo"
//
//    fun foo() {
//        print(prop)
//    }
//}
//
//class Child : MyInterface {
//    override val prop: Int = 29
//}


// 2 multi implements
//interface A {
//    fun foo() { println("A") }
//    fun bar()
//}
//
//interface B {
//    fun foo() { println("B") }
//    fun bar() { println("B bar") }
//}
//
//class C : A {
//    override fun bar() { print("C bar") }
//}
//
//class D : A, B {
//    override fun foo() {
//        println("D foo")
//        super<A>.foo()
//        super<B>.foo()
//    }
//
//    override fun bar() {
//        println("D bar")
//        super<B>.bar()
//    }
//}


// 3 sam
//fun interface IntPredicate {
//    fun accept(i: Int): Boolean
//}
//interface Printer {
//    fun print()
//}


// 4 type alias

//typealias IntPredicate = (i: Int) -> Boolean
//val isEven: IntPredicate = { it % 2 == 0 }  // 接口定义类似


fun main() {

    // 1 child
//    val child = Child()
//    child.foo()


    // 2 multi implements
//    val c = C()
//    c.foo()
//    c.bar()
//    val d = D()
//    d.foo()
//    d.bar()

    // 3 sam def
//    val isEven = object : IntPredicate {
//        override fun accept(i: Int): Boolean {
//            return i % 2 == 0
//        }
//    }
    // 简洁写法转换
//    val isEven = IntPredicate { it % 2 == 0 }
//    println(isEven.accept(7))
//    fun Printer(block: () -> Unit): Printer = object : Printer { override fun print() = block() }
//    println(isEven(10))
}
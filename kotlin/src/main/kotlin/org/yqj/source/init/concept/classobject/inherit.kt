package org.yqj.source.init.concept.classobject

// subclass constructor must call super constructor
//open class Base(val x: Int)
//
//class Derived(p: Int) : Base(p)
//
//class Derived2 : Base {
//    constructor(p: Int) : super(p) {
//        println("derived2 constructor")
//    }
//}


// 2 open 函数
//open class Shape {
//    open fun draw() { /*...*/ }
//    fun fill() { /*...*/ }
//
//    open val vertexCount: Int = 0
//}
//
//class Circle() : Shape() {
//    override fun draw() { /*...*/ }
//    override val vertexCount = 4
//}

//interface Shape {
//    val vertexCount: Int
//}
//
//class Rectangle(override val vertexCount: Int = 4) : Shape // Always has 4 vertices
//
//class Polygon : Shape {
//    override var vertexCount: Int = 0  // Can be set to any number later
//}


// 3 construct init
//open class Base(val name: String) {
//    init { println("Initializing a base class") }
//    open val size: Int =
//        name.length.also { println("Initializing size in the base class: $it") }
//}
//
//class Derived(
//    name: String,
//    val lastName: String,
//) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {
//
//    init { println("Initializing a derived class") }
//
//    override val size: Int =
//        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
//}

// 4 super outer
//open class Rectangle {
//    open fun draw() { println("Drawing a rectangle") }
//    val borderColor: String get() = "black"
//}
//
//class FilledRectangle: Rectangle() {
//    override fun draw() {
//        println("FilledRectangle drawing")
//        val filler = Filler()
//        filler.drawAndFill()
//    }
//
//    inner class Filler {
//        fun fill() { println("Filling") }
//        fun drawAndFill() {
//            super@FilledRectangle.draw()
//            fill()
//            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
//        }
//    }
//}

// 5 override multi
//open class Rectangle {
//    open fun draw() {
//        println("Drawing a rectangle")
//    }
//}
//
//interface Polygon {
//    fun draw() {
//        println("Drawing a polygon")
//    } // interface members are 'open' by default
//}
//
//class Square() : Rectangle(), Polygon {
//    override fun draw() {
//        println("Drawing a square")
//        super<Rectangle>.draw() // call to Rectangle.draw()
//        super<Polygon>.draw() // call to Polygon.draw()
//    }
//}


fun main() {

//    val d2 = Derived2(1)
//    print(d2)

//    val c = Circle()
//    println(c.vertexCount)

    // interface property
//    val r = Rectangle()
//    println(r.vertexCount)

//    val p = Polygon()
//    println(p.vertexCount)
//    p.vertexCount = 5
//    println(p.vertexCount)

    // 3 construct init
//    val d = Derived("hello", "world")

    // 4 super outer
//    val filledRectangle = FilledRectangle()
//    filledRectangle.draw()

    // 5 override multi
//    val square = Square()
//    square.draw()
}
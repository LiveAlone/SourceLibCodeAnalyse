package org.yqj.source.init.examples.intro

open class Dog {                // 1
    open fun sayHello() {       // 2
        println("wow wow!")
    }
}

class Yorkshire : Dog() {       // 3
    override fun sayHello() {   // 4
        println("wif wif!")
    }
}

open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

class SiberianTiger : Tiger("Siberia")

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India") // 1

fun main() {
    // 1 inheritance
    val dog: Dog = Yorkshire()
    dog.sayHello()

    // 2 inheritance pass construct
    val tiger: Tiger = SiberianTiger()
    println(tiger)

    // 3 lion default construct
    val lion: Lion = Asiatic("Rufo")                              // 2
    lion.sayHello()

}
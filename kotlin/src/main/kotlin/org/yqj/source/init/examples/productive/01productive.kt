package org.yqj.source.init.examples.productive

fun format(userName: String, domain: String) = "$userName@$domain"

fun findMinMax(list: List<Int>): Pair<Int, Int> {
    return Pair(50, 100)
}

data class User(val username: String, val email: String)    // 1

fun getUser() = User("Mary", "mary@somewhere.com")

class Pair<K, V>(val first: K, val second: V) {  // 1
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}

fun main() {

    // 1 参数命名方式
//    println(format("mario", "example.com"))
//    println(format("domain.com", "username"))
//    println(format(userName = "foo", domain = "bar.com"))
//    println(format(domain = "frog.com", userName = "pepe"))

    // 2 string template
//    val greeting = "Kotliner"
//    println("Hello $greeting")                  // 1
//    println("Hello ${greeting.uppercase()}")    // 2

    // 3 deconstruction declaration。 不用严格执行调用构造函数
    // 3.1 数组解构方式
//    val (x, y, z) = arrayOf(5, 10, 15)
//    println("$x $y $z")
//
//    val map = mapOf("Alice" to 21, "Bob" to 25)
//    for ((name, age) in map) {
//        println("$name is $age years old")
//    }
//
//    val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))
//    println("min=$min, max=$max")
//
//    // 3.2 data class 解构方式
//    val user = getUser()
//    val (username, email) = user                            // 2
//    println("username = $username, email = $email")
//    println(username == user.component1())                  // 3
//    val (_, emailAddress) = getUser()                       // 4
//    println("email = $emailAddress")

    // 4 底层逻辑 component1... componentN 完成解构
//    val (num, name) = Pair(1, "one")
//    // val (num1, name1, age3) = Pair(1, "one") // compile error
//    println("num = $num, name = $name")

    // 5 cast 类型转换

}
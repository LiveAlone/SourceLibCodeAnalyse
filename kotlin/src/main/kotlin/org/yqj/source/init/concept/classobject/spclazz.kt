package org.yqj.source.init.concept.classobject

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

// 1 data class
//data class Person(val name: String) {
//    var age: Int = 0
//}
//data class User(val name: String, val age: Int)

// 2 sealed class
//enum class ErrorSeverity { MINOR, MAJOR, CRITICAL }
//
//sealed class Error(val severity: ErrorSeverity) {
//    class FileReadError(val file: File): Error(ErrorSeverity.MAJOR)
//    class DatabaseError(val source: DataSource): Error(ErrorSeverity.CRITICAL)
//    object RuntimeError : Error(ErrorSeverity.CRITICAL)
//    // Additional error types can be added here
//}

// enum class
// 定义抽象实现
//enum class ProtocolState {
//    WAITING {
//        override fun signal() = TALKING
//    },
//
//    TALKING {
//        override fun signal() = WAITING
//    };
//
//    abstract fun signal(): ProtocolState
//}
//enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
//    PLUS {
//        override fun apply(t: Int, u: Int): Int = t + u
//    },
//    TIMES {
//        override fun apply(t: Int, u: Int): Int = t * u
//    };
//
//    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
//}

//enum class RGB { RED, GREEN, BLUE }
//inline fun <reified T : Enum<T>> printAllValues() {
//    print(enumValues<T>().joinToString { it.name })
//}

// object manager
//object DataProviderManager {
//    private val providers = mutableListOf<DataProvider>()
//    fun registerDataProvider(provider: DataProvider) {
//        providers.add(provider)
//    }
//    val allDataProviders: Collection<DataProvider>
//        get() = providers
//}
//interface DataProvider {
//    fun provideData(): String
//}
//class ExampleDataProvider : DataProvider {
//    override fun provideData(): String {
//        return "Example data"
//    }
//}

// 3 companion object
//class User(val name: String) {
//    // Defines a companion object that acts as a factory for creating User instances
//    companion object Factory {
//        fun create(name: String): User = User(name)
//    }
//}

fun main() {
    // data class
//    val person1 = Person("John")
//    val person2 = Person("John")
//    person1.age = 10
//    person2.age = 20
//    println("person1 == person2: ${person1 == person2}")
//    println("person1 with age ${person1.age}: ${person1}")
//    println("person2 with age ${person2.age}: ${person2}")
//    println("cp1 ${person1.component1()}")

//    val jane = User("Jane", 35)
//    val (name, age) = jane
//    println("$name, $age years of age")

    // enum
//    for (color in RGB.entries) println(color.toString()) // prints RED, GREEN, BLUE
//    println("The first color is: ${RGB.valueOf("RED")}") // prints "The first color is: RED"
//    println(RGB.RED.name)
//    println(RGB.GREEN.ordinal)
//    printAllValues<RGB>()

    // object manager singleton query
//    val exampleProvider = ExampleDataProvider()
//    DataProviderManager.registerDataProvider(exampleProvider)
//    println(DataProviderManager.allDataProviders.map { it.provideData() })

//    val userInstance = User.create("John Doe")
//    println(userInstance.name)
//    val jd = User // comp object
//    println(jd.create("hello"))
}
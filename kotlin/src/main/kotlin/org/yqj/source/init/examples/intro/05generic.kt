package org.yqj.source.init.examples.intro

class MutableStack<E>(vararg items: E) {              // 1

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)        // 2

    fun peek(): E = elements.last()                     // 3

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun main() {
    // 1 mutable stack
//    val stack = MutableStack(0.62, 3.14, 2.7)
//    val stack = MutableStack(0.62, 3.14, 2.7)
//    stack.push(9.87)
//    println(stack)
//
//    println("peek(): ${stack.peek()}")
//    println(stack)
//
//    for (i in 1..stack.size()) {
//        println("pop(): ${stack.pop()}")
//        println(stack)
//    }

    // 2 function generic
//    val stack = mutableStackOf(0.62, 3.14, 2.7)
//    println(stack)
}
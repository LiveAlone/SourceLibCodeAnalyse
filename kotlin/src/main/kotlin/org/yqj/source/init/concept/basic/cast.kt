package org.yqj.source.init.concept.basic

fun demo(x: Any) {
//    if (x is String) {
//        print(x.length) // x is automatically cast to String
//    }
    when (x) {
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
    }
}

fun main() {
    demo("123")
}
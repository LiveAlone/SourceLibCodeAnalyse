package org.yqj.source.init.examples.classes

enum class State {
    IDLE, RUNNING, FINISHED                           // 1
}

enum class Color(val rgb: Int) {                      // 1
    RED(0xFF0000),                                    // 2
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)  // 3
}

fun main() {
    // 1 state validate
//    val state = State.RUNNING                         // 2
//    val message = when (state) {                      // 3
//        State.IDLE -> "It's idle"
//        State.RUNNING -> "It's running"
//        State.FINISHED -> "It's finished"
//    }
//    println(message)

    // num
    val red = Color.RED
    println(red)                                      // 4
    println(red.containsRed())                        // 5
    println(Color.BLUE.containsRed())                 // 6
    println(Color.YELLOW.containsRed())               // 7
    println(red.rgb)                                  // 8
}
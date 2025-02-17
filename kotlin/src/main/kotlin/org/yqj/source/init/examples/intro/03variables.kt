package org.yqj.source.init.examples.intro

fun main() {
    // 1 variable definition
//    val e: Int = 1  // 1
//    println(e)  // 2
//    val d: Int
//    if (false) {
//        d = 1
//    } else {
//        d = 2
//    }
//    println(d)


    // 2 null safety
////    var neverNull: String = "This can't be null"            // 1
////    neverNull = null                                        // 2
////    println(neverNull)
//
//    var nullable: String? = "You can keep a null here"      // 3
//    nullable = null
//    println(nullable)
//    println(describeString(nullable))

}

fun describeString(maybeString: String?): String {              // 1
    if (maybeString != null && maybeString.length > 0) {        // 2
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"                           // 3
    }
}
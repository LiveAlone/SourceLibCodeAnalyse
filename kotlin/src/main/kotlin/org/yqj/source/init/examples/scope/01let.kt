package org.yqj.source.init.examples.scope

fun main() {
    // 1 let 当前对象执行代码块， map 返回代码块结果
    // 2. 场景：null-check 防止执行对象为空
//    val empty = "test".let {
////        customPrint(it)
//        it.isEmpty()
//    }
//    println(" is empty: $empty")

    fun printNonNull(str: String?) {
        println("Printing \"$str\":")

        str?.let {                         // 4
            print("\t")
//            customPrint(it)
            println(it)
        }
    }

    fun printIfBothNonNull(strOne: String?, strTwo: String?) {
        strOne?.let { firstString ->       // 5
            strTwo?.let { secondString ->
//                customPrint("$firstString : $secondString")
                println("both $firstString, $secondString")
            }
        }
    }

//    printNonNull(null)
//    printNonNull("my string")
    printIfBothNonNull("First","Second")
    printIfBothNonNull("First",null)
    printIfBothNonNull(null,"Second")
}
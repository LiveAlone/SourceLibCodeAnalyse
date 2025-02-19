package org.yqj.source.init.examples.scope


fun writeCreationLog(p: Person) {
    println("A new person ${p.name} was created.")
}

fun main() {
    // also 和 apply 类似，返回当前对象。
    // 区别 通过 it 参数方式访问对象
    // 场景 对obj对象进行一些额外的操作方式
    val jake = Person("Jake", 30, "Android developer")
        .also {
            writeCreationLog(it)
        }
}
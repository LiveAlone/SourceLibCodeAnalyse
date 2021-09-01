
tasks.create("hello") {
    doLast {
        val content = "hello world content all"
        println(content)
    }
}

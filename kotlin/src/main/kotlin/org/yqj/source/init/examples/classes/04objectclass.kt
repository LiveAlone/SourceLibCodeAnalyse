package org.yqj.source.init.examples.classes

object DoAuth {                                                 //1
    fun takeParams(username: String, password: String) {        //2
        println("input Auth parameters = $username:$password")
    }
}

class BigBen {
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}

fun main() {

    // 1. object 匿名类创建方式
//    val dayRates = object {                                                     //2
//        var standard: Int = 30
//        var festivity: Int = 50
//        var special: Int = 100
//    }
//    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3
//    print("Total price: $$total")

    // 2. object  init
    DoAuth.takeParams("foo", "qwerty")

    // 3. company object
    BigBen.getBongs(12)
}
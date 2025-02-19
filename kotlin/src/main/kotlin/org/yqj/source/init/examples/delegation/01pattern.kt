package org.yqj.source.init.examples.delegation

interface SoundBehavior {                                                          // 1
    fun makeSound()
}

class ScreamBehavior(val n: String): SoundBehavior {                                // 2
    override fun makeSound() = println("${n.uppercase()} !!!")
}

class RockAndRollBehavior(val n: String): SoundBehavior {                           // 2
    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")
}

class TomAraya(n: String): SoundBehavior by ScreamBehavior(n)                       // 3

class ElvisPresley(n: String): SoundBehavior by RockAndRollBehavior(n)              // 3


fun main() {
    val tomAraya = TomAraya("Thrash Metal")
    tomAraya.makeSound()                                                           // 4
    val elvisPresley = ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound()
}
package org.yqj.source.init.examples.intro

class Customer                                  // 1

data class Contact(val id: Int, var email: String)   // 2


fun main() {
    val customer = Customer()                   // 3

    val contact = Contact(1, "mary@gmail.com")  // 4
    println(contact.id)                         // 5
    contact.email = "jane@gmail.com"            // 6
    println(contact)
}
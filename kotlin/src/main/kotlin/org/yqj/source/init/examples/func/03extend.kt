package org.yqj.source.init.examples.func

data class Item(val name: String, val price: Float)

data class Order(val items: Collection<Item>)

fun Order.maxPricedItemValue(): Float = this.items.maxByOrNull { it.price }?.price ?: 0F
fun Order.maxPricedItemName() = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

val Order.commaDelimitedItemNames: String
    get() = items.map { it.name }.joinToString()

// 2. null 对象 进行扩展
fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"

fun main() {
    // 1 扩展变量属性
    val order = Order(listOf(Item("Bread", 25.0F), Item("Wine", 29.0F), Item("Water", 12.0F)))

    println("Max priced item name: ${order.maxPricedItemName()}")                           // 4
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.commaDelimitedItemNames}")
}
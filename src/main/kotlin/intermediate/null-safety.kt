package com.harukadev.intermediate

fun main() {
    val myInt = 42
    val myDouble = 3.14
    val myList = listOf(1, 2, 3)

    printObjectType(myInt)
    printObjectType(myList)
    printObjectType(myDouble)

    println(tryUppercase("hello"))
    println(tryUppercase(56))
    println(tryUppercase(object {}))
    println(tryUppercase(::printObjectType))
    println(tryUppercase("haruka"))

    val emails: List<String?> = listOf("alice@example.com", null, "bob@example.com", null, "carol@example.com")

    val validEmails = emails.filterNotNull()

    println(validEmails)

    val temperatures = listOf(15, 18, 21, 21, 19, 17, 16)

    val singleHotDay = temperatures.singleOrNull { it == 30 }
    println("Single hot day with 30 degrees: ${singleHotDay ?: "None"}")
}

fun printObjectType(obj: Any) {
    when (obj) {
        is Int -> println("It's an Integer with value $obj")
        !is Double -> println("It's NOT a Double")
        else -> println("Unknown type")
    }
}

fun tryUppercase(value: Any?): String? {
    val text = value as? String
    return text?.uppercase()
}
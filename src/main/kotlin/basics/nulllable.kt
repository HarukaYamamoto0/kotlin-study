@file:Suppress("KotlinConstantConditions")

package com.harukadev.basics

fun main() {
    var neverNull: String = "This can't be null"
    // neverNull = null // Null cannot be a value of a non-null type 'String'.

    var nullable: String? = "This can keep a null here"
    nullable = null // This is OK

    println(nullable)

    var inferredNonNull = "The compile assumes non-nullable"
    // inferredNonNull = null // Null cannot be a value of a non-null type 'String'

    println(strLength("Hello"))
    println(describeString("Hello"))
    println(lengthString("Hello"))
    println(lengthString(null))

    val nullString: String? = null
    println(nullString ?: 0) // 0

    println((1..5).sumOf { id -> salaryById(id) })
}

fun strLength(notNull: String): Int {
    return notNull.length
}

fun describeString(maybeString: String?): String {
    return if (maybeString != null) "String of length ${maybeString.length}"
    else "Empty or null string"
}

fun lengthString(maybeString: String?): Int? = maybeString?.length

data class Employee (val name: String, var salary: Int)

fun employeeById(id: Int) = when(id) {
    1 -> Employee("Mary", 20)
    2 -> null
    3 -> Employee("John", 21)
    4 -> Employee("Ann", 23)
    else -> null
}

fun salaryById(id: Int):Int = employeeById(id)?.salary ?: 0

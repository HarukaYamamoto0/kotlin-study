package com.harukadev.basics

val registeredUsernames = mutableListOf("john_doe", "jane_smith")
val registeredEmails = mutableListOf("john@example.com", "jane@example.com")

fun main() {
    hello()
    println(sum(1, 2))
    loggerWithPrefix("mainFunction", "any message")
    loggerWithPrefix(prefix = "mainFunction", message = "any message")
    loggerWithPrefix(message = "any message", prefix = "mainFunction")
    loggerWithPrefix(message = "any message")

    println(registerUser("john_doe", "jane_smith"))
    println(registerUser("hello", "fakemail"))

    println(upperCase("hello"))
    printMessage()

    val numbers = listOf(0, 2, 6, 4, -5, -9)
    println(numbers.filter(positiveNumbers))
    println(numbers.filter(negativeNumbers))
    println(numbers.map { x: Int -> x * 2 })

    // Self invoke
    println({ text: String -> text.uppercase() }("hello"))
}

fun hello() {
    println("Hello, world!")
}

fun sum(number1: Int, number2: Int): Int {
    return number1 + number2
}

fun loggerWithPrefix(prefix: String = "main", message: String) = println("[$prefix] - $message")

fun registerUser(username: String, email: String): String {
    if (username in registeredUsernames) return "Username already taken. Please choose a different username."
    else if (email in registeredEmails) return "Email already registered. Please use a different email."

    registeredUsernames.add(username)
    registeredEmails.add(email)

    return "User registered successfully: $username"
}

val upperCase = { text: String -> text.uppercase() } // Basically a JavaScript arrow function, but more elegant
val printMessage = { println("fixed message") }

val positiveNumbers = { x: Int -> x > 0 }
val negativeNumbers = { x: Int -> x < 0 }
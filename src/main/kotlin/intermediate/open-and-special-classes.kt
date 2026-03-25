package com.harukadev.intermediate

fun main() {
    val antonov = Plane("Antonov An-225 Mriya", model = "Metal alloy", 1)
    antonov.displayInfo()

    println(greatMammal(Cat("Lila")))

    val state = State.RUNNING
    val message = when (state) {
        State.IDLE -> "It's idle"
        State.RUNNING -> "It's running"
        State.FINISHED -> "It's finished"
    }
    println(message)

    val red = Color.RED
    println(red.containsRed())
    println(Color.BLUE.containsRed())
    println(Color.YELLOW.containsRed())

    val myEmail = Email("example@example.com")
    sendEmail(myEmail)
}

open class Vehicle(val make: String, val model: String) {
    open fun displayInfo() {
        println("Vehicle Info: Make - $make, Model - $model")
    }
}

class Plane(make: String, model: String, val numberOfDoors: Int) : Vehicle(make, model) {
    override fun displayInfo() {
        println("Plane Info: Make - ${make}, Model - ${model}, Number of doors - ${numberOfDoors}")
    }
}

sealed class Mammal(val name: String)

class Cat(catName: String) : Mammal(catName)
class Human(humanName: String, val job: String) : Mammal(humanName)

fun greatMammal(mammal: Mammal): String {
    return when (mammal) {
        is Human -> "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> "Hello ${mammal.name}"
    }
}

enum class State {
    IDLE, RUNNING, FINISHED
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

@JvmInline // The @JvmInline annotation instructs Kotlin to optimize the code during compilation.
value class Email(val address: String) {
    fun checkEmail() {
        println("Checked")
    }
}

fun sendEmail(email: Email) {
    email.checkEmail()
    println("Sending email to ${email.address}")
}
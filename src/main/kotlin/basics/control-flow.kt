@file:Suppress("KotlinConstantConditions")

package com.harukadev.basics

fun main() {
    // If
    println("\n================= If =================\n")

    val d: Int
    val check = true

    @Suppress("LiftReturnOrAssignment")
    if (check) {
        d = 1
    } else {
        d = 0
    }

    println(d)

    val a = 1
    val b = 2

    @Suppress("KotlinConstantConditions")
    println(if (a > b) a else b)

    // When
    println("\n================= When =================\n")

    val message = "hello world"

    @Suppress("KotlinConstantConditions")
    when (message) {
        "hello" -> println("hello")
        "1" -> println("Number")
        "hello world" -> println("Greeting")
        else -> println("Unknown message")
    }

    val trafficLightState = "Red"

    val trafficActions = when (trafficLightState) {
        "Green" -> "Go"
        "Yellow" -> "Slow down"
        "Red" -> "Stop"
        else -> "Malfunction"
    }

    println(trafficActions)

    // Ranges
    println("\n================= Ranges =================\n")

    println((1..4).joinToString())
    println((1..<4).joinToString())
    println((4 downTo 1 step 2).joinToString())
    println(('a'..'d').joinToString())
    println(('z' downTo 'd').joinToString())


    // For
    println("\n================= For =================\n")

    var counter = 0
    for (number in 1..9) {
        counter = counter + number
    }
    println(counter)

    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) println("Yummy, it's a $cake cake!")

    // While
    println("\n================= While =================\n")

    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }

    do {
        println("Bake a cake")
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}
package com.harukadev

fun main() {
    // Lists
    println("\n================= List =================\n")
    val readOnlyShapes = listOf("triangle", "square", "square", "circle")
    println(readOnlyShapes.joinToString(" - "))

    val mutableShapes = mutableListOf("triangle", "square", "square", "circle")

    mutableShapes.add("rectangle")
    mutableShapes.addAll(listOf("cone", "cylinder", "pyramid"))
    mutableShapes.remove("cylinder")
    mutableShapes.remove("square")
    mutableShapes.addFirst("hexagon")
    mutableShapes.addLast("pentagon")
    mutableShapes.add(6, "diamond")

    println(mutableShapes.joinToString(" - "))

    val shapesLocked: List<String> = mutableShapes // here it creates a read-only copy

    println("The first item in the list is: ${shapesLocked.first()}")
    println("This list has ${shapesLocked.count()} items")

    if ("circle" in shapesLocked) {
        println("Yes, the circle is on the list.")
    } else {
        println("No, the circle is not on the list.")
    }

    // Set
    println("\n================= Set =================\n")

    val readOnlyFruit = setOf("apple", "banana", "banana", "orange", "orange") // remove duplicates
    println(readOnlyFruit.joinToString(" - "))

    val mutableFruits = readOnlyFruit.toMutableSet()
    mutableFruits.remove("apple")

    println(mutableFruits.joinToString(" - "))
    println("This set has ${mutableFruits.count()} items")

    val fruitsLocked: Set<String> = mutableFruits
    println("The fruits locked: $fruitsLocked")

    // Map
    println("\n================= Map =================\n")

    val readOnlyJuiceMenu =
        mapOf("apple" to 2, "kiwi" to 2, "orange" to 2, "orange" to 3) // no remove duplicates
    println(readOnlyJuiceMenu)

    val mutableJuiceMenu: MutableMap<String, Int> = readOnlyJuiceMenu.toMutableMap()
    println(mutableJuiceMenu)

    mutableJuiceMenu.remove("kiwi")

    val juiceMenuLocked: Map<String, Int> = mutableJuiceMenu.toMap()
    println(juiceMenuLocked)

    println("The value of pineapple juice is: ${mutableJuiceMenu["pineapple"]}")

    mutableJuiceMenu["coconut"] = 150
    println("The value of coconut juice is: ${mutableJuiceMenu["coconut"]}")

    println("This map has ${mutableJuiceMenu.count()} key-value pairs")

    println(mutableJuiceMenu.keys)
    println(mutableJuiceMenu.values)

    if ("coconut" in mutableJuiceMenu) {
        println("Yes, the coconut is on the map.")
    } else {
        println("No, the coconut is not on the map.")
    }

    if ("pineapple" in mutableJuiceMenu.keys) println("No, the pineapple is not on the map.")
    if (3 in mutableJuiceMenu.values) println("Yes, in those times fruits that cost 3")
}

package com.harukadev.intermediate

import kotlin.properties.Delegates.observable
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

fun main() {
    val me = Person("albert", "last")
    println(me.age)
    me.age = 22
    println(me.age)
    println(me.fullName)
    println(me.age)

    val user = User("Haruka", "Yamamoto")
    println(user.firstName)
    println(user.displayName)
    println(user.displayName)

    val thermostat = Thermostat()
    println(thermostat.temperature2)
    thermostat.temperature2 = 22.5
    thermostat.temperature2 = 27.0

    val inventory = listOf(3, 0, 7, 0, 5)
    println(findOutOfStockBooks(inventory))
}

class Person(val firstName: String, val lastName: String) {
    var age: Int = 40
        get() {
            return field + field
        }
        set(value) {
            field = value / 2
        }
}

private val Person.fullName: String
    get() {
        age = 20 // Here, I have access
        return "$firstName $lastName"
    }

class CachedStringDelegate {
    var cachedValue: String? = null

    operator fun getValue(thisRef: Any?, property: Any?): String {
        if (cachedValue == null) {
            cachedValue = "Default value"
            println("Computed and cached: $cachedValue")
        } else {
            println("Accessed from cache: $cachedValue")
        }
        return cachedValue ?: "Unknow"
    }
}

class User(val firstName: String, val lastName: String) {
    val displayName: String by CachedStringDelegate()
}

class Thermostat {
    var temperature: Double by observable(20.0) { _, old, new ->
        if (new >= 25) {
            println("Warning: Temperature is too high! ($old°C -> $new°C)")
        } else {
            println("Temperature updated: $old°C -> $new°C")
        }
    }

    var temperature2: Double by myObservable(20.0) { _, old, new ->
        if (new >= 25) {
            println("Warning: Temperature is too high! ($old°C -> $new°C)")
        } else {
            println("Temperature updated: $old°C -> $new°C")
        }
    }
}

fun <T> myObservable(
    initialValue: T,
    changes: (property: KProperty<*>, old: T, new: T) -> Unit
): ObservableProperty<T> {
    return object : ObservableProperty<T>(initialValue) {
        override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
            changes(property, oldValue, newValue)
        }
    }
}

fun findOutOfStockBooks(inventory: List<Int>): List<Int> {
    return buildList {
        for (index in inventory.indices) {
            if (inventory[index] == 0) add(index)
        }
    }
}

val Double.asMiles: Double
    get() {
        return this * 0.621371
    }
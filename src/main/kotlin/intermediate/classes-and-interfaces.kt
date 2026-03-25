package com.harukadev.intermediate

fun main() {
    val car1 = Car("Toyota", "Corolla", 4)
    println("Car1: make=${car1.make}, model=${car1.model}, numberOfDoors=${car1.numberOfDoors}")

    val laptop = Electronic(name = "Laptop", price = 1000.0, warranty = 2)
    println(laptop.productInfo())

    val paymentMethod = CreditCardPayment("1234 5678 9012 3456", "John Doe", "12/25")
    println(paymentMethod.initiatePayment(100.0))
    println("Payment is by ${paymentMethod.paymentType}")

    val livingRoomLight = SmartLight("Living Room Light")
    val bedroomThermostat = SmartThermostat("Bedroom Thermostat")

    livingRoomLight.turnOn()
    // Living Room Light is now ON.
    livingRoomLight.adjustBrightness(10)
    // Adjusting Living Room Light brightness to 10%.
    livingRoomLight.turnOff()
    // Living Room Light is now OFF.

    bedroomThermostat.turnOn()
    // Bedroom Thermostat is now heating.
    bedroomThermostat.adjustTemperature(5)
    // Bedroom Thermostat set to 5°C.
    bedroomThermostat.turnOff()
    // Bedroom Thermostat is now off.

    val audio = Audio("Symphony No. 5", "Beethoven")
    audio.play()
}

class Car(val make: String, val model: String, val numberOfDoors: Int)

abstract class Animal {
    abstract val sound: String

    abstract fun makeSound()
}

abstract class Product(val name: String, val price: Double) {
    abstract val category: String

    fun productInfo(): String {
        return "Product: $name, Category: $category, Price: $price"
    }
}

class Electronic(name: String, price: Double, val warranty: Int) : Product(name, price) {
    override val category = "Electronic"
}

interface PaymentMethod {
    fun initiatePayment(amount: Double): String
}

interface PaymentType {
    val paymentType: String
}

class CreditCardPayment(
    val cardNumber: String, val cardHolderName: String, val expiryDate: String,
    override val paymentType: String = "Credit Card"
) : PaymentMethod,
    PaymentType {
    override fun initiatePayment(amount: Double): String {
        return "Payment of $$amount initiated using Credit Card ending in ${cardNumber.takeLast(4)}."
    }
}

abstract class SmartDevice(val name: String) {
    abstract fun turnOn()
    abstract fun turnOff()
}

class SmartLight(name: String) : SmartDevice(name) {
    override fun turnOn() {
        println("$name is now ON.")
    }

    override fun turnOff() {
        println("$name is now OFF.")
    }

    fun adjustBrightness(level: Int) {
        println("Adjusting $name brightness to $level%.")
    }
}

class SmartThermostat(name: String) : SmartDevice(name) {
    override fun turnOn() {
        println("$name thermostat is now heating.")
    }

    override fun turnOff() {
        println("$name thermostat is now off.")
    }

    fun adjustTemperature(temperature: Int) {
        println("$name thermostat set to $temperature°C.")
    }
}

interface Media {
    val title: String
    fun play()
}

class Audio(override val title: String, val composer: String) : Media {
    override fun play() {
        println("Playing audio: $title, composed by $composer")
    }
}
